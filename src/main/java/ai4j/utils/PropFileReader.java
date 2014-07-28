package ai4j.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropFileReader {

    /**
     * Getting value of key from property-file
     * @param propFileName - property-file's name (without ".property")
     * @param key - key
     * @return String value
     */
    public static String getPropValue(String propFileName, String key){
        String retVal;
        // Get path to the AutoIt.exe from file "autoIt.properties"
        File propFile = new File(/*"src/main/resources/" + */propFileName + ".properties");
        try {
            FileInputStream fileInput = new FileInputStream(propFile);
            Properties properties = new Properties();
            properties.load(fileInput);
            return properties.getProperty(key);
        } catch (FileNotFoundException e) {
            System.out.println("Error: file autoit.property not found !");
        } catch (IOException e) {
            System.out.println("Error: cann't find key \"" + key + "in file \"autoit.property\".");
        }
        return "";
    }
}
