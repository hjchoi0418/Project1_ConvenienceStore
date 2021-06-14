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
	    	 
//icon = new ImageIcon("./img/�α���_���.jpg");
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
//	                 setOpaque(false); //�׸��� ǥ���ϰ� ����,�����ϰ� ����
//	                 super.paintComponent(g);
//	             }
//	    	 };
	    	 try {	
	    			final Image backgroundImage = javax.imageio.ImageIO.read(new File("./img/�ִ���_����.jpg"));
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
		
		JButton �޴�1=new JButton(new ImageIcon("./�޴�_over_01.png"));    
		�޴�1.setBounds(95,269,273, 86);    
		getContentPane().add(�޴�1);
		
		JButton �޴�2=new JButton(new ImageIcon("./�޴�_02.png"));    
		�޴�2.setBounds(95,355, 273, 86);    
		getContentPane().add(�޴�2);
		
		JButton �޴�3=new JButton(new ImageIcon("./�޴�_03.png"));    
		�޴�3.setBounds(95, 441 ,273, 86);    
		getContentPane().add(�޴�3);
		
		JButton �޴�4=new JButton(new ImageIcon("./�޴�_04.png"));    
		�޴�4.setBounds(95, 527, 273, 86);    
		getContentPane().add(�޴�4);
		
		JButton �޴�5=new JButton(new ImageIcon("./�޴�_05.png"));    
		�޴�5.setBounds(95, 613, 273, 86);    
		getContentPane().add(�޴�5);

		

	     }

	public static void main(String[] args) {
		new sale_View();
		
	}
}

