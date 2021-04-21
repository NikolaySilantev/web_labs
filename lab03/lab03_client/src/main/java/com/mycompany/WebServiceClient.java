package com.mycompany;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 *
 * @author nikolay
 */
public class WebServiceClient {
    public static void main(String[] args) throws MalformedURLException, NotFoundException {
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
        
        CreateRequest createRequest = new CreateRequest();
        createRequest.setName("Иннокентий");
        createRequest.setSurname("Иванов");
        createRequest.setAge(26);
        createRequest.setBirthplace("Нижний Новгород");
        createRequest.setUniversity("Нижегородский государственный университет им. Н. И. Лобачевского");
        Integer id = personService.getPersonWebServicePort().createPersons(createRequest);
        System.out.println("Person " + "(" + id.toString() + ")" + " has been created");
        
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.setName("Иннокентий");
        updateRequest.setSurname("Иванов");
        updateRequest.setAge(27);
        updateRequest.setBirthplace("Нижний Новгород");
        updateRequest.setUniversity("Университет ИТМО");
        updateRequest.setId(id);
        System.out.println(personService.getPersonWebServicePort().updatePersons(updateRequest));
        
        System.out.println(personService.getPersonWebServicePort().deletePersons(id));
        
        try {
            personService.getPersonWebServicePort().deletePersons(id);
        } catch (NotFoundException foundException) {
            System.out.println(foundException.getClass().getName() + " " + foundException.getMessage());
        }
    }
}
