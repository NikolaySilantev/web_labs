/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nikolay
 */
public class PostgreSQLDAO {
    private final ArrayList<String> fieldsNames = new ArrayList<>(Arrays.asList("name", "surname", "age", "birthplace", "university"));
    private final String SELECT = "SELECT * FROM persons p WHERE (?::character varying(200) is null OR p.name = ?::character varying(200) ) "
            + "and (?::character varying(200) is null OR p.surname = ?::character varying(200)) and (?::integer is null OR p.age = ?::integer) "
            +"and (?::character varying(200) is null OR p.birthplace = ?::character varying(200)) "
            + "and (?::character varying(200) is null OR p.university = ?::character varying(200))";

    public List<Person> getPersons(List<Fields> fields) {
        List<Person> persons = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement preparedStmt = connection.prepareStatement(SELECT);

            Map<String, Object> args = new HashMap<>();
            for (String s:fieldsNames
            ) {
                args.put(s,null);
            }

            for (Fields f:fields
            ) {
                args.put(f.getField(), f.getValue());
            }

            args.remove("");

            for (int i=0; i<fieldsNames.size(); i++) {
                preparedStmt.setObject(i*2+1, args.get(fieldsNames.get(i)));
                preparedStmt.setObject(1 + i * 2 + 1, args.get(fieldsNames.get(i)));
            }

            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");
                String birthplace = rs.getString("birthplace");
                String university = rs.getString("university");
                Person person = new Person(name, surname, age, birthplace, university);
                persons.add(person);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return persons;
    }
}
