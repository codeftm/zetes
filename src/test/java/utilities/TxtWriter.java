package utilities;

import pojo.ContactPojo;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class TxtWriter {
    public static void saveData(ContactPojo contact){
        try {

            FileWriter fileWriter = new FileWriter(ConfigReader.getProperty("path"),true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append(contact.toString()+"\n");
            bufferedWriter.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
