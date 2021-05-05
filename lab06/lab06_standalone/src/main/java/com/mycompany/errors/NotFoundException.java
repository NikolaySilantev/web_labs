/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.errors;

/**
 *
 * @author nikolay
 */
public class NotFoundException extends Exception {

    public static NotFoundException DEFAULT_INSTANCE = new NotFoundException("My web service exception");

    public NotFoundException(String message) {
        super(message);
    }
}
