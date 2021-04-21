/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.interaction.FieldsInter;
import com.mycompany.interaction.FindRequest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.sql.DataSource;


/**
 *
 * @author nikolay
 */
@WebService(serviceName = "PersonService")
public class PersonWebService {
    //@Resource(lookup = "jdbc/ifmo-ws")
    private DataSource dataSource;
    @WebMethod(operationName = "getPersons")
    public List<Person> getPersons(@WebParam(name = "fields") FindRequest findRequest) {

        List<Fields> fields = new ArrayList<>();
        for(FieldsInter f : findRequest.getFields())
        {
            fields.add(new Fields(f.getField(),f.getValue()));
        }

        PostgreSQLDAO dao = new PostgreSQLDAO(/*getConnection()*/);
        List<Person> persons = dao.getPersons(fields);

        return persons;
    }

    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(PersonWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
