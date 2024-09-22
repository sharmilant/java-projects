package main.packages;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.ArrayList;
public class Window extends JFrame implements ActionListener, ItemListener {
	
	// Initialize Variables
	String name; // The name of the window
	JFrame mainWindow;
	CalendarMonth calMonth;
	JPanel panelMonthTable = new JPanel();
	JButton buttonUp = new JButton(" > ");
	JButton buttonDown = new JButton(" < ");
	Color colBorder = Color.LIGHT_GRAY;
	int sizeBorder = 1;
	Font fontCalDate = new Font("Times New Roman", Font.TRUETYPE_FONT, 14);
	Insets marginButton = new Insets(5,5,10,10);
	
	Color colorDateLabel =new Color(247, 214, 26);
	Color colorBorderDateLabel = Color.gray;
	
	String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	JComboBox monthCombo = new JComboBox(months);
	

	JComboBox<Integer> yearCombo = new JComboBox<>();
	
	
	
	// Set the Constructor and create the window
	public Window( String name, CalendarMonth _calMonth) {
		super();
		this.name = name;
		this.calMonth = _calMonth;
		int year = _calMonth.getYear();
		updateYearList();
		mainWindow = new JFrame(name);
		mainWindow.setLayout(new BorderLayout());
		
		buttonUp.setBorder(BorderFactory.createLineBorder(colBorder,sizeBorder));
		buttonUp.setMargin(marginButton);
		mainWindow.add(buttonUp,BorderLayout.EAST );
		buttonUp.addActionListener(this);
		
		buttonDown.setBorder(BorderFactory.createLineBorder(colBorder,sizeBorder));
		buttonDown.setMargin(marginButton);
		mainWindow.add(buttonDown, BorderLayout.WEST);
		buttonDown.addActionListener(this);
		
		
		monthCombo.setSelectedIndex(calMonth.getMonth());
		mainWindow.add(monthCombo, BorderLayout.NORTH);
		monthCombo.addItemListener(this);
		
		
		mainWindow.add(yearCombo, BorderLayout.SOUTH);
		yearCombo.setSelectedItem(year);
		yearCombo.addItemListener(this);
		
		mainWindow.setMinimumSize(new Dimension(400, 400));
		setPanelGridMonthTable();
		mainWindow.add(panelMonthTable, BorderLayout.CENTER);
		
	}
	
	// Main method to update the Calendar Table Panel
	private void setPanelGridMonthTable() {
		
		System.out.println("The method setPanelGridMonthTable has been called");
		
		
		ArrayList<JLabel> arrayLabel = new ArrayList();
		ArrayList<ArrayList> monthTable = calMonth.getMonthTable();
		int sizey = monthTable.size();
		int sizex = monthTable.get(1).size();
		this.panelMonthTable.setLayout(new GridLayout(sizey+1,sizex));
		System.out.println(sizex);
		System.out.println(sizey);
		
		String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
		
		for (int l=0; l<7; l++) {
			JLabel dayLabel = new JLabel(days[l]);
			dayLabel.setFont(fontCalDate);
			dayLabel.setBackground(colorDateLabel);
			dayLabel.setOpaque(true);
			panelMonthTable.add(dayLabel, 0 , l);
			
		}
		
		// Set the calendar Panel positions
		
		for (int i=0; i<sizey; i++) {
			int childTableSize = monthTable.get(i).size();
			for (int k=0; k<childTableSize; k++)
				{
					int dayInt = (int) monthTable.get(i).get(k);
					String day;
					if (dayInt == 0) {
						day = " ";
					}
					else {
						day = String.valueOf(dayInt) ;
					}
					
					JLabel dateLabel = new JLabel(day);
					dateLabel.setFont(fontCalDate);
					dateLabel.setBackground(colorDateLabel);
					
					dateLabel.setOpaque(true);
					panelMonthTable.add(dateLabel);
				}
		}
		
		// These commands allow to update the MonthTable panel
		panelMonthTable.revalidate();
		panelMonthTable.repaint();
		
	}
	
	
	public void windowPackShow() {
		/*
		 * This function allows to pack and see the window and the color of the window
		 */
		System.out.println("The method windowPackShow has been called");
		mainWindow.getContentPane().setBackground(Color.CYAN);
		mainWindow.pack();
		mainWindow.show();
	}
	
	// Update the Month Panel when the month has been changed
	private void setCalendarMonth() {
		/*
		 * Performs the actions needed when the month changes
		 */
		System.out.println("The method setCalendarMonth has been called");
		panelMonthTable.removeAll();
		setPanelGridMonthTable();
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == buttonUp) {
			/*
			 * Performs the different actions needed when Button Up has been clicked
			 */
			System.out.println("Button Up has been clicked");
			calMonth.setOneMonthUp();
			setCalendarMonth();
			yearCombo.setSelectedItem(calMonth.getYear());
			monthCombo.setSelectedIndex(calMonth.getMonth());
			
		}
		else if (e.getSource() == buttonDown) {
			/*
			 * Performs the different actions needed when Button Down has been clicked
			 */
			System.out.println("Button down has been clicked");
			calMonth.setOneMonthDown();
			setCalendarMonth();
			yearCombo.setSelectedItem(calMonth.getYear());
			monthCombo.setSelectedIndex(calMonth.getMonth());
			
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == monthCombo) {
			/*
			 * Performs the different actions needed when month has been changed with the Comboox
			 */
			System.out.println("The monthCombo ComboBox has been changed");
            calMonth.setMonthTable( calMonth.getYear(), monthCombo.getSelectedIndex());
            setCalendarMonth();
            
            
            }
		else if(e.getSource() == yearCombo) {
			/*
			 * Performs the different actions needed when year has been changed with the Comboox
			 */
			System.out.println("The yearCombo ComboBox has been changed");
            calMonth.setMonthTable((int)yearCombo.getSelectedItem(), calMonth.getMonth());
            setCalendarMonth();
            
		}
	
		
	}
	private void updateYearList() {
		/*
		 * This method allows to generate the values for the year combo Box
		 */
		
		System.out.println("The method updateYearList has been called.");
		for (int i=1900; i < 2100; i++) {
			
			yearCombo.addItem(i);
		}
	}
}
