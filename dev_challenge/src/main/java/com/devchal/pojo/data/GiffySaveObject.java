package com.devchal.pojo.data;

public class GiffySaveObject
{
    private String giffyTitle;

    private String giffyURL;

    private String emailAddress;

    private String categories;

    private String giffyID;

    private String giffyEmbeddedURL;

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

    public String getEmailAddress ()
    {
        return emailAddress;
    }

    public void setEmailAddress (String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public String getCategories ()
    {
        return categories;
    }

    public void setCategories (String categories)
    {
        this.categories = categories;
    }

    public String getGiffyID ()
    {
        return giffyID;
    }

    public void setGiffyID (String giffyID)
    {
        this.giffyID = giffyID;
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
        return "ClassPojo [giffyTitle = "+giffyTitle+", giffyURL = "+giffyURL+", emailAddress = "+emailAddress+", categories = "+categories+", giffyID = "+giffyID+", giffyEmbeddedURL = "+giffyEmbeddedURL+"]";
    }
}
