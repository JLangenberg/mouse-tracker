package gui;

import java.awt.MouseInfo;

import javax.swing.JTextField;

public class MouseUpdater implements Runnable{
	// This thread
	private Thread MouseUpdaterThread;
	
	// JTextFields that are supposed to be changed
	public JTextField mousePosY;
	public JTextField mousePosX;
	// Constructor that takes in the text field it is supposed to change
	public MouseUpdater(JTextField mousePositionX, JTextField mousePositionY)	{
		mousePosX = mousePositionX;
		mousePosY = mousePositionY;
	}
	
	// Starts the thread.
	public void start()	{
		if (MouseUpdaterThread == null) {
			MouseUpdaterThread = new Thread (this);
			MouseUpdaterThread.start ();	
		}
	}
	
	// Continuously runs and changes the Text in the JTextFields to show the cursors position
	public void run()	{
		// Make the thread run continuously 
		while (true)	{
			// Get the Mouse Position and set the text to that
			mousePosX.setText(Double.toString(MouseInfo.getPointerInfo().getLocation().getX()));
			mousePosY.setText(Double.toString(MouseInfo.getPointerInfo().getLocation().getY()));
			
			// Make the thread wait to save processing time
			try {
				Thread.sleep(69);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
