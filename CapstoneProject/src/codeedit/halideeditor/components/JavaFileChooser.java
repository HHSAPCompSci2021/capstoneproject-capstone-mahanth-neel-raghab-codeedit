package codeedit.halideeditor.components;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.formdev.flatlaf.ui.FlatFileChooserUI;;

public class JavaFileChooser extends JFileChooser {
    public JavaFileChooser() {
        FileNameExtensionFilter javaFileFilter = new FileNameExtensionFilter("Java Files", "java");
        setFileFilter(javaFileFilter);
        setUI(new FlatFileChooserUI(this));
    }
}
