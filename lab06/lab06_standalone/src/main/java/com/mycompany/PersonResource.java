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
import com.mycompany.errors.NotFoundException;
import java.io.IOException;
import sun.misc.BASE64Decoder;

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
            @QueryParam("birthplace") String birthplace, @QueryParam("university") String university, 
            @HeaderParam("authorization") String authString) throws NotFoundException {

        //auth
        if (!isUserAuthenticated(authString)) {
            System.out.println("User not authenticated");
            throw new NotFoundException("Authentication error!");
        }
        System.out.println("Successful Authorization!!!");
        Person newPerson = new Person(name, surname, age, birthplace, university);
        PostgreSQLDAO dao = new PostgreSQLDAO();
        Integer newPersonId = dao.createPerson(newPerson);
        return newPersonId.toString();
    }

    @PUT
    public String updatePersons(@QueryParam("name") String name, @QueryParam("surname") String surname, @QueryParam("age") Integer age,
            @QueryParam("birthplace") String birthplace, @QueryParam("university") String university, @QueryParam("id") int id, 
            @HeaderParam("authorization") String authString) throws NotFoundException {

        //auth
        if (!isUserAuthenticated(authString)) {
            System.out.println("User not authenticated");
            throw new NotFoundException("Authentication error!");
        }
        
        Person newPerson = new Person(name, surname, age, birthplace, university);
        String updateInfo = new PostgreSQLDAO().updatePerson(id, newPerson);
        return updateInfo;
    }

    @DELETE
    public String deletePersons(@QueryParam("id") int id, @HeaderParam("authorization") String authString) throws NotFoundException {
        //auth
        if (!isUserAuthenticated(authString)) {
            System.out.println("User not authenticated");
            throw new NotFoundException("Authentication error!");
        }
        
        String deleteInfo = new PostgreSQLDAO().deletePerson(id);
        return deleteInfo;
    }

    private boolean isUserAuthenticated(String authString) {

        String decodedAuth = "";
        // Header is in the format "Basic 5tyc0uiDat4"
        // We need to extract data before decoding it back to original string
        String[] authParts = authString.split("\\s+");
        String authInfo = authParts[1];
        // Decode the data back to original string
        byte[] bytes = null;
        try {
            bytes = new BASE64Decoder().decodeBuffer(authInfo);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        decodedAuth = new String(bytes);
        //System.out.println(decodedAuth);
        /**
         * here you include your logic to validate user authentication. it can
         * be using ldap, or token exchange mechanism or your custom
         * authentication mechanism.
         */
        return "username:password".equals(decodedAuth);
    }
}
