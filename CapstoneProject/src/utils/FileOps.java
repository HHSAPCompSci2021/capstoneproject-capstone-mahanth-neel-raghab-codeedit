package utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileOps {
	// This method takes a file name as an argument. 
	// It then returns the data contained in the file as a String.
	public static String readFile(File inputFile) {
		FileReader fr = null;

		try {
			fr = new FileReader(inputFile);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}

		BufferedReader reader = new BufferedReader(fr);
		String result = "";
		int cur = 0;

		try {
			while ((cur = reader.read()) != -1) {
				result += (char) cur;
			}

            reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

 	// This method takes a file name as an argument. 
	// It then returns the data contained in the file as a String.
	public static void writeFile(String data, File outFile) {
        FileWriter fw = null;
        BufferedWriter writer = null;

        try {
            fw = new FileWriter(outFile);
            writer = new BufferedWriter(fw);
            
            writer.write(data);
            writer.close();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
	}   
}