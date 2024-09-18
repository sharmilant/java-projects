package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.Logic;

public class Window extends JFrame{
	
	private JLabel output; // The label which will give the user the number that he has entered
	private JLabel operator; // The opeartor chosen by the user
	private Boolean clickedOperator = false; // To know if the user clicked in an operator
	private double number1 = 0; // The number which should be stored in memory and use to do the calculation
	private JLabel error; // The label that the user sees to indicate an error

	public Window() {
		// Window class constructor
		super();
		build();
		
	}
	
	private void build() {
		// To set the window basics properties
		setTitle("Simple Calculator");
		setSize(400, 400);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(2,1));
		add(buildVusualPane());
		add(buildButtonPane());
		setBackground(Color.CYAN);
		
		Logic logic = new Logic(this);
	}
	
	private JPanel buildVusualPane() {
		// The Pane which allows the user to see the different outputs
		JPanel pane = new JPanel();
		pane.setBackground(Color.lightGray);
		pane.setLayout(new GridLayout(3,1));
		output = new JLabel("", SwingConstants.CENTER);
		operator = new JLabel("", SwingConstants.CENTER);
		error = new JLabel("", SwingConstants.CENTER);
		output.setFont(new Font("TimesNewRoman", Font.BOLD, 20)); // Set the font size to 16 points
		error.setFont(new Font("SansSerif", Font.ITALIC, 12));
		pane.add(error);
		pane.add(output);
		pane.add(operator);
		
		
		return pane;
	}
	private JPanel buildButtonPane() {
		
		// The pane that allows to store the buttons
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(1, 2));
		pane.setBackground(Color.green);
		
		pane.add(buildNumberButtonPane());
		pane.add(buildOperatorButtonPane());
		

		
		return pane;
	}
	
	private JPanel buildNumberButtonPane() {
		// We create the different buttons for number 
		JPanel paneNumber = new JPanel();
		paneNumber.setLayout(new GridLayout(5, 3));
		int lastNumber = 0;
		List<JButton> numberButtonArray = new ArrayList<JButton>();
		for (int i =0; i<=9; i++) {
			numberButtonArray.add(new JButton(new NumberButton(this, Integer.toString(i))));
			paneNumber.add(numberButtonArray.get(i));
			lastNumber = i;
		}
		numberButtonArray.add(new JButton(new NumberButton(this, ".")));
		paneNumber.add(numberButtonArray.get(lastNumber+1));
		JButton equalButton = new JButton(new CalculateButton(this));
		paneNumber.add(equalButton);
		JButton clearButton = new JButton(new ClearButton(this, "Clear"));
		paneNumber.add(clearButton);
		JButton clearAllButton = new JButton(new ClearButton(this, "Clear All"));
		paneNumber.add(clearAllButton);
		
		
		return paneNumber;
	}
	
	private JPanel buildOperatorButtonPane() {
		// We create the different operators
		JPanel paneOperator = new JPanel();
		paneOperator.setLayout(new GridLayout(4,1));
		
		// We put the different operators in a List
		List<String> operators = new ArrayList<String>();
		operators.add("+"); operators.add("-"); operators.add("*"); operators.add("/");
		int lengthOperator = operators.size();
		
		List<JButton> operatorButtonArray = new ArrayList<JButton>();
		for (int i=0; i<lengthOperator; i++) {
			operatorButtonArray.add(new JButton(new OperatorButton(this, operators.get(i))));
			(operatorButtonArray.get(i)).setSize(new Dimension(1, 1));
			paneOperator.add(operatorButtonArray.get(i));
		}

		return paneOperator;
	}

	public double getNumber() {
		// To get the entered number
		try {
		double number = Double.parseDouble(output.getText());
		return number;
		}
		catch(NullPointerException e) {
			System.out.println("There is no number to be converted !");
			error.setText("There is no number to be converted !");
			output.setText("0");
			return 0;
		}
		catch(NumberFormatException e) {
			System.out.println("The number were given in an incorrect format !");
			error.setText("There is no number to be converted ! \n The number was given in an incorrect format !");
			output.setText("0");
			return 0;
		}
		}
	public void clickedOperator(Boolean clicked) {
		// allows to set the value of clicked operator by the other classes
		clickedOperator = clicked;
		if (clickedOperator==true ) {
			number1 = getNumber();
			
			/*if (equal == false) {
			output.setText("");
		}*/}
	}
	public Boolean getClickedOperator() {
		// Return the value of the status of clicked operator
		return clickedOperator;
	}
	
	public JLabel getOperator() {
		// Return the used value of the label operator
		return operator;
	}
	
	public JLabel getOutput() {	
		// Return the value of the label Output
		return output;
	}
	
	public JLabel getError() {	
		return error;
	}
	
	public double getNumber1() {
		return number1;
	}
	public void setNumber1(double number) {
		number1 = number;
	}

}
