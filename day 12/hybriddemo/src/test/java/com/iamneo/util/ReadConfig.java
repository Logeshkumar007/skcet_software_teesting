package com.iamneo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
Properties pro;
public ReadConfig() 
{
    File src=new File("C:\\Users\\NithyaT\\Desktop\\sample\\hybriddemo\\Configuration\\config.properties");

    try{
    FileInputStream fis=new FileInputStream(src);
    pro=new Properties();
    pro.load(fis);
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
} 


public String getUrl()
    {
        String url=pro.getProperty("baseUrl");
        return url;
    }

    public String getUsename()
    {
        String username=pro.getProperty("username");
        return username;
    }
    public String getPassword()
    {
        String password=pro.getProperty("password");
        return password;
    }

}
