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
    	JMenuItem o1 = new JMenuItem("New");
    	JMenuItem o2 = new JMenuItem("Save");
    	JMenuItem o3 = new JMenuItem("Open");
    	JMenuItem o4 = new JMenuItem("Close");
    	o1.addActionListener(this);
    	o2.addActionListener(this);
    	o3.addActionListener(this);
    	o4.addActionListener(this);
    	m1.add(o1);
    	m1.add(o2);
    	m1.add(o3);
    	m1.add(o4);
    	f.setJMenuBar(options);
    	f.add(textArea);
    	f.setSize(850, 500);
    	f.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



}
