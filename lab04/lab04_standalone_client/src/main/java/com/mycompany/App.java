/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import java.util.List;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author nikolay
 */
public class App {

    private static final String URL = "http://localhost:8080/rest/persons";

    public static void main(String[] args) {
        Client client = Client.create();
        printList(getPerson(client, null, null, null, null, null));
        System.out.println();
        printList(getPerson(client, null, null, null, "Санкт-Петербург", "Университет ИТМО"));
    }

    private static List<Person> getPerson(Client client, String name, String surname, String age, String birthplace, String university) {
        WebResource webResource = client.resource(URL);

        if (name != null) webResource = webResource.queryParam("name", name);
        if (surname != null) webResource = webResource.queryParam("surname", surname);
        if (age != null) webResource = webResource.queryParam("age", age);
        if (birthplace != null) webResource = webResource.queryParam("birthplace", birthplace);
        if (university != null) webResource = webResource.queryParam("university", university);
        
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }
        GenericType<List<Person>> type = new GenericType<List<Person>>() {
        };
        return response.getEntity(type);
    }

    private static void printList(List<Person> persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
