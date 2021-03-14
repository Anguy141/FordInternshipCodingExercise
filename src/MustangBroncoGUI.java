/* 
 * @author Anh-Minh Tai Nguyen
 * This class contains the GUI interface class
 * as well as the main method used to display the GUI.
 * Press the run button to launch the GUI.
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class MustangBroncoGUI implements ActionListener {

	public static void main(String[] args) {
		new MustangBroncoGUI();

	}

	private JFrame frame;
	private JPanel panel;
	private GridLayout layout;
	private JButton start;
	private JButton clear;
	private JTextField input;
	private JLabel output;
	private JLabel message;
	
	private String enterInt = "Enter an Integer:";
	private String plsEnterInt = "Please enter an Integer";
	private String startStr = "Start";
	private String clearStr = "Clear";
	private String titleStr = "Mustang Bronco GUI";
	private String emptyStr = "";
	

	/*
	 * This is the constructor used to initialize all the variables and produce the
	 * GUI.
	 */
	public MustangBroncoGUI() {
		frame = new JFrame();
		frame.setPreferredSize(new Dimension(400, 300));
		panel = new JPanel();
		layout = new GridLayout(0, 1);

		message = new JLabel(enterInt);
		panel.add(message);

		input = new JTextField();
		panel.add(input);

		output = new JLabel();
		panel.add(output);

		start = new JButton(startStr);
		start.setActionCommand(startStr);
		start.addActionListener(this);
		frame.getRootPane().setDefaultButton(start);
		panel.add(start);

		clear = new JButton(clearStr);
		clear.setActionCommand(clearStr);
		clear.addActionListener(this);
		panel.add(clear);

		panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		panel.setLayout(layout);

		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(titleStr);
		frame.pack();
		frame.setVisible(true);

	}

	/*
	 * If the start button is clicked, it will try to run the getValue() method and
	 * display the result in the label. It will catch NumberFormatException if the
	 * textfield is either empty, or is not an integer. If the clear button is
	 * clicked, it will clear both the textfield and the label for a new value.
	 * 
	 * @param e corresponds to which button was clicked.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start) {
			try {
				int num = Integer.parseInt(input.getText());
				output.setText(getValue(num));
			} catch (NumberFormatException ex) {
				output.setText(plsEnterInt);
			}
		} else if (e.getSource() == clear) {
			input.setText(emptyStr);
			output.setText(emptyStr);
		}

	}

	/*
	 * This allows the "Enter" key to to submit the integer in addition to clicking
	 * the start key.
	 * 
	 * @param e corresponds to which physical button was pressed.
	 */
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			try {
				int num = Integer.parseInt(input.getText());
				output.setText(getValue(num));
			} catch (NumberFormatException ex) {
				output.setText(plsEnterInt);
			}

		}

	}

	/*
	 * This method takes an int value and determines what strings must be added
	 * based on the value's divisablity.
	 * 
	 * @param num value this method takes in.
	 * 
	 * @return str String this method returns. Will either return Mustang, Bronco,
	 * MustangBronco or the value itself.
	 */

	public static String getValue(int num) {
		String str = "";
		int value1 = 3;
		int value2 = 5;
		String string1 = "Mustang";
		String string2 = "Bronco";

		if (num % value1 == 0) {
			str += string1;
		}
		if (num % value2 == 0) {
			str += string2;
		}

		return str.isEmpty() ? String.valueOf(num) : str.toString();

	}

}
