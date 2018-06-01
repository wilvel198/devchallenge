package com.devchal.contentdata;

public class ContentData
{
    private String id;

    private String[] Category;

    private String userid;

    private String objectType;

    private String contentLocation;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String[] getCategory ()
    {
        return Category;
    }

    public void setCategory (String[] Category)
    {
        this.Category = Category;
    }

    public String getUserid ()
    {
        return userid;
    }

    public void setUserid (String userid)
    {
        this.userid = userid;
    }

    public String getObjectType ()
    {
        return objectType;
    }

    public void setObjectType (String objectType)
    {
        this.objectType = objectType;
    }

    public String getContentLocation ()
    {
        return contentLocation;
    }

    public void setContentLocation (String contentLocation)
    {
        this.contentLocation = contentLocation;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", Category = "+Category+", userid = "+userid+", objectType = "+objectType+", contentLocation = "+contentLocation+"]";
    }
}