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
import java.util.List;
import org.apache.juddi.v3.client.UDDIConstants;
import org.apache.juddi.v3.client.config.UDDIClient;
import org.apache.juddi.v3.client.transport.Transport;
import org.uddi.api_v3.AccessPoint;
import org.uddi.api_v3.AuthToken;
import org.uddi.api_v3.BindingTemplate;
import org.uddi.api_v3.BindingTemplates;
import org.uddi.api_v3.BusinessEntity;
import org.uddi.api_v3.BusinessList;
import org.uddi.api_v3.BusinessService;
import org.uddi.api_v3.Description;
import org.uddi.api_v3.DiscardAuthToken;
import org.uddi.api_v3.FindBusiness;
import org.uddi.api_v3.GetAuthToken;
import org.uddi.api_v3.Name;
import org.uddi.api_v3.SaveBusiness;
import org.uddi.api_v3.SaveService;
import org.uddi.v3_service.UDDIInquiryPortType;
import org.uddi.v3_service.UDDIPublicationPortType;
import org.uddi.v3_service.UDDISecurityPortType;
import org.uddi.api_v3.BusinessInfos;
import org.uddi.api_v3.BusinessServices;
import org.uddi.api_v3.ServiceInfos;

public class SimpleBrowse {

    private static UDDISecurityPortType security = null;
    private static UDDIInquiryPortType inquiry = null;
    private static UDDIPublicationPortType publish = null;

