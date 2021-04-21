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
public class Person {
    private String name;
    private String surname;
    private int age;
    private String birthplace;
    private String university;
    
    public Person() {
    }
    public Person(String name, String surname, int age, String birthplace, String university) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.birthplace=birthplace;
        this.university=university;
    }
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

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", surname=" + surname + ", age=" + age + ", birthplace=" + birthplace + ", university=" + university + '}';
    }
}
