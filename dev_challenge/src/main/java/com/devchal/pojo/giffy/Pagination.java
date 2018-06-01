package com.devchal.pojo.giffy;

public class Pagination
{
    private String count;

    private String offset;

    private String total_count;

    public String getCount ()
    {
        return count;
    }

    public void setCount (String count)
    {
        this.count = count;
    }

    public String getOffset ()
    {
        return offset;
    }

    public void setOffset (String offset)
    {
        this.offset = offset;
    }

    public String getTotal_count ()
    {
        return total_count;
    }

    public void setTotal_count (String total_count)
    {
        this.total_count = total_count;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [count = "+count+", offset = "+offset+", total_count = "+total_count+"]";
    }
}
