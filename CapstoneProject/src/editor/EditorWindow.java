package editor;

import java.io.File;
import java.util.Arrays;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.plaf.synth.SynthLookAndFeel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;

import autocomp.SnippetSorter;
import utils.FileOps;

public class EditorWindow extends JFrame implements ActionListener, Runnable {
	private JTextArea textArea;
	private JMenuBar options;
	private JTree fileHierarchyView;

    public EditorWindow() {
		super("Code Editor");
		textArea = new JTextArea(300, 500);
    	options = new JMenuBar();
		fileHierarchyView = new JTree();
		JMenu m1 = new JMenu("File");
		JMenuItem[] fileOptions = new JMenuItem[] {
			new JMenuItem("New"),
			new JMenuItem("Save"),
			new JMenuItem("Open"),
			new JMenuItem("Close"),
			new JMenuItem("Folder Structure"),
			new JMenuItem("Autosave")
		};

		for (JMenuItem item : fileOptions) {
			item.addActionListener(this);
			m1.add(item);
		}

		JMenu m2 = new JMenu("Run");
		JMenuItem runItem = new JMenuItem("Run");
		runItem.addActionListener(this);
		m2.add(runItem);

		JMenu m3 = new JMenu("Terminal");
		JMenuItem terminalItem = new JMenuItem("New Terminal");
		terminalItem.addActionListener(this);
		m3.add(terminalItem);

    	options.add(m1);
		options.add(m2);
		options.add(m3);
    	setJMenuBar(options);
    	add(textArea);
		setSize(800, 500);
	}

	public void run() {
		setVisible(true);
		setResizable(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		switch (command) {
			case "New":
					

			case "Save":
				saveAction();
				break;

			case "Open":
				openAction();
				break;

			case "Close":
				closeAction();
				break;

			case "Autosave":
				autoSaveAction();
				break;

			case "Structure":

				break;

			case "Run":
				SnippetSorter s = new SnippetSorter();
				s.fill(textArea);
				s.sortResults();
				System.out.println(Arrays.toString(s.getSuggestions(5)));
				break;

			case "New Terminal":
				break;
		}
	}

	private void saveAction() {
		JFileChooser jfc = new JFileChooser(System.getProperty("user.dir"));
		int choice = jfc.showSaveDialog(null);

		if (choice == JFileChooser.APPROVE_OPTION) {
			File f = jfc.getSelectedFile().getAbsoluteFile();
			String contents = textArea.getText();

			FileOps.writeFile(contents, f);
		}
	}

	private void openAction() {
		JFileChooser jfc = new JFileChooser(System.getProperty("user.dir"));
		int choice = jfc.showOpenDialog(null);

		if (choice == JFileChooser.APPROVE_OPTION) {
			File f = jfc.getSelectedFile().getAbsoluteFile();
			String contents = FileOps.readFile(f);

			textArea.setText(contents);
		}
	}

	private void closeAction() {
		textArea.setText("");
	}

	private void autoSaveAction() {

	}

	private void structureAction() {

	}

	private void runAction() {

	}

	private void terminalAction() {

	}
}