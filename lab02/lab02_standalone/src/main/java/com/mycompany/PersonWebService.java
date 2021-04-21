/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.interaction.CreateRequest;
import com.mycompany.interaction.FieldsInter;
import com.mycompany.interaction.FindRequest;
import com.mycompany.interaction.UpdateRequest;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;


/**
 *
 * @author nikolay
 */
@WebService(serviceName = "PersonService")
public class PersonWebService {
    @WebMethod(operationName = "getPersons")
    public List<Person> getPersons(@WebParam(name = "Request") FindRequest findRequest) {

        List<Fields> fields = new ArrayList<>();
        for(FieldsInter f : findRequest.getFields())
        {
            fields.add(new Fields(f.getField(),f.getValue()));
        }

        PostgreSQLDAO dao = new PostgreSQLDAO();
        List<Person> persons = dao.getPersons(fields);

        return persons;
    }
    
    @WebMethod(operationName = "createPersons")
    public int createPersons(@WebParam(name = "Request") CreateRequest createRequest) {
        Person newPerson = new Person(createRequest.getName(), createRequest.getSurname(), createRequest.getAge(), createRequest.getBirthplace(), createRequest.getUniversity());
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.createPerson(newPerson);
    }
    
    @WebMethod(operationName = "updatePersons")
    public String updatePersons(@WebParam(name = "Request") UpdateRequest updateRequest) {
        Person newPerson = new Person(updateRequest.getName(), updateRequest.getSurname(), updateRequest.getAge(), updateRequest.getBirthplace(), updateRequest.getUniversity());
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.updatePerson(updateRequest.getId(), newPerson);
    }
    
    @WebMethod(operationName = "deletePersons")
    public String deletePersons(@WebParam(name = "Id") int id) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.deletePerson(id);
    }
}
