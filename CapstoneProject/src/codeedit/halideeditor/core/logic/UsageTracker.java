package codeedit.halideeditor.core.logic;

import java.io.File;
import java.io.FileFilter;

import codeedit.halideeditor.models.CodeSuggestion;
import codeedit.halideeditor.utils.FileIOUtils;

/**
 * UsageTracker
 */
public class UsageTracker {
    public static int[] getNumOccurences(CodeSuggestion[] sugs) {
        String cwd = System.getProperty("user.dir");
        File dir = new File(cwd);
        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File f) {
                if (f.getName().endsWith(".java")) {
                    return true;
                }

                return false;
            }
        });

        int[] counts = new int[sugs.length];

        for (int i = 0; i < sugs.length; i++) {
            for (File f : files) {
                String contents = FileIOUtils.readFile(f.getPath());
                String sugName = sugs[i].getName();
                int foundIdx = contents.indexOf(sugName);
                while (foundIdx < contents.length() && foundIdx != -1) {
                    counts[i]++;
                    String temp = contents.substring(foundIdx + 1);
                    foundIdx = temp.indexOf(sugName);
                }
            }  
        }

        return counts;
    }
}