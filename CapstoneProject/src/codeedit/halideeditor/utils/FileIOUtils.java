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
        FileReader fr = null;
        BufferedReader reader = null;

        try {
            fr = new FileReader(filename);
            reader = new BufferedReader(fr);
            
            String[] lines = reader.lines().toArray(String[]::new);
            Thread[] threads = new Thread[numThreads];
            int taskSize = lines.length / numThreads;

            for (int i = 0; i < threads.length - 1; i++) {
                ReadTask task = new ReadTask(lines, data, lineSeparator, i * taskSize, (i + 1) * taskSize);
                threads[i] = new Thread(task);
                threads[i].start();
            }

            int start = (threads.length - 1) * taskSize;
            threads[threads.length - 1] = new Thread(new ReadTask(lines,
                                                                  data,
                                                                  lineSeparator,
                                                                  start,
                                                                  lines.length));
            threads[threads.length - 1].start();
            for (Thread t : threads) {
                t.join();
            }
            threads[threads.length - 1].join();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
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