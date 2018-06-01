package com.devchal.pojo.data;

public class SearchTopic
{
    private String searchTopic;

    public String getSearchTopic ()
    {
        return searchTopic;
    }

    public void setSearchTopic (String searchTopic)
    {
        this.searchTopic = searchTopic;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [searchTopic = "+searchTopic+"]";
    }
}
