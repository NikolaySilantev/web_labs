/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

/**
 *
 * @author nikolay
 */
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/persons")
@Produces({MediaType.APPLICATION_JSON})
public class PersonResource {

    @GET
    public List<Person> getPersons(@QueryParam("name") String name, @QueryParam("surname") String surname, @QueryParam("age") Integer age, 
            @QueryParam("birthplace") String birthplace, @QueryParam("university") String university) {
        List<Fields> fields = new ArrayList<>();
        
        fields.add(new Fields("name", name));
        fields.add(new Fields("surname", surname));
        fields.add(new Fields("age", age));
        fields.add(new Fields("birthplace", birthplace));
        fields.add(new Fields("university", university));
        
        List<Person> persons = new PostgreSQLDAO().getPersons(fields); 
        return persons;
    }
}
