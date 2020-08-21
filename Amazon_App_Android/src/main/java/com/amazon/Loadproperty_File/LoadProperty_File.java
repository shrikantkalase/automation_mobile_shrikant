package com.amazon.Loadproperty_File;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProperty_File {
    static String getData;
    static Properties property = new Properties();

    public static void load_Property_Data() throws IOException {
        File file = new File("src/main/resources/PropertyFile/Testdata.properties");
        FileInputStream fileInput = null;
        fileInput = new FileInputStream(file);
        //load properties file
        property.load(fileInput);
    }

    public static String get_Property_Data(String data) throws IOException {
        load_Property_Data();
        getData = property.getProperty(data);
        return getData;
    }




}
