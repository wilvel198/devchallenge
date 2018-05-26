package com.devchal.responseobjects;


	
public class responseObject
{
    private String status;

    private String msg;

    private String objectType ;

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public String getMsg ()
    {
        return msg;
    }

    public void setMsg (String msg)
    {
        this.msg = msg;
    }

    public String getObjectType  ()
    {
        return objectType ;
    }

    public void setObjectType  (String objectType )
    {
        this.objectType  = objectType ;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [status = "+status+", msg = "+msg+", objectType  = "+objectType +"]";
    }
}
