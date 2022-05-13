package codeedit.halideeditor.utils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileIOUtils {
    
    public static final String lineSeparator = System.getProperty("line.separator");
    public static final String fileSeparator = System.getProperty("file.separator");

    public static String readFile(String filename) {

        StringBuilder data = new StringBuilder();

        try(Scanner scanner = new Scanner(new FileReader(filename))) {

            while (scanner.hasNextLine()) data.append(scanner.nextLine() + lineSeparator);

        } catch(IOException e) {
            e.printStackTrace();
        }

        return data.toString();

    }

    public static void writeFile(String filename, String data) {
        
        try(FileWriter writer = new FileWriter(filename)) {

            writer.write(data);
            writer.flush();

        } catch(IOException e) {
            e.printStackTrace();
        }

    }

}