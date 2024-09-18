package graphics;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;


public class ClearButton extends AbstractAction{


	private Window window;
	private String text;
	

	public ClearButton(Window window, String text) {
		super(text);
		// TODO Auto-generated constructor stub
		this.window = window;
		this.text = text;
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println("Clicked on " + text );
		window.getOutput().setText("");
		if (text=="Clear All") {
			window.getOperator().setText("");
			window.setNumber1(0);
		}
		window.clickedOperator(false);
		
	}
}
