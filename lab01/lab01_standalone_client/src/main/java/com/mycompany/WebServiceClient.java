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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 *
 * @author nikolay
 */
public class WebServiceClient {
    public static void main(String[] args) throws MalformedURLException {
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
            System.out.println("name: " + person.getName() + ", surname: " + person.getSurname() + ", age: " + person.getAge() + ", birthplace: " + person.getBirthplace()+ ", university: " + person.getUniversity());
        }
        System.out.println("Total persons: " + persons.size());
    }
}
