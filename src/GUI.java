/* 
 * @author Anh-Minh Tai Nguyen
 * This is the GUI class that makes the GUI.
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI implements ActionListener {

	private JFrame frame;
	private JPanel panel;
	private GridLayout layout;
	private JButton start;
	private JButton clear;
	private JTextField input;
	private JLabel output;
	private JLabel message;

	/*
	 * This is the constructor used to initialize all the variables and produce the
	 * GUI.
	 */
	public GUI() {
		frame = new JFrame();
		frame.setPreferredSize(new Dimension(400, 300));
		panel = new JPanel();
		layout = new GridLayout(0, 1);

		message = new JLabel("Enter an Integer:");
		panel.add(message);

		input = new JTextField();
		panel.add(input);

		output = new JLabel();
		panel.add(output);

		start = new JButton("Start");
		start.setActionCommand("Start");
		start.addActionListener(this);
		panel.add(start);

		clear = new JButton("Clear");
		clear.setActionCommand("Clear");
		clear.addActionListener(this);
		panel.add(clear);

		panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		panel.setLayout(layout);

		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Mustang Bronco GUI");
		frame.pack();
		frame.setVisible(true);

	}

	/*
	 * If the start button is clicked, it will try to run the getValue() method and
	 * display the result in the label. It will catch NumberFormatException if the
	 * textfield is either empty, or is not an integer. If the clear button is
	 * clicked, it will clear both the textfield and the label for a new value.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start) {
			try {
				int num = Integer.parseInt(input.getText());
				output.setText(getValue(num));
			} catch (NumberFormatException ex) {
				output.setText("please enter an Integer");
			}
		} else if (e.getSource() == clear) {
			input.setText("");
			output.setText("");
		}

	}

	/*
	 * This method takes an int value and determines what strings must be added
	 * based on the value's divisablity.
	 * 
	 * @param num value this method takes in.
	 * 
	 * @return str String this method returns. Will either return Mustang, Bronco,
	 * MustangBronco or the value itself
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
