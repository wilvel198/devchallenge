package com.devchal.pojo.data;

public class GiffySearchResults
{
    private String[] searchResults;

    public String[] getSearchResults ()
    {
        return searchResults;
    }

    public void setSearchResults (String[] searchResults)
    {
        this.searchResults = searchResults;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [searchResults = "+searchResults+"]";
    }
}