import java.io.File;

public class EditorWindow {
    private Directory d;
    private File f;

    public EditorWindow(File f) {
		this.f = f;
    }

	public EditorWindow(Directory projectDir) {
		dir = projectDir;
	}

    public boolean saveFile() {
        return false;
    }

	// This method takes a file name as an argument. 
	// It then returns the data contained in the file as a String.
	public String readFile(String inputFile) {
		FileReader fr = null;

		try {
			fr = new FileReader(inputFile);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}

		BufferedReader br = new BufferedReader(fr);
		String result = "";

		String line = "";
		try {
			while ((line = br.readLine()) != null) {
				result += line + System.lineSeparator();
			}
		} catch (IOException ie) {
			ie.printStackTrace();
		}

		return result;
	}

	// This method takes a file name and a data String as arguments. 
	// A file is written to the disk using the filename given and containing the data String.
	public void writeFile(String data, String outputFile) {
		FileWriter writer = null;

		try {
			writer = new FileWriter(outputFile);	
		} catch (IOException ie) {
			ie.printStackTrace();
		}

		BufferedWriter bw = new BufferedWriter(writer);
		try {
			bw.write(data);
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
}
