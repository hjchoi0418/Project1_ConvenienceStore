package AnyPlace.mouseEventListener;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.HashSet;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import AnyPlace.controller.DisposalCont;

public class DisposalView_MouseEventListener extends MouseAdapter {
	DisposalCont disposalCont = new DisposalCont();
	private JTable table;
	private int row;
	private String serial_no;
	public static String[] str_arr;
	public static int[] rows;
	public int getRow() {
		return row;
	}

//	// �� ���� ���ϱ� 
//	public int getTotalCost(JTable table) {
//		int[] int_arr;
//		int_arr = new int[table.getRowCount()];
//		str_arr = new String[table.getRowCount()];
//		product_map = new HashMap<>();
//		this.product_no = (String) table.getValueAt(row, 1);
//		int idx = product_no.indexOf(".");
//		for(int i=0; i<table.getRowCount(); i++) {
//
//			int_arr[i] = Integer.parseInt(String.valueOf(table.getValueAt(i, 3)));
//			str_arr[i] = table.getValueAt(i, 1).toString().substring(0,idx+1).replaceAll("[^\\d]","");
//			
//			product_map.put(Integer.parseInt(str_arr[i]), int_arr[i]);
//		}
////		System.out.println(product_map);
//		total_cost = deliveryCont.getTotalCost(product_map);
//		return total_cost;
//	}
	
	public DisposalView_MouseEventListener(JTable table) {
		this.table = null;
		this.table = table;
	}

	public String getSerial_no() {
		int idx = serial_no.indexOf("A");

		return serial_no.substring(0, idx);
	}

	public void delRecode(DefaultTableModel model) {
		System.out.println("rows.length : " + rows.length);
		for(int i=0; i<rows.length; i++) {
			System.out.print("rows[i] : ");
			System.out.println(rows[i]);
			
			model.removeRow(rows[i]);
		}
	}
	public void delData(JTable table) {
		int[] nSelectedRow = table.getSelectedRows();
		String strTemp = "";
		for (int i : nSelectedRow) {
			strTemp = strTemp + "#" + table.getValueAt(i, 1).toString();
		}

		str_arr = new String[nSelectedRow.length];
		
		// substring�� ����Ͽ� s_no�ϳ��ϳ� �迭�� ����� 
		for (int i = 0; i < str_arr.length; i++) {
			str_arr[i] = strTemp.substring(strTemp.indexOf("#") + 1,(strTemp.substring(strTemp.indexOf("#")).indexOf("A")));
			strTemp = strTemp.substring(strTemp.indexOf("#") + 1);
			try {
				strTemp = strTemp.substring(strTemp.indexOf("#"));
			} catch (Exception e1) {

			}
		}
		System.out.println("str : : " + Arrays.toString(str_arr));
		disposalCont.delData(str_arr);
	}
	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getButton() == 1) {
			this.row = table.getSelectedRow();
			this.serial_no = (String) table.getValueAt(row, 1);
//			System.out.println(row);
			int idx = serial_no.indexOf("A");
//			System.out.println("dd : " + table.getValueAt(row, 1));
//			System.out.println(serial_no.substring(0,idx));

//			table.setForeground(new Color(75, 0, 130));

			// serial_no �޾ƿ��� (������������ set�� ���)
			int[] nSelectedRow = table.getSelectedRows(); // ���õ� ��

			str_arr = null;
			String strTemp = "";
			this.rows = new int[nSelectedRow.length];
			int j = 0 ;
			// ���õ� ����� ��ǰ�ڵ�(s_no)���� #�� ������ strTemp�� �����
			for (int i : nSelectedRow) {
				strTemp = strTemp + "#" + table.getValueAt(i, 1).toString();
				rows[j++] = i;
			}

			// #�� �� ���� ���� (�� ���õ� ��ǰ ����)
			
			int str_cnt = strTemp.length() - strTemp.replace(String.valueOf('#'), "").length();
			this.str_arr = new String[nSelectedRow.length];

			
			// substring�� ����Ͽ� s_no�ϳ��ϳ� �迭�� ����� 
			for (int i = 0; i < str_cnt; i++) {
				this.str_arr[i] = strTemp.substring(strTemp.indexOf("#") + 1,(strTemp.substring(strTemp.indexOf("#")).indexOf("A")));
				strTemp = strTemp.substring(strTemp.indexOf("#") + 1);
				try {
					strTemp = strTemp.substring(strTemp.indexOf("#"));
				} catch (Exception e1) {

				}
			}
			System.out.print("str_arr");
			System.out.println(Arrays.toString(str_arr));

		} // Ŭ��

		if (e.getClickCount() == 2) {
			this.row = table.getSelectedRow();
			this.serial_no = (String) table.getValueAt(row, 1);
			System.out.println("����Ŭ�� row : " + this.row);
			System.out.println("����Ŭ�� sno : " + this.serial_no);
			
		} 

		if (e.getButton() == 3) {
		} // ������ Ŭ��
	}
}