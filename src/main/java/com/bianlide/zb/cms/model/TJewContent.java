package com.bianlide.zb.cms.model;

import java.util.Date;

public class TJewContent
{
    private Integer id;

    private String codeModule;

    private String title;

    private Date createTime;

    private String content;

    private String nameModule;

    private String preImg;

    private String homeImg;

    private String smallImg;

    public String getHomeImg()
    {
        return homeImg;
    }

    public void setHomeImg(String homeImg)
    {
        this.homeImg = homeImg;
    }

    public String getSmallImg()
    {
        return smallImg;
    }

    public void setSmallImg(String smallImg)
    {
        this.smallImg = smallImg;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getCodeModule()
    {
        return codeModule;
    }

    public void setCodeModule(String codeModule)
    {
        this.codeModule = codeModule == null ? null : codeModule.trim();
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title == null ? null : title.trim();
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content == null ? null : content.trim();
    }

    public String getNameModule()
    {
        return nameModule;
    }

    public void setNameModule(String nameModule)
    {
        this.nameModule = nameModule == null ? null : nameModule.trim();
    }

    public String getPreImg()
    {
        return preImg;
    }

    public void setPreImg(String preImg)
    {
        this.preImg = preImg == null ? null : preImg.trim();
        ;
    }

}