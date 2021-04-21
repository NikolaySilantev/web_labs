
package com.mycompany;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mycompany package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UpdatePersons_QNAME = new QName("http://mycompany.com/", "updatePersons");
    private final static QName _CreateRequest_QNAME = new QName("http://mycompany.com/", "createRequest");
    private final static QName _FindRequest_QNAME = new QName("http://mycompany.com/", "findRequest");
    private final static QName _GetPersons_QNAME = new QName("http://mycompany.com/", "getPersons");
    private final static QName _CreatePersons_QNAME = new QName("http://mycompany.com/", "createPersons");
    private final static QName _GetPersonsResponse_QNAME = new QName("http://mycompany.com/", "getPersonsResponse");
    private final static QName _NotFoundException_QNAME = new QName("http://mycompany.com/", "NotFoundException");
    private final static QName _DeletePersonsResponse_QNAME = new QName("http://mycompany.com/", "deletePersonsResponse");
    private final static QName _UpdatePersonsResponse_QNAME = new QName("http://mycompany.com/", "updatePersonsResponse");
    private final static QName _DeletePersons_QNAME = new QName("http://mycompany.com/", "deletePersons");
    private final static QName _Fields_QNAME = new QName("http://mycompany.com/", "fields");
    private final static QName _CreatePersonsResponse_QNAME = new QName("http://mycompany.com/", "createPersonsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mycompany
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdatePersons }
     * 
     */
    public UpdatePersons createUpdatePersons() {
        return new UpdatePersons();
    }

    /**
     * Create an instance of {@link CreatePersons }
     * 
     */
    public CreatePersons createCreatePersons() {
        return new CreatePersons();
    }

    /**
     * Create an instance of {@link CreateRequest }
     * 
     */
    public CreateRequest createCreateRequest() {
        return new CreateRequest();
    }

    /**
     * Create an instance of {@link FindRequest }
     * 
     */
    public FindRequest createFindRequest() {
        return new FindRequest();
    }

    /**
     * Create an instance of {@link GetPersons }
     * 
     */
    public GetPersons createGetPersons() {
        return new GetPersons();
    }

    /**
     * Create an instance of {@link GetPersonsResponse }
     * 
     */
    public GetPersonsResponse createGetPersonsResponse() {
        return new GetPersonsResponse();
    }

    /**
     * Create an instance of {@link DeletePersons }
     * 
     */
    public DeletePersons createDeletePersons() {
        return new DeletePersons();
    }

    /**
     * Create an instance of {@link PersonServiceFault }
     * 
     */
    public PersonServiceFault createPersonServiceFault() {
        return new PersonServiceFault();
    }

    /**
     * Create an instance of {@link DeletePersonsResponse }
     * 
     */
    public DeletePersonsResponse createDeletePersonsResponse() {
        return new DeletePersonsResponse();
    }

    /**
     * Create an instance of {@link UpdatePersonsResponse }
     * 
     */
    public UpdatePersonsResponse createUpdatePersonsResponse() {
        return new UpdatePersonsResponse();
    }

    /**
     * Create an instance of {@link FieldsInter }
     * 
     */
    public FieldsInter createFieldsInter() {
        return new FieldsInter();
    }

    /**
     * Create an instance of {@link CreatePersonsResponse }
     * 
     */
    public CreatePersonsResponse createCreatePersonsResponse() {
        return new CreatePersonsResponse();
    }

    /**
     * Create an instance of {@link UpdateRequest }
     * 
     */
    public UpdateRequest createUpdateRequest() {
        return new UpdateRequest();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePersons }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mycompany.com/", name = "updatePersons")
    public JAXBElement<UpdatePersons> createUpdatePersons(UpdatePersons value) {
        return new JAXBElement<UpdatePersons>(_UpdatePersons_QNAME, UpdatePersons.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mycompany.com/", name = "createRequest")
    public JAXBElement<CreateRequest> createCreateRequest(CreateRequest value) {
        return new JAXBElement<CreateRequest>(_CreateRequest_QNAME, CreateRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mycompany.com/", name = "findRequest")
    public JAXBElement<FindRequest> createFindRequest(FindRequest value) {
        return new JAXBElement<FindRequest>(_FindRequest_QNAME, FindRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersons }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mycompany.com/", name = "getPersons")
    public JAXBElement<GetPersons> createGetPersons(GetPersons value) {
        return new JAXBElement<GetPersons>(_GetPersons_QNAME, GetPersons.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePersons }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mycompany.com/", name = "createPersons")
    public JAXBElement<CreatePersons> createCreatePersons(CreatePersons value) {
        return new JAXBElement<CreatePersons>(_CreatePersons_QNAME, CreatePersons.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mycompany.com/", name = "getPersonsResponse")
    public JAXBElement<GetPersonsResponse> createGetPersonsResponse(GetPersonsResponse value) {
        return new JAXBElement<GetPersonsResponse>(_GetPersonsResponse_QNAME, GetPersonsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mycompany.com/", name = "NotFoundException")
    public JAXBElement<PersonServiceFault> createNotFoundException(PersonServiceFault value) {
        return new JAXBElement<PersonServiceFault>(_NotFoundException_QNAME, PersonServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePersonsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mycompany.com/", name = "deletePersonsResponse")
    public JAXBElement<DeletePersonsResponse> createDeletePersonsResponse(DeletePersonsResponse value) {
        return new JAXBElement<DeletePersonsResponse>(_DeletePersonsResponse_QNAME, DeletePersonsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePersonsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mycompany.com/", name = "updatePersonsResponse")
    public JAXBElement<UpdatePersonsResponse> createUpdatePersonsResponse(UpdatePersonsResponse value) {
        return new JAXBElement<UpdatePersonsResponse>(_UpdatePersonsResponse_QNAME, UpdatePersonsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePersons }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mycompany.com/", name = "deletePersons")
    public JAXBElement<DeletePersons> createDeletePersons(DeletePersons value) {
        return new JAXBElement<DeletePersons>(_DeletePersons_QNAME, DeletePersons.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldsInter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mycompany.com/", name = "fields")
    public JAXBElement<FieldsInter> createFields(FieldsInter value) {
        return new JAXBElement<FieldsInter>(_Fields_QNAME, FieldsInter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreatePersonsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mycompany.com/", name = "createPersonsResponse")
    public JAXBElement<CreatePersonsResponse> createCreatePersonsResponse(CreatePersonsResponse value) {
        return new JAXBElement<CreatePersonsResponse>(_CreatePersonsResponse_QNAME, CreatePersonsResponse.class, null, value);
    }

}
