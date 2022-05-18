package codeedit.halideeditor.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOUtils {

    public static final String lineSeparator = System.getProperty("line.separator");
    public static final String fileSeparator = System.getProperty("file.separator");
    public static final int numThreads = Runtime.getRuntime().availableProcessors();

    public static String readFile(String filename) {
        StringBuilder data = new StringBuilder();
        FileReader fr;
        BufferedReader reader;

        try {
            fr = new FileReader(filename);
            reader = new BufferedReader(fr);
            String cur = "";
            
            while ((cur = reader.readLine()) != null) {
                data.append(cur);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data.toString();
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