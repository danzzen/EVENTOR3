package com.eventor.eventor.Data;


public class data
{
    String name; int id ;  int imgid;
    public data(String nm, int i , int im)
    {
        name=nm;
        id=i;
        imgid=im;
    }

    public int getImgid() {
        return imgid;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
