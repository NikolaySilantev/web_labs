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

    @POST
    public String createPersons(@QueryParam("name") String name, @QueryParam("surname") String surname, @QueryParam("age") Integer age,
            @QueryParam("birthplace") String birthplace, @QueryParam("university") String university) {

        Person newPerson = new Person(name, surname, age, birthplace, university);
        PostgreSQLDAO dao = new PostgreSQLDAO();
        Integer newPersonId = dao.createPerson(newPerson);
        return newPersonId.toString();
    }

    @PUT
    public String updatePersons(@QueryParam("name") String name, @QueryParam("surname") String surname, @QueryParam("age") Integer age,
            @QueryParam("birthplace") String birthplace, @QueryParam("university") String university, @QueryParam("id") int id) {

        Person newPerson = new Person(name, surname, age, birthplace, university);
        String updateInfo = new PostgreSQLDAO().updatePerson(id, newPerson);
        return updateInfo;
    }

    @DELETE
    public String deletePersons(@QueryParam("id") int id) {
        String deleteInfo = new PostgreSQLDAO().deletePerson(id);
        return deleteInfo;
    }
}
