package com.example.demo.entity.jbzbajfk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;


/**
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "count"
})
@XmlRootElement(name = "brief")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brief {

    @XmlElement(required = true)
    private Integer count;

}
