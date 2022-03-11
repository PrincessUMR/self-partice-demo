package com.example.demo.entity.jbzbajfk;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.Date;


/**
 *
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "cBh",
        "cCsmc",
        "dtCssjgxsj",
        "dtCreatetime",
        "cFybh",
        "dtUpdatetime",
        "nJbajfks",
        "nJbajs",
        "nJzbqwfkxfajsl",
        "dtTjsj"
})
@XmlRootElement(name = "T_SFZX_SSXF_JBZBAJFKXX")
@Data
public class Jbzbajfkxx {

    @XmlElement(name = "C_BH", required = true)
    private String cBh;
    @XmlElement(name = "C_CSMC", required = true)
    private String cCsmc;
    @XmlElement(name = "DT_CSSJGXSJ", required = true)
    private Date dtCssjgxsj;
    @XmlElement(name = "DT_CREATETIME", required = true)
    private Date dtCreatetime;
    @XmlElement(name = "C_FYBH", required = true)
    private String cFybh;
    @XmlElement(name = "DT_UPDATETIME", required = true)
    private Date dtUpdatetime;
    @XmlElement(name = "N_JBAJFKS", required = true)
    private Integer nJbajfks;
    @XmlElement(name = "N_JBAJS", required = true)
    private Integer nJbajs;
    @XmlElement(name = "N_JZBQWFKXFAJSL", required = true)
    private Integer nJzbqwfkxfajsl;
    @XmlElement(name = "DT_TJSJ", required = true)
    private Date dtTjsj;


}
