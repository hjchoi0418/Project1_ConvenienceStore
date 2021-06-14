package AnyPlace.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.print.DocFlavor.URL;
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
	    			final Image backgroundImage = javax.imageio.ImageIO.read(new File("./img/�α���_���.jpg"));
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
		btnNewButton.setFont(new Font("�������", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(255, 204, 51));
		btnNewButton.setFocusPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(557, 498, 353, 55);
		getContentPane().add(btnNewButton);
		
		
		JButton joinButton = new JButton("join");
		//joinButton.setIcon(new ImageIcon("./img/���Թ�ư.jpg"));
	//	joinButton.setSelectedIcon(new ImageIcon("./img/���Թ�ư.jpg"));
		joinButton.setForeground(new Color(255, 204, 51));
		joinButton.setFont(new Font("�������", Font.PLAIN, 12));
		joinButton.setBorderPainted(false);
		joinButton.setContentAreaFilled(false);
		joinButton.setFocusPainted(false);
	
		joinButton.setBounds(850, 550, 74, 58);
		getContentPane().add(joinButton);
	     
	    
	     
		textField = new JTextField();
		textField.setToolTipText("ID");
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setFont(new Font("�������", Font.BOLD, 15));
		textField.setBounds(557, 421, 353, 55);
		getContentPane().add(textField);
		textField.setColumns(10);
		setVisible(true);
		
	     }

	public static void main(String[] args) {
		new Login_View();
		
	}
}

