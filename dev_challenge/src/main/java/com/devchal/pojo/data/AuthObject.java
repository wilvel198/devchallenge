package com.devchal.pojo.data;

public class AuthObject
{
    private String username;

    private String type;

    private String password;

    public String getUsername ()
    {
        return username;
    }

    public void setUsername (String username)
    {
        this.username = username;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getPassword ()
    {
        return password;
    }

    public void setPassword (String password)
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [username = "+username+", type = "+type+", password = "+password+"]";
    }
}
			