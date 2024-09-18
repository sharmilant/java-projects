package graphics;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import main.Logic;

public class CalculateButton extends AbstractAction{


	private Window window;
	
	public CalculateButton(Window window) {
		super("=");
		// TODO Auto-generated constructor stub
		this.window = window;
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Logic logic = new Logic(window);
		System.out.println("Clicked on = " );
		double result = logic.getResult();
		window.getOutput().setText(Double.toString(result));
		window.getOperator().setText("");
		window.clickedOperator(true);
		
	}

}
