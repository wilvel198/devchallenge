package com.devchal.pojo.data;

public class GiffyObject
{
    private String giffyId;

    private String giffyTitle;

    private String giffyURL;

    private String giffyEmbeddedURL;

    public String getGiffyId ()
    {
        return giffyId;
    }

    public void setGiffyId (String giffyId)
    {
        this.giffyId = giffyId;
    }

    public String getGiffyTitle ()
    {
        return giffyTitle;
    }

    public void setGiffyTitle (String giffyTitle)
    {
        this.giffyTitle = giffyTitle;
    }

    public String getGiffyURL ()
    {
        return giffyURL;
    }

    public void setGiffyURL (String giffyURL)
    {
        this.giffyURL = giffyURL;
    }

    public String getGiffyEmbeddedURL ()
    {
        return giffyEmbeddedURL;
    }

    public void setGiffyEmbeddedURL (String giffyEmbeddedURL)
    {
        this.giffyEmbeddedURL = giffyEmbeddedURL;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [giffyId = "+giffyId+", giffyTitle = "+giffyTitle+", giffyURL = "+giffyURL+", giffyEmbeddedURL = "+giffyEmbeddedURL+"]";
    }
}