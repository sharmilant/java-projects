package graphics;

import java.awt.event.ActionEvent;
import main.*;

import javax.swing.AbstractAction;

import main.Logic;

public class OperatorButton  extends AbstractAction{
	private String text;
	private Window window;


	public OperatorButton(Window window, String text){
		super(text);
		
		this.text = text;
		this.window =window;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Clicked on button " + text);
		window.getOperator().setText(text);
		/*
		Logic logic = new Logic(window);
		double result = logic.getResult();
		window.getOutput().setText(Double.toString(result));
		*/
		window.clickedOperator(true);
	}
	


}
