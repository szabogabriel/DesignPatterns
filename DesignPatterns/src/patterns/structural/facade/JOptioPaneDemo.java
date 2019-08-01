package patterns.structural.facade;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class JOptioPaneDemo {

	public static void main(String[] args) {
		showMessageWithoutJOptionPane();
		showMessageWithJOptioPane();
	}
	
	public static void showMessageWithoutJOptionPane() {
        JFrame frame = new JFrame("My Message Dialog created without JOptioPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("Ok");
        JLabel label = new JLabel("This is My Message Dialog!");

        ActionListener actionListener = new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                        System.exit(0);
                }
        };

        button.addActionListener(actionListener);
        Container contentPane = frame.getContentPane();
        contentPane.add(label, BorderLayout.CENTER);
        contentPane.add(button, BorderLayout.SOUTH);
        frame.setSize(250, 150);
        frame.setVisible(true);
	}
	
	
	public static void showMessageWithJOptioPane() {
		JFrame frame = new JFrame("My Message Dialog created with JOptioPane");
        JOptionPane.showMessageDialog(frame.getContentPane(), 
                "This is My Message Dialog!",
                "My Message Dialog created with JOptioPane", JOptionPane.ERROR_MESSAGE);
	}

}
