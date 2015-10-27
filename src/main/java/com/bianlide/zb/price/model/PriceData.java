package com.bianlide.zb.price.model;

import java.math.BigDecimal;
import java.util.Date;

public class PriceData extends PriceDataKey
{
    private String shape;

    private String nai;

    private String ka;

    private BigDecimal carat;

    private String color;

    private String clarity;

    private String cut;

    private String polish;

    private String semmetry;

    private String fluor;

    private String xinJian;

    private String zhiJing;

    private BigDecimal depth;

    private BigDecimal taiMian;

    private String certNo;

    private String cert;

    private Integer price;

    private String status;

    private Date deleteTime;

    public String getShape()
    {
        return shape;
    }

    public void setShape(String shape)
    {
        this.shape = shape == null ? null : shape.trim();
    }

    public String getNai()
    {
        return nai;
    }

    public void setNai(String nai)
    {
        this.nai = nai == null ? null : nai.trim();
    }

    public String getKa()
    {
        return ka;
    }

    public void setKa(String ka)
    {
        this.ka = ka == null ? null : ka.trim();
    }

    public BigDecimal getCarat()
    {
        return carat;
    }

    public void setCarat(BigDecimal carat)
    {
        this.carat = carat;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color == null ? null : color.trim();
    }

    public String getClarity()
    {
        return clarity;
    }

    public void setClarity(String clarity)
    {
        this.clarity = clarity == null ? null : clarity.trim();
    }

    public String getCut()
    {
        return cut;
    }

    public void setCut(String cut)
    {
        this.cut = cut == null ? null : cut.trim();
    }

    public String getPolish()
    {
        return polish;
    }

    public void setPolish(String polish)
    {
        this.polish = polish == null ? null : polish.trim();
    }

    public String getSemmetry()
    {
        return semmetry;
    }

    public void setSemmetry(String semmetry)
    {
        this.semmetry = semmetry == null ? null : semmetry.trim();
    }

    public String getFluor()
    {
        return fluor;
    }

    public void setFluor(String fluor)
    {
        this.fluor = fluor == null ? null : fluor.trim();
    }

    public String getXinJian()
    {
        return xinJian;
    }

    public void setXinJian(String xinJian)
    {
        this.xinJian = xinJian == null ? null : xinJian.trim();
    }

    public String getZhiJing()
    {
        return zhiJing;
    }

    public void setZhiJing(String zhiJing)
    {
        this.zhiJing = zhiJing;
    }

    public BigDecimal getDepth()
    {
        return depth;
    }

    public void setDepth(BigDecimal depth)
    {
        this.depth = depth;
    }

    public BigDecimal getTaiMian()
    {
        return taiMian;
    }

    public void setTaiMian(BigDecimal taiMian)
    {
        this.taiMian = taiMian;
    }

    public String getCertNo()
    {
        return certNo;
    }

    public void setCertNo(String certNo)
    {
        this.certNo = certNo == null ? null : certNo.trim();
    }

    public String getCert()
    {
        return cert;
    }

    public void setCert(String cert)
    {
        this.cert = cert == null ? null : cert.trim();
    }

    public Integer getPrice()
    {
        return price;
    }

    public void setPrice(Integer price)
    {
        this.price = price;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status == null ? null : status.trim();
    }

    public Date getDeleteTime()
    {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime)
    {
        this.deleteTime = deleteTime;
    }
}