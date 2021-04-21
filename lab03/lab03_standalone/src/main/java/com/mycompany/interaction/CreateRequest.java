/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interaction;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nikolay
 */
@XmlRootElement(name = "createRequest")
public class CreateRequest implements Serializable {
    private String name;
    private String surname;
    private int age;
    private String birthplace;
    private String university;
    

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getAge() {
        return age;
    }
    public String getBirthplace() {
        return birthplace;
    }
    public String getUniversity() {
        return university;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }
    public void setUniversity(String university) {
        this.university = university;
    }
}