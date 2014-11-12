//MyMenu.java

import javax.swing.*;
import java.awt.event.*;

public class MyMenu extends JFrame implements ActionListener{

private JMenuBar jmenubar; //Declare outside, as it can be used accross all methods

public MyMenu(){
setTitle("My GUI"); //Title Of GUI
setSize(300,300); //Size Of GUI
setLocation(300,400); //Location On Screen Of GUI
setDefaultCloseOperation(EXIT_ON_CLOSE); //Close On Exit


jmenubar = new JMenuBar(); //Creating Menu, new JMenuBar();
setJMenuBar(jmenubar);

CreateFileMenu();

CreateCharacterMenu();

}

public void CreateFileMenu(){
JMenu filemenu = new JMenu("File"); //Creating the words in the JMenuBar
jmenubar.add(filemenu);

/* Adding Items To The 'File' MenuBar */

JMenuItem newitem = new JMenuItem("New"); //Creating of item under 'File'
filemenu.add(newitem); //Adding of item
newitem.addActionListener(this);

JMenuItem open = new JMenuItem("Open");
filemenu.add(open);
open.addActionListener(this);

JMenuItem close = new JMenuItem("Close");
filemenu.add(close);
close.addActionListener(this);

JMenuItem saveas = new JMenuItem("Save As");
filemenu.add(saveas);
saveas.addActionListener(this);

filemenu.addSeparator(); //Seperator

JMenuItem quit = new JMenuItem("Quit");
filemenu.add(quit);
quit.addActionListener(this); 
}

public void CreateCharacterMenu(){
JMenu charactermenu = new JMenu("Character"); //Creating the words in the JMenuBar
jmenubar.add(charactermenu);

/* Adding Items To The 'Character' MenuBar */

JMenuItem newitem = new JMenuItem("New"); //Creating of item under 'Character'
charactermenu.add(newitem); //Adding of item

JMenuItem open = new JMenuItem("Open");
charactermenu.add(open);

JMenuItem close = new JMenuItem("Close");
charactermenu.add(close);

JMenuItem saveas = new JMenuItem("Save As");
charactermenu.add(saveas);
}


public static void main(String [] args){
MyMenu menu = new MyMenu();
menu.setVisible(true);
}
public void actionPerformed(ActionEvent e){
	if(e.getActionCommand().equals("Open")){
		JOptionPane.showMessageDialog(null,"You clicked Open","",
				JOptionPane.INFORMATION_MESSAGE);
	}
	else if(e.getActionCommand().equals("Open")){
		JOptionPane.showMessageDialog(null,"You clicked Open","",
				JOptionPane.INFORMATION_MESSAGE);
	}
	else if(e.getActionCommand().equals("Open")){
		JOptionPane.showMessageDialog(null,"You clicked Open","",
				JOptionPane.INFORMATION_MESSAGE);
	}
	else if(e.getActionCommand().equals("Open")){
		JOptionPane.showMessageDialog(null,"You clicked Open","",
				JOptionPane.INFORMATION_MESSAGE);
	}
	else if(e.getActionCommand().equals("Open")){
		JOptionPane.showMessageDialog(null,"You clicked Open","",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
}