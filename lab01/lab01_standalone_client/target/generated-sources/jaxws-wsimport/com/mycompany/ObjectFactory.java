
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

    private final static QName _FindRequest_QNAME = new QName("http://mycompany.com/", "findRequest");
    private final static QName _GetPersons_QNAME = new QName("http://mycompany.com/", "getPersons");
    private final static QName _GetPersonsResponse_QNAME = new QName("http://mycompany.com/", "getPersonsResponse");
    private final static QName _Fields_QNAME = new QName("http://mycompany.com/", "fields");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mycompany
     * 
     */
    public ObjectFactory() {
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
     * Create an instance of {@link FieldsInter }
     * 
     */
    public FieldsInter createFieldsInter() {
        return new FieldsInter();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mycompany.com/", name = "getPersonsResponse")
    public JAXBElement<GetPersonsResponse> createGetPersonsResponse(GetPersonsResponse value) {
        return new JAXBElement<GetPersonsResponse>(_GetPersonsResponse_QNAME, GetPersonsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FieldsInter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mycompany.com/", name = "fields")
    public JAXBElement<FieldsInter> createFields(FieldsInter value) {
        return new JAXBElement<FieldsInter>(_Fields_QNAME, FieldsInter.class, null, value);
    }

}
