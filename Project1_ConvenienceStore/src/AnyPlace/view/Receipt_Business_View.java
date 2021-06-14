package AnyPlace.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Receipt_Business_View extends JFrame{
	
	public Receipt_Business_View() {
		JFrame receipt_frame = new JFrame();
		receipt_frame.setTitle("Receipt_Business_View");
		receipt_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = receipt_frame.getContentPane();
		c.setLayout(null); // 배치관리자 사용 안함
		Color frame_color = new Color(22,56,81); //frame
	
		c.setBackground(frame_color);
		receipt_frame.setSize(1200,700);
		receipt_frame.setVisible(true);
		
		JPanel panel = create_panel(c);
		
		JLabel label = create_label(panel);
		
		JButton serch_btn = create_serch_button(panel);
		
		JButton option_btn1 = create_option_button("영수증번호", panel, 1);
		JButton option_btn2 = create_option_button("상품코드", panel, 2);
		JButton option_btn3 = create_option_button("판매금액", panel, 3);
		JButton option_btn4 = create_option_button("결제수단", panel, 4);
		JButton option_btn5 = create_option_button("거래기간", panel, 5);
		JButton option_btn6 = create_option_button("매출구분", panel, 6);
		

		
		panel.add(option_btn1);
		panel.add(option_btn2);
		panel.add(option_btn3);
		panel.add(option_btn4);
		panel.add(option_btn5);
		panel.add(option_btn6);
		panel.add(label);
		panel.add(serch_btn);

		c.add(panel);
	}
	
	public static JTable create_table(JPanel panel) {
		
		String title[] = {"일자", "영수증", "시간", "금액", "거래구분"}; 
		Object[][] data = {{"1", "1", "1", "1", "1"},{"1", "1", "1", "1", "1"}}; 
		JTable table = new JTable(data,title);
		table.setBounds(panel.getWidth()/10*2, panel.getHeight()/10*4, panel.getWidth()/10*6, (int)(panel.getHeight()/10*6));
		JScrollPane scroll = new JScrollPane(table);
		table.add(scroll);
		return table;
		
	}
	public static JButton create_option_button(String menu, JPanel panel, int option_num) {
		JButton btn = new JButton(menu);
		btn.setBackground(Color.gray);
		switch(option_num) {
			case 1:
				btn.setBounds(panel.getWidth()/10*8-165, panel.getHeight()/10*1, 95, 40);
				break;
			case 2:
				btn.setBounds(panel.getWidth()/10*8-275, panel.getHeight()/10*1, 95, 40);
				break;
			case 3:
				btn.setBounds(panel.getWidth()/10*8-385, panel.getHeight()/10*1, 95, 40);
				break;
			case 4:
				btn.setBounds(panel.getWidth()/10*8-495, panel.getHeight()/10*1, 95, 40);
				break;
			case 5:
				btn.setBounds(panel.getWidth()/10*8-605, panel.getHeight()/10*1, 95, 40);
				break;
			case 6:
				btn.setBounds(panel.getWidth()/10*8-715, panel.getHeight()/10*1, 95, 40);
				break;
		}
		return btn;	
	}
	
	public static JButton create_serch_button(JPanel panel) {
		ImageIcon icon = new ImageIcon("./image/serch.png");
		JButton btn = new JButton(icon);
		btn.setBackground(Color.white);
		btn.setBounds(panel.getWidth()/10*8, panel.getHeight()/10*1, 125, 110);
		
		
		return btn;	
	}
	
	public static JLabel create_label(JPanel panel) {
		JLabel label = new JLabel("중복된 ID 입니다.");
		label.setBounds(panel.getWidth()/10*2, panel.getHeight()/10*3+20, panel.getWidth()/10*6, (int)(panel.getHeight()/10*1.3));
		label.setFont(new Font("굴림", Font.BOLD, 20));
		label.setForeground(Color.white);
		
		return label;
	}
	
	public static JPanel create_panel(Container c) {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.white);
		panel.setSize(c.getWidth()/5*4-15,c.getHeight()-50);
		panel.setLocation(c.getWidth()/5, 25);
		
		return panel;
	}
	
	public static void main(String[] args) {
		new Receipt_Business_View();
	}
}
