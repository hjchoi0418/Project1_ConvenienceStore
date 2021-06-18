package AnyPlace.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Employee_Join_Success_View extends JFrame {
	
	public Employee_Join_Success_View() {
		
		JFrame sv = new JFrame();
		sv.setTitle("Employee_Join_Success_View");
		sv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = sv.getContentPane();
		c.setLayout(null); // 배치관리자 사용 안함
		Color frame_color = new Color(22,56,81); //frame
		Color panel_color = new Color(69,96,117); //panel
		JButton login_btn = new JButton("Login");
		JLabel label = new JLabel("회원가입 성공.");
		c.setBackground(frame_color);
		sv.setSize(1200,700);
		sv.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(panel_color);
		panel.setSize(c.getWidth()/2,c.getHeight()/2);
		panel.setLocation(c.getWidth()/4, c.getHeight()/4);
		login_btn.setBounds(panel.getWidth()/10*2, panel.getHeight()/10*4+40, panel.getWidth()/10*6, (int)(panel.getHeight()/10*1.3));
		label.setBounds(panel.getWidth()/10*2, panel.getHeight()/10*3+20, panel.getWidth()/10*6, (int)(panel.getHeight()/10*1.3));
		label.setFont(new Font("굴림", Font.BOLD, 20));
		label.setForeground(Color.white);
		
		login_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Login_View lv = new Login_View(); 
				sv.dispose();
			}
		});
		
		panel.add(label);
		panel.add(login_btn);

		c.add(panel);
	}
	public static void main(String[] args) {
		new Employee_Join_Success_View();
	}
}
