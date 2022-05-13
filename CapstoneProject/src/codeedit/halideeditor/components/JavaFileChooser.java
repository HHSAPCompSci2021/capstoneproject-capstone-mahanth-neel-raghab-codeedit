package codeedit.halideeditor.components;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JavaFileChooser extends JFileChooser {
    
    public JavaFileChooser() {
        FileNameExtensionFilter javaFileFilter = new FileNameExtensionFilter("Java Files", "java");
        setFileFilter(javaFileFilter);
    }

}
