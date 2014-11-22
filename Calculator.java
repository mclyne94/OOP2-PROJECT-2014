//Calculator.java

import javax.swing.*;
import java.awt.event.*;

public class Calculator extends JFrame{

	private JMenuBar jmenubar;

	public Calculator(){
		setTitle("Calculator");
		setSize(500,500);
		setLocation(300,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		jmenubar=new JMenuBar();
		setJMenuBar(jmenubar);

		CreateFileMenu();
		CreateHelpMenu();
	}

	public void CreateFileMenu(){
		JMenu filemenu = new JMenu("File");
		jmenubar.add(filemenu);

		JMenuItem one = new JMenuItem("one");
		filemenu.add(one);
		one.addActionListener(handlerOne);

		JMenuItem two = new JMenuItem("two");
		filemenu.add(two);
		two.addActionListener(handlerOne);
		
		JMenuItem three = new JMenuItem("three");
		filemenu.add(three);
		three.addActionListener(handlerOne);
	}

	public void CreateHelpMenu(){
		JMenu helpmenu = new JMenu("Help");
		jmenubar.add(helpmenu);
		
		JMenuItem aboutcalculator = new JMenuItem("About Calculator");
		helpmenu.add(aboutcalculator);
		aboutcalculator.addActionListener(handlerTwo);
	}

	public static void main(String args[]){
		Calculator menu = new Calculator();
		menu.setVisible(true);
	}

	public class handlerOne implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand().equals("One")){
				JOptionPane.showMessageDialog(null,"You clicked one","",
				JOptionPane.INFORMATION_MESSAGE);
			}
			else if(e.getActionCommand().equals("Two")){
				JOptionPane.showMessageDialog(null,"You clicked two","",
				JOptionPane.INFORMATION_MESSAGE);
			}
			else if(e.getActionCommand().equals("Three")){
				JOptionPane.showMessageDialog(null,"You clicked three","",
				JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public class handlerTwo implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getActionCommand().equals("About Calculator")){
				JOptionPane.showMessageDialog(null,"You clicked about calculator","",
				JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}