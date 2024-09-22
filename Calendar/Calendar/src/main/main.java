/**
 * 
 */
package main;
import java.util.Calendar;

import main.packages.CalendarMonth;
import main.packages.Window;

import java.util.ArrayList;

/**
 * 
 */
public class main {

	/**
	 * @param args
	 */
	// The main class which allows to launch the calendar
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Set the object which contains the logic of Calendar
		CalendarMonth calTable = new CalendarMonth();
		
		// Set the object which will generate the window
		Window win = new Window("Calendar", calTable);
		win.windowPackShow();
	}
	
	
}
