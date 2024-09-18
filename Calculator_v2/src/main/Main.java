package main;


import javax.swing.SwingUtilities;

import graphics.*;

public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				Window window = new Window();
				window.setVisible(true);
		
		}
		});

	}

}
