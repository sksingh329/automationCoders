package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HandlePropertiesFile {
    private static Properties prop;
    public static Properties loadProperties(String propPath, String propFile){
        File fs = new File(propPath+"/"+propFile);
        FileInputStream fis;
        prop = new Properties();
        try {
            fis = new FileInputStream(fs.getAbsolutePath());
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
