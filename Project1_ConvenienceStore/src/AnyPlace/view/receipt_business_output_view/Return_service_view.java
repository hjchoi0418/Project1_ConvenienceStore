package AnyPlace.view.receipt_business_output_view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Return_service_view extends JFrame{

	public Return_service_view() {
		
		JFrame frame = new JFrame(); 
   	
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(0,0);
		setSize(400,300);
		getContentPane().setLayout(null);
		setVisible(true);
  	
	   	JLabel label = new JLabel("»èÁ¦¿Ï·á");
	   	label.setBounds(100,80,250,100);

	   	Font font = new Font("¸¼Àº °íµñ", Font.BOLD, 40);
	   	label.setFont(font);

	   	getContentPane().add(label);
	}

	public static void main(String[] args) {
		new Return_service_view();
	}
}
