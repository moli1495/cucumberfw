package com.envision.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class PropertiesFileReader {
    public static HashMap<Object,Object> props = new HashMap<>();

    static {
        if (props.size() == 0) {
            readAllProps("testdata");        }
    }

    //    static{
//        //readProps("fbconfig");
//        //readProps("objectrepo");
//        readAllProps("testdata");
//
//    }
    public static void readProps(String fileName){
        //the below line is for entering the filename full or half based upon choice

        //try(FileInputStream fis = new FileInputStream("fbtestdata/"+(fileName.endsWith(".properties")?"":".properties"))){
        try(FileInputStream fis = new FileInputStream("testdata/"+fileName+".properties")){
            Properties p = new Properties();
            p.load(fis);
            props.putAll(p);
        }catch(Exception e)  {

        }
    }
    public static void readAllProps(String folderName) {
        File f = new File(folderName);
        if (f.isDirectory()) {
            List<File> allFile = Arrays.asList(f.listFiles());
            for (File eachFile : allFile) {
                if(eachFile.getName().endsWith(".properties"))

                    try (FileInputStream fis = new FileInputStream(eachFile.getAbsolutePath())) {
                        Properties p = new Properties();
                        p.load(fis);
                        props.putAll(p);
                    } catch (Exception e) {

                    }
            }
        }
    }

    public static String getPropertyValue(String key) {

        return props.get(key).toString();
    }


}

