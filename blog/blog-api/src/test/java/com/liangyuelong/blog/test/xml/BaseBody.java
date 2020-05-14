package com.liangyuelong.blog.test.xml;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({
        QueryReqBody.class,
        SignBody.class
})
public abstract class BaseBody {

    @XmlElement(namespace = "Remark1")
    private String remark1;

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }
}
