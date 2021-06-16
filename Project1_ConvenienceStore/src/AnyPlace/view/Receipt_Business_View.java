package AnyPlace.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import AnyPlace.controller.Receipt_Business;

public class Receipt_Business_View extends JPanel {
	ImageIcon icon;

	public Dimension getPreferredSize() {
		Dimension largeBtnSz = new Dimension(super.getPreferredSize().width + 30, super.getPreferredSize().height + 30);
		return largeBtnSz;
	}

	public Receipt_Business_View() {
		create_serch_button(this);
		JButton option_btn1 = create_option_button("영수증번호", 1);
		JButton option_btn2 = create_option_button("상품코드", 2);
		JButton option_btn3 = create_option_button("판매금액", 3);
		JButton option_btn4 = create_option_button("결제수단", 4);
		JButton option_btn5 = create_option_button("거래기간", 5);
		JButton option_btn6 = create_option_button("매출구분", 6);
		addtalbe(this);
		addlabel(this);
		add_Issuance_button(this);
		add_Resale_button(this);
		add_Return_button(this);
		add(option_btn1);
		add(option_btn2);
		add(option_btn3);
		add(option_btn4);
		add(option_btn5);
		add(option_btn6);
	}

	public static void addlabel(Container pane) {
		JTextArea text_area = new JTextArea(7, 20);
		text_area.append("asd\n");
		text_area.append("asd");
		text_area.append("asd");
		text_area.append("asd");
		text_area.append("asd");
		text_area.append("asd");
		text_area.append("asd");
		text_area.append("asd");

		JScrollPane panel = new JScrollPane(text_area);
		panel.setBounds(850, 269, 400, 380);

		pane.add(panel);
	}

	public static void addtalbe(Container pane) {

		String[] title = { "일자", "영수증", "금액", "거래구분" };
		DefaultTableModel model = new DefaultTableModel(title, 0);
		JTable table = new JTable(model);
		table.setRowSelectionAllowed(true);

		EtchedBorder eborder = new EtchedBorder();
		table.setBorder(eborder);

		JScrollPane panel = new JScrollPane(table);
		panel.setBounds(420, 269, 400, 380);

		Receipt_Business rb = new Receipt_Business();
		ResultSet rs = rb.all_Receipt();
		String[] data;

		try {
			while (rs.next()) {
				data = new String[] { "1", "1", "1", "1" };
				// data = new String[]{rs.getString(1), rs.getString(1), rs.getString(1),
				// rs.getString(1)};
				model.addRow(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pane.add(panel);
		// 메서드 말고 밖으로 빼야할듯..
	}

	public static void create_serch_button(Container pane) {
		ImageIcon icon = new ImageIcon("./image/serch.png");
		JButton btn = new JButton(icon);
		btn.setBackground(Color.white);
		btn.setBounds(1150, 100, 160, 100);

		pane.add(btn);
	}

	public static JButton create_option_button(String menu, int option_num) {
		JButton btn = new JButton(menu);
		btn.setBackground(Color.gray);
		switch (option_num) {
		case 1:
			btn.setBounds(450, 100, 100, 40);
			break;
		case 2:
			btn.setBounds(565, 100, 100, 40);
			break;
		case 3:
			btn.setBounds(675, 100, 100, 40);
			break;
		case 4:
			btn.setBounds(785, 100, 100, 40);
			break;
		case 5:
			btn.setBounds(895, 100, 100, 40);
			break;
		case 6:
			btn.setBounds(1005, 100, 100, 40);
			break;
		}
		return btn;
	}
	 	
	    public static void add_Issuance_button(Container pane) {
	    	JButton issuance_btn = new JButton("영수증발행");
	    	issuance_btn.setBounds(550, 720, 200, 65);
	    	pane.add(issuance_btn);
	    }
	    public static void add_Resale_button(Container pane) {
	    	JButton issuance_btn = new JButton("반품재판매");
	    	issuance_btn.setBounds(770, 720, 200, 65);
	    	pane.add(issuance_btn);
	    }
	    public static void add_Return_button(Container pane) {
	    	JButton issuance_btn = new JButton("반품업무");
	    	issuance_btn.setBounds(990, 720, 200, 65);
	    	pane.add(issuance_btn);
	    }
}

