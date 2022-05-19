package codeedit.halideeditor.utils;

import java.io.FileInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOUtils {

    public static final String lineSeparator = System.getProperty("line.separator");
    public static final String fileSeparator = System.getProperty("file.separator");

    public static String readFile(String filename) {
        String data = null;

        try {
            FileInputStream fStream = new FileInputStream(filename);
            byte[] contents = fStream.readAllBytes();
            data = new String(contents);
            fStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static void writeFile(String filename, String data) {   
        try (FileWriter fw = new FileWriter(filename)) {
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(data);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}