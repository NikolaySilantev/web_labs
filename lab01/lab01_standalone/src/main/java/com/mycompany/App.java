/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import javax.xml.ws.Endpoint;

/**
 *
 * @author nikolay
 */
public class App {
    public static void main(String[] args) {
        String url = "http://0.0.0.0:8080/PersonService";
        Endpoint.publish(url, new PersonWebService());
    }
}
