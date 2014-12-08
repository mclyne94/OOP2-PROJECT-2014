import javax.swing.*;

import java.awt.event.*;

public class Project extends JFrame{
	
	private JMenuBar jmenubar;
	
	public Project(){
		
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
		
		myHandler handler=new myHandler();
		
		/* Adding Items To The 'File' MenuBar */
		
		JMenuItem newitem = new JMenuItem("New"); //Creating of item under 'File'
		
		filemenu.add(newitem); //Adding of item
		
		newitem.addActionListener(handler);
		
		JMenuItem open = new JMenuItem("Open");
		
		filemenu.add(open);
		
		open.addActionListener(handler);
		
		JMenuItem close = new JMenuItem("Close");
		
		filemenu.add(close);
		
		close.addActionListener(handler);
		
		JMenuItem saveas = new JMenuItem("Save As");
		
		filemenu.add(saveas);
		
		saveas.addActionListener(handler);
		
		filemenu.addSeparator(); //Seperator
		
		JMenuItem quit = new JMenuItem("Quit");
		
		filemenu.add(quit);
		
		quit.addActionListener(handler); 
		
}

	public void CreateCharacterMenu(){
		
		JMenu charactermenu = new JMenu("Character"); //Creating the words in the JMenuBar
		
		jmenubar.add(charactermenu);
		
		myHandler2 handler2=new myHandler2();
		
		/* Adding Items To The 'Character' MenuBar */
		
		JMenuItem newitem = new JMenuItem("New"); //Creating of item under 'Character'
		
		charactermenu.add(newitem); //Adding of item
		
		newitem.addActionListener(handler2);
		
		JMenuItem open = new JMenuItem("Open");
		
		charactermenu.add(open);
		
		open.addActionListener(handler2);
		
		JMenuItem close = new JMenuItem("Close");
		
		charactermenu.add(close);
		
		close.addActionListener(handler2);
		
		JMenuItem saveas = new JMenuItem("Save As");
		
		charactermenu.add(saveas);
		
		saveas.addActionListener(handler2);
		
}

	public static void main (String args[]){
		
		double firstNo,secondNo;
		
		char operator;
		
		String welcomeMessage,message="Invalid entry!";
		
		operations math=new operations();
		
		welcomeMessage="WELCOME TO THE JAVA CALCULATOR";
		
		JOptionPane.showMessageDialog(null,welcomeMessage);
		
		firstNo=Double.parseDouble(JOptionPane.showInputDialog("Please enter your first number:"));
		
		secondNo=Double.parseDouble(JOptionPane.showInputDialog("Please enter your second number:"));
		
		String getChar=JOptionPane.showInputDialog("Please enter the operator:");
		
		operator=getChar.charAt(0);
		
		if (operator=='+')

		JOptionPane.showMessageDialog(null,(math.Add(firstNo, secondNo)));

		else if (operator=='-')
		
		JOptionPane.showMessageDialog(null,(math.Subtract(firstNo, secondNo)));
		
		else if (operator=='*')
		
		JOptionPane.showMessageDialog(null,(math.Multiply(firstNo, secondNo)));
		
		else if (operator=='/')
		
		JOptionPane.showMessageDialog(null,(math.Divide(firstNo, secondNo)));
		
		else
		
		JOptionPane.showMessageDialog(null,message);
		
	}
	
	public class myHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			if(e.getActionCommand().equals("New")){
				
				JOptionPane.showMessageDialog(null,"You clicked New","",
				
				JOptionPane.INFORMATION_MESSAGE);
				
			}
			
			else if(e.getActionCommand().equals("Open")){
				
				JOptionPane.showMessageDialog(null,"You clicked Open","",
				
				JOptionPane.INFORMATION_MESSAGE);
				
			}
			
			else if(e.getActionCommand().equals("Close")){
				
				JOptionPane.showMessageDialog(null,"You clicked Close","",
				
				JOptionPane.INFORMATION_MESSAGE);
				
			}
			
			else if(e.getActionCommand().equals("Save As")){
				
				JOptionPane.showMessageDialog(null,"You clicked Save As","",
				
				JOptionPane.INFORMATION_MESSAGE);
				
			}
			
			else if(e.getActionCommand().equals("Quit")){
				
				JOptionPane.showMessageDialog(null,"You clicked Quit","",
				
				JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		}
		
	}

	public class myHandler2 implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			if(e.getActionCommand().equals("New")){
				
				JOptionPane.showMessageDialog(null,"You clicked New","",
				
				JOptionPane.INFORMATION_MESSAGE);
				
			}
			
			else if(e.getActionCommand().equals("Open")){
				
				JOptionPane.showMessageDialog(null,"You clicked Open","",
				
				JOptionPane.INFORMATION_MESSAGE);
				
			}
			
			else if(e.getActionCommand().equals("Close")){
				
				JOptionPane.showMessageDialog(null,"You clicked Close","",
				
				JOptionPane.INFORMATION_MESSAGE);
				
			}
			
			else if(e.getActionCommand().equals("Save As")){
				
				JOptionPane.showMessageDialog(null,"You clicked Save As","",
				
				JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		}
		
	}
	
}//end class