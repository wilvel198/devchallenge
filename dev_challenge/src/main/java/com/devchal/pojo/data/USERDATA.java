package com.devchal.pojo.data;

public class USERDATA
{
    private String zip;

    private String lastName;

    private String username;

    private String emailaddress;

    private String phoneNumber;

    private String address;

    private String userid;

    private String state;

    private String firstName;

    private String password;

    private String objectType;

    private String city;

    public String getZip ()
    {
        return zip;
    }

    public void setZip (String zip)
    {
        this.zip = zip;
    }

    public String getLastName ()
    {
        return lastName;
    }

    public void setLastName (String lastName)
    {
        this.lastName = lastName;
    }

    public String getUsername ()
    {
        return username;
    }

    public void setUsername (String username)
    {
        this.username = username;
    }

    public String getEmailaddress ()
    {
        return emailaddress;
    }

    public void setEmailaddress (String emailaddress)
    {
        this.emailaddress = emailaddress;
    }

    public String getPhoneNumber ()
    {
        return phoneNumber;
    }

    public void setPhoneNumber (String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress ()
    {
        return address;
    }

    public void setAddress (String address)
    {
        this.address = address;
    }

    public String getUserid ()
    {
        return userid;
    }

    public void setUserid (String userid)
    {
        this.userid = userid;
    }

    public String getState ()
    {
        return state;
    }

    public void setState (String state)
    {
        this.state = state;
    }

    public String getFirstName ()
    {
        return firstName;
    }

    public void setFirstName (String firstName)
    {
        this.firstName = firstName;
    }

    public String getPassword ()
    {
        return password;
    }

    public void setPassword (String password)
    {
        this.password = password;
    }

    public String getObjectType ()
    {
        return objectType;
    }

    public void setObjectType (String objectType)
    {
        this.objectType = objectType;
    }

    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [zip = "+zip+", lastName = "+lastName+", username = "+username+", emailaddress = "+emailaddress+", phoneNumber = "+phoneNumber+", address = "+address+", userid = "+userid+", state = "+state+", firstName = "+firstName+", password = "+password+", objectType = "+objectType+", city = "+city+"]";
    }
}

