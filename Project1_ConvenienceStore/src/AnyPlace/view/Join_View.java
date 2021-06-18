package AnyPlace.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
	    			final Image backgroundImage = javax.imageio.ImageIO.read(new File("./img/백보드.jpg"));
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
		setLocation(200,100);
		setSize(1467,902);
		getContentPane().setLayout(null);
	
		JTextField textField1 = new JTextField();
		textField1.setToolTipText("NAME");
		textField1.setHorizontalAlignment(SwingConstants.LEFT);
		textField1.setFont(new Font("나눔고딕", Font.BOLD, 15));
		textField1.setBounds(557, 421, 353, 55);
		getContentPane().add(textField1);
		textField1.setColumns(10);
		setVisible(true);
		
		JTextField textField2 = new JTextField();
		textField2.setToolTipText("ID");
		textField2.setHorizontalAlignment(SwingConstants.LEFT);
		textField2.setFont(new Font("나눔고딕", Font.BOLD, 15));
		textField2.setBounds(557, 354, 353, 55);
		getContentPane().add(textField2);
		textField2.setColumns(10);
		setVisible(true);
		
		JButton btnNewButton = new JButton("CREATE ACCOUNT");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("나눔고딕", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(255, 204, 51));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField1.getText();
				String id = textField2.getText();
				Join.setNew_employee_id(name);
				Join.setNew_employee_name(id);
				Join.main(null);
				
				if (id.length() <= 0) {
					JOptionPane.showMessageDialog(null, "ID를 입력해주세요.");
				} else if (name.length() <= 0) {
					JOptionPane.showMessageDialog(null, "이름을 입력해주세요.");
				} else if(Join.isSuccess()) {
					new Employee_Join_Success_View();
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, 
							"중복된 아이디입니다.", "경고",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(557, 498, 353, 55);
		getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login_View();
				dispose();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("나눔고딕", Font.BOLD, 30));
		btnBack.setBackground(new Color(255, 204, 51));
		btnBack.setBounds(120, 120, 60, 60);
		getContentPane().add(btnBack);
	}

	public static void main(String[] args) {
		new Join_View();
	}
}
