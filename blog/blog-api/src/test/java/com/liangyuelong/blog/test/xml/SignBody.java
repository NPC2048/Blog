package com.liangyuelong.blog.test.xml;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@EqualsAndHashCode(callSuper = true)
@XmlRootElement(namespace = "SignBody")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class SignBody extends BaseBody {

    @XmlElement(name = "Name")
    private String name;

}
