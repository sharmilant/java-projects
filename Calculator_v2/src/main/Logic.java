package main;

import graphics.*;
public class Logic {
	
	private Window window;
	private double result;
	private Boolean clickedOperator;

	public Logic(Window window) {
		
		this.window = window;
		
	}
	
	
	public double getResult() {
		String operator = window.getOperator().getText();
		double number1 = window.getNumber1();
		double number2 = window.getNumber();
		if (operator == "+") {
			result = number1 + number2;
		}
		else if(operator == "-") {
			result = number1 - number2;
		}
		else if(operator == "*") {
			result = number1*number2;
		}
		else if(operator == "/") {
			result = number1/number2;
		}
		else { result = number2;}
		return result;
	}
}
