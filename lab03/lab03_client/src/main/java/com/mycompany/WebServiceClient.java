package com.mycompany;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author nikolay
 */
public class WebServiceClient {

    public static void main(String[] args) throws MalformedURLException, NotFoundException {
        URL url = new URL("http://localhost:8080/PersonService?wsdl");
        QName qName=new QName("http://mycompany.com/","PersonService");
        
        //PersonService personService = new PersonService(url);
        Service personService = Service.create(url, qName);

        PersonWebServiceInterface wsPort = personService.getPort(PersonWebServiceInterface.class);

        // Add username and password for Basic Authentication
        Map<String, Object> reqContext = ((BindingProvider) wsPort).getRequestContext();
        //reqContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("Username", Collections.singletonList("userndsaame"));
        headers.put("Password", Collections.singletonList("password"));
        //reqContext.put(BindingProvider.USERNAME_PROPERTY, "username");
        //reqContext.put(BindingProvider.PASSWORD_PROPERTY, "password");
        reqContext.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
        
        FindRequest findRequest = new FindRequest();
        List<FieldsInter> fieldsInterList = findRequest.getFields();

        FieldsInter fieldsInter = new FieldsInter();
        fieldsInter.setField("age");
        fieldsInter.setValue("26");

        fieldsInterList.add(fieldsInter);

        String persons = wsPort.getPersons(findRequest);

        System.out.println(persons);

        CreateRequest createRequest = new CreateRequest();
        createRequest.setName("????????????????????");
        createRequest.setSurname("????????????");
        createRequest.setAge(26);
        createRequest.setBirthplace("???????????? ????????????????");
        createRequest.setUniversity("?????????????????????????? ?????????????????????????????? ?????????????????????? ????. ??. ??. ????????????????????????");
        Integer id = 1;
        try {
             id = wsPort.createPersons(createRequest);
             System.out.println("Person " + "(" + id.toString() + ")" + " has been created");
        } catch (NotFoundException foundException) {
            System.out.println(foundException.getMessage());
        }

        

        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.setName("????????????????????");
        updateRequest.setSurname("????????????");
        updateRequest.setAge(27);
        updateRequest.setBirthplace("???????????? ????????????????");
        updateRequest.setUniversity("?????????????????????? ????????");
        updateRequest.setId(id);
        
        try {
             System.out.println(wsPort.updatePersons(updateRequest));
        } catch (NotFoundException foundException) {
            System.out.println(foundException.getMessage());
        }
        
        
        try {
             System.out.println(wsPort.deletePersons(id));
        } catch (NotFoundException foundException) {
            System.out.println(foundException.getMessage());
        }

        

        try {
            wsPort.deletePersons(id);
        } catch (NotFoundException foundException) {
            System.out.println(foundException.getClass().getName() + " " + foundException.getMessage());
        }
    }
}
