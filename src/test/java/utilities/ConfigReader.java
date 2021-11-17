package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //1- Properties objesi olusturacagiz
    static Properties properties;

    //2-Bu classin amaci cofiguration.properties dosyasini okumak ve oradaki
    // Key-value ikililerini kullanarak istedigimiz keye ait value yu bize getirmek
    static {
        String dosyaYolu="configuration.properties";
        try {
            FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
            properties=new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //3- test classlarindan configreader classina ulasip
    // yukaridaki islemleri yapmamizi saglayacak bir method olusturacagiz
    public static String getProperty(String key){


        String value=properties.getProperty(key);
        return value;
    }
}
