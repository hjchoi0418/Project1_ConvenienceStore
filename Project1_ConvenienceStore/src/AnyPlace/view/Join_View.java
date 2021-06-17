package AnyPlace.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import AnyPlace.controller.Join;


public class Join_View extends JFrame {

	public Dimension getPreferredSize(){
        Dimension largeBtnSz = new Dimension(super.getPreferredSize().width+30, super.getPreferredSize().height+30);
        return largeBtnSz;
    }

	     public Join_View() {
	    	
	    	 setTitle("Any Place");
	    	 
	    	 getContentPane().setLayout(null);
	    	 
	    	 try {	
	    			final Image backgroundImage = javax.imageio.ImageIO.read(new File("./img/¹éº¸µå.jpg"));
	    		    setContentPane(new JPanel(new BorderLayout()) {
	    		        @Override public void paintComponent(Graphics g) {
	    		            g.drawImage(backgroundImage, 0, 0, null);
	    		            setOpaque(false);
	    	                super.paintComponent(g);
	    		        }
	    		    });
	    			} catch (IOException e) {
	    				
	    			}
	    	 
		JFrame frame = new JFrame();
		

		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(0,0);
		setSize(1467,902);
		getContentPane().setLayout(null);
	
		
		JTextField textField1 = new JTextField();
		textField1.setToolTipText("NAME");
		textField1.setHorizontalAlignment(SwingConstants.LEFT);
		textField1.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		textField1.setBounds(557, 421, 353, 55);
		getContentPane().add(textField1);
		textField1.setColumns(10);
		setVisible(true);
		
		JTextField textField2 = new JTextField();
		textField2.setToolTipText("ID");
		textField2.setHorizontalAlignment(SwingConstants.LEFT);
		textField2.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		textField2.setBounds(557, 354, 353, 55);
		getContentPane().add(textField2);
		textField2.setColumns(10);
		setVisible(true);
		
		JButton btnNewButton = new JButton("CREATE ACCOUNT");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(255, 204, 51));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField1.getText();
				String id = textField2.getText();
				Join.setNew_employee_id(name);
				Join.setNew_employee_name(id);
				Join.main(null);
				
				if(Join.isSuccess()) {				
					Employee_Join_Success_View jsv = new Employee_Join_Success_View();
					frame.dispose();
					}
				else {
					Error_View ev = new Error_View();
					frame.dispose();
				}
			}
		});
		btnNewButton.setBounds(557, 498, 353, 55);
		getContentPane().add(btnNewButton);
		
		
	}

	public static void main(String[] args) {
		new Join_View();
		
	}
}

