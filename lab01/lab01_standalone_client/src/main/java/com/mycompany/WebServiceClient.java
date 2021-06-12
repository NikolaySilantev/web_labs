/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.Person;
import com.mycompany.PersonService;
import com.mycompany.FindRequest;
import com.mycompany.FieldsInter;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 *
 * @author nikolay
 */
public class WebServiceClient {

    public static void main(String[] args) throws MalformedURLException, InterruptedException, ExecutionException, FileNotFoundException, IOException {
        URL url = new URL("http://localhost:8080/PersonService?wsdl");
        PersonService personService = new PersonService(url);
        FindRequest findRequest = new FindRequest();
        List<FieldsInter> fieldsInterList = findRequest.getFields();

        FieldsInter fieldsInter = new FieldsInter();
        fieldsInter.setField("age");
        fieldsInter.setValue("26");

        fieldsInterList.add(fieldsInter);

        List<Person> persons = personService.getPersonWebServicePort().getPersons(findRequest);
        for (Person person : persons) {
            System.out.println("name: " + person.getName() + ", surname: " + person.getSurname() + ", age: " + person.getAge() + ", birthplace: " + person.getBirthplace() + ", university: " + person.getUniversity());
        }
        System.out.println("Total persons: " + persons.size());

        // #7
        Callable task = () -> {
            fieldsInter.setField("birthplace");
            fieldsInter.setValue("Москва");
            fieldsInterList.add(fieldsInter);

            return personService.getPersonWebServicePort().getPersons(findRequest);
        };
        FutureTask<List<Person>> future = new FutureTask<>(task);
        Thread thread = new Thread(future);
        thread.start();
        while (thread.isAlive()) {
            System.out.println("Some work!"); // some useful work while waiting
        }
        persons = future.get();

        for (Person person : persons) {
            System.out.println("name: " + person.getName() + ", surname: " + person.getSurname() + ", age: " + person.getAge() + ", birthplace: " + person.getBirthplace() + ", university: " + person.getUniversity());
        }
        System.out.println("Total persons: " + persons.size());
        
        // downloads file
        String fileName = "picture1.jpg";
        String filePath = "src/resources/" + fileName;
        byte[] fileBytes = personService.getPersonWebServicePort().download(fileName);

        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            BufferedOutputStream outputStream = new BufferedOutputStream(fos);
            outputStream.write(fileBytes);
            outputStream.close();

            System.out.println("File downloaded: " + filePath);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
