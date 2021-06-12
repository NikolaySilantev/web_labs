/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interaction;

import java.util.List;

/**
 *
 * @author nikolay
 */
public class GetPersonResponse {
    private List<com.mycompany.Person> persons;

    public GetPersonResponse() {
    }

    public List<com.mycompany.Person> getPersons() {
        return persons;
    }

    public void setPersons(List<com.mycompany.Person> persons) {
        this.persons = persons;
    }
    
}