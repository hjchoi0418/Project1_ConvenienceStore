package AnyPlace.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import AnyPlace.controller.DisposalCont;

import javax.swing.border.*;
import java.sql.*;

public class Default_JTable extends JFrame {

	// ���̺� ��� ������
	String col_name[] = { "�ߺз�", "��ǰ�ڵ�", "��ǰ��", "����Ͻ�" };
	String data[][] ;//{{ "1.���ö�", "1", "�������ö�", "1", "06-11 00:00" }};
			
	// ������
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
