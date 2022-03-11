package com.example.demo.entity.jbzbajfk;

import javax.xml.bind.annotation.*;
import java.util.List;


/**
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "Jbzbajfkxxes"
})
@lombok.Data
@XmlRootElement(name = "data")
public class Data {

    @XmlElement(name = "T_SFZX_SSXF_JBZBAJFKXX", required = true)
    private List<Jbzbajfkxx> Jbzbajfkxxes;
}
