package com.example.demo.entity.jbzbajfk;

import javax.xml.bind.annotation.*;


/**
 *
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "brief",
    "data"
})
@XmlRootElement(name = "resource")
@lombok.Data
public class Resource {

    @XmlElement(required = true)
    private Brief brief;
    @XmlElement(required = true)
    private Data data;


}
