/**This is my Java project submission.
 *It is a calculator that performs addition, sbstraction,
 *multiplication, division, and a square root function.
 *@author Matthew Lyne - T00164220
 *@version 1.0*/
 
/**The following website refers to a website where studied how to create a calculator using a JFrame:
 *http://www.dreamincode.net/forums/topic/321933-creating-a-calculator-using-jframe/*/

import java.awt.*;				//Importing packages required for program operation
import javax.swing.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener{
	private JMenuBar jmenubar;				//Creating JMenuBar
    JPanel[] row = new JPanel[5];			//Setting up rows for JButtons
    JButton[] button = new JButton[19];			//Creating 19 new JButtons for the calculator
    String[] buttonString = {"7", "8", "9", "+",
                             "4", "5", "6", "-",
                             "1", "2", "3", "*",
                             ".", "/", "C", "v",
                             "+/-", "=", "0"};		//Declaring text for each button as String type

    int[] dimW = {300,45,100,90};
    int[] dimH = {35, 40};

    Dimension displayDimension = new Dimension(dimW[0], dimH[0]);
    Dimension regularDimension = new Dimension(dimW[1], dimH[1]);
    Dimension rColumnDimension = new Dimension(dimW[2], dimH[1]);
    Dimension zeroButDimension = new Dimension(dimW[3], dimH[1]);

    boolean[] function = new boolean[4];
    double[] temporary = {0, 0};

    JTextArea display = new JTextArea(1,20);		//Creating JTextArea to simulate calculator screen

    Font font = new Font("Times new Roman", Font.BOLD, 14);		//Setting font and font size for program
    
    /**This beginning of this method is set up to give the JFrame its attributes
    *such as Frame size, location on screen, the default close operation
    *etc.  as can be seen below*/

    Project() {	
		setTitle("Java Calculator");																																																																	
		setSize(350,300);																					
		setMinimumSize(new Dimension(350, 300));															
		setLocation(300,300);			
		setResizable(true);			
		setDefaultCloseOperation(EXIT_ON_CLOSE);			
		this.setIconImage(new ImageIcon(getClass().getResource("/Calculator-icon.png")).getImage());		
		jmenubar=new JMenuBar();		
		setJMenuBar(jmenubar);			
		CreateFileMenu();			
		CreateHelpMenu();
		
		/**Creating grid layout and buttons for calculator
		 *including for loops which create buttons on each row
		 *through an incrementation system*/

        GridLayout grid = new GridLayout(5,5);
        setLayout(grid);

        for(int i = 0; i < 4; i++)
            function[i] = false;

        FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
        FlowLayout f2 = new FlowLayout(FlowLayout.CENTER,1,1);

        for(int i = 0; i < 5; i++)
            row[i] = new JPanel();
	        row[0].setLayout(f1);

        for(int i = 1; i < 5; i++)
            row[i].setLayout(f2);

        for(int i = 0; i < 19; i++) {
            button[i] = new JButton();
            button[i].setText(buttonString[i]);
            button[i].setFont(font);
            button[i].addActionListener(this);
        }

        display.setFont(font);
        display.setEditable(false);
        display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        display.setPreferredSize(displayDimension);

        for(int i = 0; i < 14; i++)
            button[i].setPreferredSize(regularDimension);

        for(int i = 14; i < 18; i++)
            button[i].setPreferredSize(rColumnDimension);
	        button[18].setPreferredSize(zeroButDimension);
        	row[0].add(display);
        	add(row[0]);

        for(int i = 0; i < 4; i++)
            row[1].add(button[i]);
        	row[1].add(button[14]);
        	add(row[1]);

        for(int i = 4; i < 8; i++)
            row[2].add(button[i]);
            row[2].add(button[15]);
            add(row[2]);

        for(int i = 8; i < 12; i++)
            row[3].add(button[i]);
        	row[3].add(button[16]);
        	add(row[3]);
			row[4].add(button[18]);

        for(int i = 12; i < 14; i++)
			row[4].add(button[i]);
			row[4].add(button[17]);
			add(row[4]);
			setVisible(true);
	}
	
	/**This method "CreateFileMenu()", creates the File menu on screen and adds the exit
	 *menu option, which when executed will terminate the program's execution*/
	 
	//I was able to create File and Help methods by referring back to the myMenu programs that we studied in class
    
    public void CreateFileMenu(){
		JMenu filemenu=new JMenu("File");
		jmenubar.add(filemenu);		
		myHandler handler=new myHandler();
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new myHandler());
		filemenu.add(exit);		
	}
	/**This method "CreateHelpMenu()", creates the Help menu on screen and adds the about calculator
	 *menu option, which when executed will bring up a message dialog with information on the program*/
	
	public void CreateHelpMenu(){		
		JMenu helpmenu=new JMenu("Help");		
		jmenubar.add(helpmenu);		
		myHandler2 handler=new myHandler2();		
		JMenuItem aboutCalculator = new JMenuItem("About Calculator");		
		helpmenu.add(aboutCalculator);		
		aboutCalculator.addActionListener(handler);		
	}
	
	/**These handler's are setup to give the JMenuItems their functionality
	 *The following website provided the code for the actionperformed funstion required for the Exit
	 *item to work:  http://stackoverflow.com/questions/8707392/java-exit-button-from-a-menuitem-menubar-and-sound-player*/
	 
	//I was able to create my handler method by referring back to the myMenu programs that we studied in class

	static class myHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.exit(0);		//This line sends the close screen order to the program when the user clicks the Exit item on screen
		}
    }
	
	public class myHandler2 implements ActionListener{		
		public void actionPerformed(ActionEvent e){
			/**The code below makes the message dialog box appear which contains an image and shows text on the information of the program itself*/		
			if(e.getActionCommand().equals("About Calculator")){				
				ImageIcon icon = new ImageIcon(myHandler2.class.getResource("/Calculator-icon1.png"));				
                JOptionPane.showMessageDialog(null,"Java Calculator\n"+                	
                								   "Version 1.0 (Build 1.0: Service Pack 1)\nCopyright 2014\nAll rights reserved.",
                								   "About Calculator",JOptionPane.INFORMATION_MESSAGE,icon);
			}
		}
	}
	
	//creates the clear function which clears the "memory" of the program so that new calculations can be performed
    
    public void clear() {
        try {
            display.setText("");
            for(int i = 0; i < 4; i++)
                function[i] = false;
            for(int i = 0; i < 2; i++)
                temporary[i] = 0;
        }
        catch(NullPointerException e) {
        }
    }
    
    //creates the square root function so that the square root of any number entered can be shown

    public void getSqrt() {
        try {
            double value = Math.sqrt(Double.parseDouble(display.getText()));
            display.setText(Double.toString(value));
        }
        catch(NumberFormatException e){}
    }
    
    //this function lets the user change their entry from positive to negative and vice versa
    
    public void getPosNeg() {
        try {
            double value = Double.parseDouble(display.getText());
            if(value != 0) {
                value = value * (-1);
                display.setText(Double.toString(value));
            }
            else {
            }
        } catch(NumberFormatException e) {
        }
    }  
    public void getResult() {
        double result = 0;
        temporary[1] = Double.parseDouble(display.getText());
        String temp0 = Double.toString(temporary[0]);
        String temp1 = Double.toString(temporary[1]);
        try {
            if(temp0.contains("-")) {
                String[] temp00 = temp0.split("-", 2);
                temporary[0] = (Double.parseDouble(temp00[1]) * -1);
            }
            if(temp1.contains("-")) {
                String[] temp11 = temp1.split("-", 2);
                temporary[1] = (Double.parseDouble(temp11[1]) * -1);
            }
        } catch(ArrayIndexOutOfBoundsException e) {
        }
        try {
            if(function[2] == true)
                result = temporary[0] * temporary[1];
            else if(function[3] == true)
                result = temporary[0] / temporary[1];
            else if(function[0] == true)
                result = temporary[0] + temporary[1];
            else if(function[1] == true)
                result = temporary[0] - temporary[1];
            display.setText(Double.toString(result));
            for(int i = 0; i < 4; i++)
                function[i] = false;
        } catch(NumberFormatException e) {}
    }
    public final void setDesign() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e) {
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == button[0])
            display.append("7");
        if(ae.getSource() == button[1])
            display.append("8");
        if(ae.getSource() == button[2])
            display.append("9");
        if(ae.getSource() == button[3]) {
            
            temporary[0] = Double.parseDouble(display.getText());
            function[0] = true;
            display.setText("");
        }
        if(ae.getSource() == button[4])
            display.append("4");
        if(ae.getSource() == button[5])
            display.append("5");
        if(ae.getSource() == button[6])
            display.append("6");
        if(ae.getSource() == button[7]) {
            
            temporary[0] = Double.parseDouble(display.getText());
            function[1] = true;
            display.setText("");
        }
        if(ae.getSource() == button[8])
            display.append("1");
        if(ae.getSource() == button[9])
            display.append("2");
        if(ae.getSource() == button[10])
            display.append("3");
        if(ae.getSource() == button[11]) {
            
            temporary[0] = Double.parseDouble(display.getText());
            function[2] = true;
            display.setText("");
        }
        if(ae.getSource() == button[12])
            display.append(".");
        if(ae.getSource() == button[13]) {
            
            temporary[0] = Double.parseDouble(display.getText());
            function[3] = true;
            display.setText("");
        }
        if(ae.getSource() == button[14])
            clear();
        if(ae.getSource() == button[15])
            getSqrt();
        if(ae.getSource() == button[16])
            getPosNeg();
        if(ae.getSource() == button[17])
            getResult();
        if(ae.getSource() == button[18])
            display.append("0");
    }

    public static void main(String[] arguments) {
        Program1 c = new Program1();
    }		//end main
}		//end class