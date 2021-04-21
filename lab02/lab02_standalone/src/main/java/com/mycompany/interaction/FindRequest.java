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
@XmlRootElement(name = "findRequest")
public class FindRequest implements Serializable {
    private List<FieldsInter> RequestFields;


    public List<FieldsInter> getFields() {
        return RequestFields;
    }

    public void setFields(List<FieldsInter> fieldFinds) {
        this.RequestFields = fieldFinds;
    }
}
