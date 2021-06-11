package AnyPlace.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class Login_View extends JFrame {


	JScrollPane scrollPane;
	ImageIcon icon;
	JTextField id_field = new JTextField();

	public Dimension getPreferredSize(){
        Dimension largeBtnSz = new Dimension(super.getPreferredSize().width+30, super.getPreferredSize().height+30);
        return largeBtnSz;
    }

	     public Login_View() {
	    	
	    	 setTitle("Any Place");
	    	 
	    	 setLayout(null);
	    	 
	    	 icon = new ImageIcon("./img/로그인_배경.jpg");
	    	 
	    	 JPanel background = new JPanel() {
	             public void paintComponent(Graphics g) {
	                 // Approach 1: Dispaly image at at full size
	                 g.drawImage(icon.getImage(), 0, 0, null);
	                 // Approach 2: Scale image to size of component
	                 // Dimension d = getSize();
	                 // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
	                 // Approach 3: Fix the image position in the scroll pane
	                 // Point p = scrollPane.getViewport().getViewPosition();
	                 // g.drawImage(icon.getImage(), p.x, p.y, null);
	                 setOpaque(false); //그림을 표시하게 설정,투명하게 조절
	                 super.paintComponent(g);
	             }
	    	 };
	    	 
		JFrame frame = new JFrame();
		JButton login_btn = new JButton();
		JTextField id_field = new JTextField();

		background.add(id_field);
		id_field.setText("ID 입력");
		id_field.setBounds(250,200 , 1800, 100);
		id_field.setFont(new Font("맑은고딕", Font.BOLD, 30));
		id_field.setForeground(new Color(153, 153, 153));
		id_field.setBackground(Color.white);
		/*
		id_field.setLayoutData(new GridData(100,100));
		//id_field.setSize(353,55);
	*/
		
		login_btn.setText("login!");
		login_btn.setBounds(557 , 498 , 500, 55);
		login_btn.setFont(new Font("맑은고딕", Font.BOLD, 30));
		login_btn.setForeground(Color.white);
		login_btn.setBackground(new Color(255, 204, 51));
		login_btn.setSize(353,55);
		scrollPane = new JScrollPane(background);
        setContentPane(scrollPane);
		
		
        background.add(login_btn);
        background.add(id_field);
		

		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(1300,700);
		setSize(1467,902);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Login_View();
	}
}