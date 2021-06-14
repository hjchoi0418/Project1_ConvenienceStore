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


public class sale_View extends JFrame {
	ImageIcon icon;
	JTextField id_field = new JTextField();
	JTextField textField1;
	JTextField textField2;
	
		

	public Dimension getPreferredSize(){
        Dimension largeBtnSz = new Dimension(super.getPreferredSize().width+30, super.getPreferredSize().height+30);
        return largeBtnSz;
    }

	     public sale_View() {
	    	
	    	 setTitle("Any Place");
	    	 
	    	 getContentPane().setLayout(null);
	    	 
//icon = new ImageIcon("./img/로그인_배경.jpg");
//	    	 
//	    	 JPanel background = new JPanel() {
//	             public void paintComponent(Graphics g) {
//	                 // Approach 1: Dispaly image at at full size
//	                 g.drawImage(icon.getImage(), 0, 0, null);
//	                 // Approach 2: Scale image to size of component
//	                 // Dimension d = getSize();
//	                 // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
//	                 // Approach 3: Fix the image position in the scroll pane
//	                 // Point p = scrollPane.getViewport().getViewPosition();
//	                 // g.drawImage(icon.getImage(), p.x, p.y, null);
//	                 setOpaque(false); //그림을 표시하게 설정,투명하게 조절
//	                 super.paintComponent(g);
//	             }
//	    	 };
	    	 try {	
	    			final Image backgroundImage = javax.imageio.ImageIO.read(new File("./img/애니플_보드.jpg"));
	    		    setContentPane(new JPanel(new BorderLayout()) {
	    		        @Override public void paintComponent(Graphics g) {
	    		            g.drawImage(backgroundImage, 0, 0, null);
	    		            setOpaque(false);
	    	                super.paintComponent(g);
	    		        }
	    		    });
	    			} catch (IOException e) {
	    			    throw new RuntimeException(e);
	    			}
	    	 
		JFrame frame = new JFrame();
		

		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(1300,700);
		setSize(1467,902);
		getContentPane().setLayout(null);
		
		JButton 메뉴1=new JButton(new ImageIcon("./메뉴_over_01.png"));    
		메뉴1.setBounds(95,269,273, 86);    
		getContentPane().add(메뉴1);
		
		JButton 메뉴2=new JButton(new ImageIcon("./메뉴_02.png"));    
		메뉴2.setBounds(95,355, 273, 86);    
		getContentPane().add(메뉴2);
		
		JButton 메뉴3=new JButton(new ImageIcon("./메뉴_03.png"));    
		메뉴3.setBounds(95, 441 ,273, 86);    
		getContentPane().add(메뉴3);
		
		JButton 메뉴4=new JButton(new ImageIcon("./메뉴_04.png"));    
		메뉴4.setBounds(95, 527, 273, 86);    
		getContentPane().add(메뉴4);
		
		JButton 메뉴5=new JButton(new ImageIcon("./메뉴_05.png"));    
		메뉴5.setBounds(95, 613, 273, 86);    
		getContentPane().add(메뉴5);

		

	     }

	public static void main(String[] args) {
		new sale_View();
		
	}
}

