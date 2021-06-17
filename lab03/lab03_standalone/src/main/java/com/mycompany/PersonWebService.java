/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.errors.NotFoundException;
import com.mycompany.errors.PersonServiceFault;

import com.mycompany.interaction.CreateRequest;
import com.mycompany.interaction.FieldsInter;
import com.mycompany.interaction.FindRequest;
import com.mycompany.interaction.UpdateRequest;

import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Map;
import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;


/**
 *
 * @author nikolay
 */

@WebService(serviceName = "PersonService", endpointInterface = "com.mycompany.PersonWebServiceInterface")
public class PersonWebService implements PersonWebServiceInterface {
    
    @Resource
    WebServiceContext wsctx;
    
    public String Auth(MessageContext mctx) throws NotFoundException{
        
    
        
    //get detail from request headers
        Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        List userList = (List) http_headers.get("Username");
        List passList = (List) http_headers.get("Password");

        String username = "";
        String password = "";
        
        if(userList!=null){
        	//get username
        	username = userList.get(0).toString();
        }
        	
        if(passList!=null){
        	//get password
        	password = passList.get(0).toString();
        }
        	
        //Should validate username and password with database
        if (username.equals("username") && password.equals("password")){
        	return "Hello World JAX-WS - Valid User!";
        }else{
        	PersonServiceFault fault = PersonServiceFault.defaultInstance();
                throw new NotFoundException("Unknown user!", fault);
        }
       
    }	
    
    @Override
    public String getPersons(@WebParam(name = "Request") FindRequest findRequest) {
        List<Fields> fields = new ArrayList<>();
        for(FieldsInter f : findRequest.getFields())
        {
            fields.add(new Fields(f.getField(),f.getValue()));
        }

        PostgreSQLDAO dao = new PostgreSQLDAO();
        List<Person> persons = dao.getPersons(fields);
        
        String result="";
        for (Person person : persons) {
            result=result+("name: " + person.getName() + ", surname: " + person.getSurname() + ", age: " + person.getAge() + ", birthplace: " + person.getBirthplace() + ", university: " + person.getUniversity()+'\n');
            result=result+'\n'+("Total persons: " + persons.size());
        }
        
        return result;
    }
    
    @Override
    public int createPersons(@WebParam(name = "Request") CreateRequest createRequest) throws NotFoundException {
        MessageContext mctx = wsctx.getMessageContext();
        System.out.println(Auth(mctx));
        
        Person newPerson = new Person(createRequest.getName(), createRequest.getSurname(), createRequest.getAge(), createRequest.getBirthplace(), createRequest.getUniversity());
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.createPerson(newPerson);
    }
    
    @Override
    public String updatePersons(@WebParam(name = "Request") UpdateRequest updateRequest) throws NotFoundException {
        MessageContext mctx = wsctx.getMessageContext();
        System.out.println(Auth(mctx));
        
        Person newPerson = new Person(updateRequest.getName(), updateRequest.getSurname(), updateRequest.getAge(), updateRequest.getBirthplace(), updateRequest.getUniversity());
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.updatePerson(updateRequest.getId(), newPerson);
    }
    
    @Override
    public String deletePersons(@WebParam(name = "Id") int id) throws NotFoundException {
        MessageContext mctx = wsctx.getMessageContext();
        System.out.println(Auth(mctx));
        
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.deletePerson(id);
    }
}