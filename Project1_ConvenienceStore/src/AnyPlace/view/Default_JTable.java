package AnyPlace.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import AnyPlace.controller.DisposalCont;

import javax.swing.border.*;
import java.sql.*;

public class Default_JTable extends JFrame {

	// 테이블 헤더 데이터
	String col_name[] = { "중분류", "상품코드", "상품명", "폐기일시" };
	String data[][] ;//{{ "1.도시락", "1", "알찬도시락", "1", "06-11 00:00" }};
			
	// 생성자
	public Default_JTable() {
		final JFrame f = new JFrame();
		Container cp = f.getContentPane();
		DisposalCont disposalCont = new DisposalCont(); 
		data = disposalCont.getData();
		cp.setLayout(new FlowLayout());
		JTable table = new JTable(data, col_name);
		JScrollPane scrollPane = new JScrollPane(table);
		cp.add(scrollPane, BorderLayout.CENTER);

		f.setSize(500, 500);
		f.setVisible(true);
	}


	public static void main(String[] args) {
		Default_JTable default_JTable1 = new Default_JTable();
	}

}
