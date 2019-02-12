package com.javarush.task.task20.task2003;

import com.sun.corba.se.impl.io.OutputStreamHook;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        load(fileInputStream);
        fileInputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties myProperties = new Properties();
        myProperties.putAll(properties);
        myProperties.store(outputStream,"");
    }

    public void load(InputStream inputStream) throws Exception {
        Properties myProperties = new Properties();
        myProperties.load(inputStream);
        for (String name : myProperties.stringPropertyNames())
            properties.put(name, myProperties.getProperty(name));
    }

    public static void main(String[] args) throws Exception {

    }
}
