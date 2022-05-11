import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.ActiveEvent.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditorWindow extends JFrame implements ActionListener {
	private JFrame f;
	private JTextArea textArea;
	private JMenuBar options;
	
    public EditorWindow() {
    	f = new JFrame("Code Editor");
    	textArea = new JTextArea(200, 400);
    	options = new JMenuBar();
    	JMenu m1 = new JMenu("File");
		JMenuItem[] fileOptions = new JMenuItem [] {
			new JMenuItem("New"),
			new JMenuItem("Save"),
			new JMenuItem("Open"),
			new JMenuItem("Close"),
			new JMenuItem("Autosave")
		};

		for (JMenuItem item : fileOptions) {
			item.addActionListener(this);
			m1.add(item);
		}

		JMenu m2 = new JMenu("Run");
		JMenuItem[] runOptions = new JMenuItem[] {
			new JMenuItem("Run"),
			new JMenuItem("Debug")
		};

		for (JMenuItem item : runOptions) {
			item.addActionListener(this);
			m2.add(item);
		}

		JMenu m3 = new JMenu("Terminal");
		JMenuItem terminalItem = new JMenuItem("New Terminal");
		m3.add(terminalItem);

    	options.add(m1);
		options.add(m2);
		options.add(m3);
    	f.setJMenuBar(options);
    	f.add(textArea);
    	f.setSize(800, 500);
    	f.setVisible(true);
		f.setResizable(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		switch (command) {
			case "New":
				File cwd = new File(System.getProperty("user.dir"));
				JPanel fileCreator = new JPanel(new BorderLayout(5, 5));
				JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
				controls.add(new JLabel("File Name:", SwingConstants.RIGHT));
				controls.add(new JTextArea());
				fileCreator.add(controls, BorderLayout.CENTER);

				JOptionPane.showMessageDialog(null, f, "Open File", JOptionPane.PLAIN_MESSAGE);
				break;

			case "Save":
				break;

			case "Open":
				break;

			case "Close":
				break;

			case "Autosave":
				break;

			case "Run":
				break;

			case "Debug":
				break;

			case "New Terminal":
				break;
		}
	}
}