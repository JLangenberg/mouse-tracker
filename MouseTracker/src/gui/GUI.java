package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import java.awt.Color;

public class GUI {

	private JFrame frame;
	private JTextField mousePosY;
	private JTextField mousePosX;
	private JTextField showMouseX;
	private JTextField showMouseY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.MAGENTA);
		frame.setBounds(100, 100, 278, 153);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[76px][76px][76px][81px]", "[45.00px][45.00px]"));
		
		// Field that will display text
		showMouseX = new JTextField();
		showMouseX.setForeground(Color.MAGENTA);
		showMouseX.setBackground(Color.BLUE);
		showMouseX.setFont(new Font("Dialog", Font.PLAIN, 14));
		showMouseX.setText("Mouse X Position");
		frame.getContentPane().add(showMouseX, "cell 0 0 2 1,grow");
		showMouseX.setColumns(10);
		
		// Field that will display the x position of the cursor
		mousePosX = new JTextField();
		mousePosX.setText("test");
		mousePosX.setForeground(Color.ORANGE);
		mousePosX.setBackground(Color.RED);
		mousePosX.setFont(new Font("Dialog", Font.PLAIN, 14));
		frame.getContentPane().add(mousePosX, "cell 2 0 2 1,grow");
		mousePosX.setColumns(10);
		
		// Field that will display text
		showMouseY = new JTextField();
		showMouseY.setForeground(Color.DARK_GRAY);
		showMouseY.setBackground(Color.BLACK);
		showMouseY.setText("Mouse Y Position");
		showMouseY.setFont(new Font("Dialog", Font.PLAIN, 14));
		frame.getContentPane().add(showMouseY, "cell 0 1 2 1,grow");
		showMouseY.setColumns(10);
		
		// Field that will display the y position of the cursor
		mousePosY = new JTextField();
		mousePosY.setForeground(Color.CYAN);
		mousePosY.setText("test");
		mousePosY.setBackground(Color.GREEN);
		mousePosY.setFont(new Font("Dialog", Font.PLAIN, 14));
		frame.getContentPane().add(mousePosY, "cell 2 1 2 1,grow");
		mousePosY.setColumns(10);
		
		//ASKTEACHER: Is it oak to do that in initialize()? It is a part of the GUI,
		// but it doesn't have anything to do with the object.
		// Start a thread that continuously updates the two windows to show the current
		// cursor position
		MouseUpdater mouseUpdater = new MouseUpdater(mousePosX, mousePosY);
		mouseUpdater.start();
	}

}
