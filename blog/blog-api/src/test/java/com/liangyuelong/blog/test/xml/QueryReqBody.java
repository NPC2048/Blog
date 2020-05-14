package com.liangyuelong.blog.test.xml;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.xml.bind.annotation.*;

/**
 * 单笔/批量交易查询QP0005Requset
 */
@XmlType(name = "type", namespace = "queryReqBody")
@XmlRootElement(name = "Body")
@XmlAccessorType(XmlAccessType.FIELD)
public class QueryReqBody extends BaseBody {

    {

    }

    /**
     * 查詢類型
     * 0：當日
     * 1：歷史
     * 长度: 1, 是否必输: R
     */
    @Valid
    @NotBlank(message = "查詢類型不能為空")
    @XmlElement(name = "SearchType")
    private String searchType;

    /**
     * 業務類型
     * 1:支付查詢
     * 2:撤銷查詢
     * 3:退貨查詢
     * 长度: 1, 是否必输: R
     */
    @Valid
    @NotBlank(message = "業務類型不能為空")
    @XmlElement(name = "BizType")
    private String bizType;

    /**
     * 交易開始時間格式：yyyyMMddHHmmss
     * 长度: 14, 是否必输: O
     */
    @XmlElement(name = "BeginDate")
    private String beginDate;

    /**
     * 交易結束時間格式：yyyyMMddHHmmss
     * 长度: 14, 是否必输: O
     */
    @XmlElement(name = "EndDate")
    private String endDate;

    /**
     * 訂單號或流水號列表，以“，”分隔符分
     * 開。一次最多支持20個訂單號。
     * 长度: 600, 是否必输: R
     */
    @Valid
    @NotBlank(message = "訂單號或流水號列表不能為空")
    @XmlElement(name = "OrderNoList")
    private String orderNoList;

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getOrderNoList() {
        return orderNoList;
    }

    public void setOrderNoList(String orderNoList) {
        this.orderNoList = orderNoList;
    }
}
