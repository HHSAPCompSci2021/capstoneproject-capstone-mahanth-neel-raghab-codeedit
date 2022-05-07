import java.util.ArrayList;

import java.io.File;

public class Directory {
    private File[] files;

    public Directory(String dirPath) {
		loadFiles(dirPath);
    }

	private void loadFiles(String dirPath) {
		File dir = new File(dirPath);
		String[] fnames = dir.list();
		for (int i = 0; i < fnames.length; i++) {
			files[i] = new File(fnames[i]);
		}
	}

    public File[] getFiles() {
        return files;
    }
}
