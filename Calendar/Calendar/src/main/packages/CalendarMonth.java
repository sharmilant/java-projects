package main.packages;

import java.util.ArrayList;
import java.util.Calendar;

import main.enumerations.Month;
public class CalendarMonth {
	ArrayList<ArrayList> monthTable = new ArrayList();
	int month ;
	int year;
	Calendar cal= Calendar.getInstance();
	ArrayList<Coordonate> dayMonthCoord = new ArrayList();
	
	public CalendarMonth() {
		
		this.year = cal.get(cal.YEAR);
		this.month = cal.get(cal.MONTH);
		setMonthTable(year, month);
		
	}
	

	public void setMonthTable(int _year, int _month){
		monthTable.clear();
		dayMonthCoord.clear();
		this.year = _year;
		this.month = _month;
		
		System.out.println("--------------------------------------------");
		System.out.print("The month has been set to : ");
		System.out.println(Month.values()[month]);
		System.out.print("The year has been set to : ");
		System.out.println(year);
		System.out.println("--------------------------------------------");
		cal.set(year, month, 1);
		int numberOfDaysMonth = cal.getActualMaximum(cal.DAY_OF_MONTH);
		ArrayList<Integer> lineMonthTable = new ArrayList();
		/*ArrayList<String> dayWeekTable = new ArrayList();
		dayWeekTable.add("Mon");dayWeekTable.add("Tue");dayWeekTable.add("Wed");dayWeekTable.add("Thu");
		dayWeekTable.add("Fri");dayWeekTable.add("Sat");dayWeekTable.add("Sun");
		monthTable.add(dayWeekTable);*/
		int dayWeekSundayFirst = cal.get(cal.DAY_OF_WEEK) ;
		int column = 0;
		int dayWeek = dayWeekSundayFirst-1;
		if (dayWeekSundayFirst == 1) {
			dayWeek = 7;
		}
		
		for (int i=1; i<=numberOfDaysMonth; i++) {	
			
			int posMonthTable = 0;
			while (posMonthTable < dayWeek-1 && i == 1) {
				posMonthTable++;
				lineMonthTable.add(0);	
			}
			
			Coordonate coord = new Coordonate(dayWeek-1,column);
			dayMonthCoord.add(coord);
			dayWeek ++;
			lineMonthTable.add(i);

			if (dayWeek == 8 || i == numberOfDaysMonth) {
				
				dayWeek = 1;
				column ++;
				if (i==numberOfDaysMonth) {
				while(lineMonthTable.size()<7) {
					lineMonthTable.add(0);
					}
				}
				System.out.println("Case 1");
				System.out.println(lineMonthTable);
				monthTable.add((ArrayList) lineMonthTable.clone());
				lineMonthTable.clear();
			}

			
		}

		
		System.out.println("--------------------------------");



	}
	
	public ArrayList<ArrayList> getMonthTable(){
		return monthTable;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public ArrayList<Coordonate> getCoordDay(){
		return dayMonthCoord;
	}
	
	public void setOneMonthUp() {
		if (month == 11) {
			this.month = 0;
			this.year ++;
		}
		else {
			this.month ++;
		}
		setMonthTable(year, month);
	}

	public void setOneMonthDown() {
		if (month == 0) {
			this.month = 11;
			this.year --;
			System.out.println(month);
		}
		else {
			this.month --;
			System.out.println(month);
		}
		setMonthTable(year, month);
		System.out.println(this.month);
		
	}
	
	

}
