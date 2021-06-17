
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


public class Error_View extends JFrame{
	
	public Error_View () {
		JFrame error_frame = new JFrame();
		error_frame.setTitle("Error");
		error_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = error_frame.getContentPane();
		c.setLayout(null); // 배치관리자 사용 안함
		Color frame_color = new Color(22,56,81); //frame
		Color panel_color = new Color(69,96,117); //panel
		JButton back_btn = new JButton("BACK");
		JLabel label = new JLabel("중복된 ID 입니다.");
		c.setBackground(frame_color);
		error_frame.setSize(1200,700);
		error_frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(panel_color);
		panel.setSize(c.getWidth()/2,c.getHeight()/2);
		panel.setLocation(c.getWidth()/4, c.getHeight()/4);
		label.setBounds(panel.getWidth()/10*2, panel.getHeight()/10*3+20, panel.getWidth()/10*6, (int)(panel.getHeight()/10*1.3));
		label.setFont(new Font("굴림", Font.BOLD, 20));
		label.setForeground(Color.white);

		back_btn.setBounds(panel.getWidth()/10*2, panel.getHeight()/10*4+40, panel.getWidth()/10*6, (int)(panel.getHeight()/10*1.3));
		
		back_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Join_View jv = new Join_View();
				error_frame.dispose();
			}
		});
		
		panel.add(label);
		panel.add(back_btn);

		c.add(panel);
	}
	public static void main(String[] args) {
		new Error_View();
	}
}
