package codeedit.halideeditor.utils;

public class ReadTask implements Runnable {
    private String[] lines;
    private String lineSeparator;
    private StringBuilder result;
    private int start;
    private int end;

    public ReadTask(String[] lines, StringBuilder sb, String lineSeparator, int start, int end) {
        this.lines = lines;
        this.result = sb;
        this.lineSeparator = lineSeparator;
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i < end; i++) {
            result.append(lines[i] + lineSeparator);
        }
    }
}