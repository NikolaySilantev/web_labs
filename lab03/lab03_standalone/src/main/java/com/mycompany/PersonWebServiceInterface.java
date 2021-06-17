/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.errors.NotFoundException;
import com.mycompany.interaction.CreateRequest;
import com.mycompany.interaction.FindRequest;
import com.mycompany.interaction.UpdateRequest;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 *
 * @author nikolay
 */


//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)
public interface PersonWebServiceInterface {
    @WebMethod(operationName = "getPersons")
    String getPersons(@WebParam(name = "Request") FindRequest findRequest);
    
    @WebMethod(operationName = "createPersons")
    public int createPersons(@WebParam(name = "Request") CreateRequest createRequest) throws NotFoundException;
    
    @WebMethod(operationName = "updatePersons")
    public String updatePersons(@WebParam(name = "Request") UpdateRequest updateRequest) throws NotFoundException;
    
    @WebMethod(operationName = "deletePersons")
    public String deletePersons(@WebParam(name = "Id") int id) throws NotFoundException;
}
