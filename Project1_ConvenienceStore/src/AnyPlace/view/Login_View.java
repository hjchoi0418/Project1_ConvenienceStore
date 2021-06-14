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


public class Login_View extends JFrame {
	ImageIcon icon;
	JTextField id_field = new JTextField();
	private JTextField textField;
	
		

	public Dimension getPreferredSize(){
        Dimension largeBtnSz = new Dimension(super.getPreferredSize().width+30, super.getPreferredSize().height+30);
        return largeBtnSz;
    }

	     public Login_View() {
	    	
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
	    			final Image backgroundImage = javax.imageio.ImageIO.read(new File("./img/로그인_배경.jpg"));
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
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("나눔고딕", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(255, 204, 51));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(557, 498, 353, 55);
		getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setToolTipText("ID");
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setFont(new Font("나눔고딕", Font.BOLD, 15));
		textField.setBounds(557, 421, 353, 55);
		getContentPane().add(textField);
		textField.setColumns(10);
		setVisible(true);
		
		
	}
//	     class ImagePanel extends JPanel{
//	    	 private Image img;
//
//	    	 public ImagePanel (Image img) {
//	    	 	this.img = img;
//	    	 	setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
//	    	 	setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
//	    	 	setLayout(null);
//	    	 }
//	    	 public void paintComponent(Graphics g) {
//	    	 	g.drawImage(img, 0, 0, null);
//	    	 	
//	    	 	ImagePanel panel = new ImagePanel(new ImageIcon("./img/로그인_배경.jpg").getImage());
//	    		add(panel);
//	    	 	pack();
	    	 
	     


	public static void main(String[] args) {
		new Login_View();
		
	}
}