    /**
     * This sets up the ws proxies using uddi.xml in META-INF
     *
     */
    public SimpleBrowse() {
        try {
            // create a manager and read the config in the archive;
            // you can use your config file name
            UDDIClient client = new UDDIClient("META-INF/simple-browse-uddi.xml");
            // a UDDIClient can be a client to multiple UDDI nodes, so
            // supply the nodeName (defined in your uddi.xml.
            // The transport can be WS, inVM, RMI etc which is defined in the uddi.xml
            Transport transport = client.getTransport("default");
            // Now you create a reference to the UDDI API
            security = transport.getUDDISecurityService();
            inquiry = transport.getUDDIInquiryService();
            publish = transport.getUDDIPublishService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Main entry point
     *
     * @param args
     */
    public static void main(String args[]) {

        SimpleBrowse sp = new SimpleBrowse();
        sp.Browse(args);
    }

    public void Browse(String[] args) {
        try {

            String token = GetAuthKey("uddi", "uddi");

            publish(token);

            BusinessList findBusiness = GetBusinessList(token);
            PrintBusinessInfo(findBusiness.getBusinessInfos());

            security.discardAuthToken(new DiscardAuthToken(token));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void publish(String token) {
        try {

            // Creating the parent business entity that will contain our service.
            BusinessEntity myBusEntity = new BusinessEntity();
            Name myBusName = new Name();
            myBusName.setValue("My Business");
            myBusEntity.getName().add(myBusName);

            // Adding the business entity to the "save" structure, using our publisher's authentication info and saving away.
            SaveBusiness sb = new SaveBusiness();
            sb.getBusinessEntity().add(myBusEntity);
            sb.setAuthInfo(token);
            String myBusKey = "abcdeffguhlklklbds";
            myBusEntity.setBusinessKey(myBusKey);
            publish.saveBusiness(sb);

            // Creating a service to save.  Only adding the minimum data: the parent business key retrieved from saving the business 
            // above and a single name.
            BusinessService myService = new BusinessService();
            String myServKey = "fgsnjktyuioghcvhjbjk";
            myService.setBusinessKey(myBusEntity.getBusinessKey());
            myService.setServiceKey(myServKey);
            myService.setBindingTemplates(new BindingTemplates());
            Name myServName = new Name();
            myServName.setValue("My Service");
            myService.getName().add(myServName);

            // Add binding templates, etc...
            BindingTemplate myBindingTemplate = new BindingTemplate();
            AccessPoint accessPoint = new AccessPoint("http://localhost/", "wsdl");
            //accessPoint.setUseType(AccessPointType.WSDL_DEPLOYMENT.toString());
            myBindingTemplate.setAccessPoint(accessPoint);
            myBindingTemplate.setServiceKey(myServKey);

            myService.getBindingTemplates().getBindingTemplate().add(myBindingTemplate);

            // Adding the service to the "save" structure, using our publisher's authentication info and saving away.
            SaveService ss = new SaveService();

            myBusEntity.setBusinessServices(new BusinessServices());
            myBusEntity.getBusinessServices().getBusinessService().add(myService);

            ss.getBusinessService().add(myService);
            ss.setAuthInfo(token);

            publish.saveService(ss);

            //security.discardAuthToken(new DiscardAuthToken(token));
            // Now you have published a business and service via 
            // the jUDDI API!
            System.out.println("Success!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void PrintBusinessInfo(BusinessInfos businessInfos) {
        if (businessInfos == null) {
            System.out.println("No data returned");
        } else {
            for (int i = 0; i < businessInfos.getBusinessInfo().size(); i++) {
                System.out.println("===============================================");
                System.out.println("Business Key: " + businessInfos.getBusinessInfo().get(i).getBusinessKey());
                System.out.println("Name: " + ListToString(businessInfos.getBusinessInfo().get(i).getName()));

                System.out.println("Description: " + ListToDescString(businessInfos.getBusinessInfo().get(i).getDescription()));
                System.out.println("Services:");
                if (businessInfos.getBusinessInfo().get(i).getServiceInfos()!=null) PrintServiceInfo(businessInfos.getBusinessInfo().get(i).getServiceInfos());
            }
        }
    }

    private void PrintServiceInfo(ServiceInfos serviceInfos) {
        for (int i = 0; i < serviceInfos.getServiceInfo().size(); i++) {
            System.out.println("-------------------------------------------");
            System.out.println("Service Key: " + serviceInfos.getServiceInfo().get(i).getServiceKey());
            System.out.println("Owning Business Key: " + serviceInfos.getServiceInfo().get(i).getBusinessKey());
            System.out.println("Name: " + ListToString(serviceInfos.getServiceInfo().get(i).getName()));
        }
    }

    private BusinessList GetBusinessList(String token) throws Exception {
        FindBusiness fb = new FindBusiness();
        fb.setAuthInfo(token);
        org.uddi.api_v3.FindQualifiers fq = new org.uddi.api_v3.FindQualifiers();
        fq.getFindQualifier().add(UDDIConstants.APPROXIMATE_MATCH);

        fb.setFindQualifiers(fq);
        Name searchname = new Name();
        searchname.setValue(UDDIConstants.WILDCARD);
        fb.getName().add(searchname);
        BusinessList findBusiness = inquiry.findBusiness(fb);
        return findBusiness;

    }

    private enum AuthStyle {

        HTTP_BASIC,
        HTTP_DIGEST,
        HTTP_NTLM,
        UDDI_AUTH,
        HTTP_CLIENT_CERT
    }

    /**
     * Gets a UDDI style auth token, otherwise, appends credentials to the ws
     * proxies (not yet implemented)
     *
     * @param username
     * @param password
     * @param style
     * @return
     */
    private String GetAuthKey(String username, String password) {
        try {

            GetAuthToken getAuthTokenRoot = new GetAuthToken();
            getAuthTokenRoot.setUserID(username);
            getAuthTokenRoot.setCred(password);

            // Making API call that retrieves the authentication token for the user.
            AuthToken rootAuthToken = security.getAuthToken(getAuthTokenRoot);
            System.out.println(username + " AUTHTOKEN = (don't log auth tokens!");
            return rootAuthToken.getAuthInfo();
        } catch (Exception ex) {
            System.out.println("Could not authenticate with the provided credentials " + ex.getMessage());
        }
        return null;
    }

    private String ListToString(List<Name> name) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < name.size(); i++) {
            sb.append(name.get(i).getValue()).append(" ");
        }
        return sb.toString();
    }

    private String ListToDescString(List<Description> name) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < name.size(); i++) {
            sb.append(name.get(i).getValue()).append(" ");
        }
        return sb.toString();
    }

}
