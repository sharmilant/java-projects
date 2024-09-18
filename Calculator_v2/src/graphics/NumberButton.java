package graphics;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;


public class NumberButton extends AbstractAction {
	
	private Window window;
	private String text1;
	private double number;

	public NumberButton(Window window, String text) {
		// TODO Auto-generated constructor stub
		super(text);
		this.text1 = text;
		this.window = window;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("Clicked on button " + text1);
		if (window.getClickedOperator()== false) {
			String currentOutput = window.getOutput().getText();
			window.getOutput().setText(currentOutput + text1);
		}
		else {
			window.getOutput().setText(text1);
		}
		window.clickedOperator(false);
		window.getError().setText("");
		
	}

}
