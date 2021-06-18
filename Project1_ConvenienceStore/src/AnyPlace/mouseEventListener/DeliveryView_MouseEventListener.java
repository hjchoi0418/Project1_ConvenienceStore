package AnyPlace.mouseEventListener;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import AnyPlace.controller.DeliveryCont;

public class DeliveryView_MouseEventListener extends MouseAdapter {
	private JTable table;
	DeliveryCont deliveryCont = new DeliveryCont();
	
	private int row;
	private String product_no;
	static String[] str_arr;
	public static int[] nSelectedRow;
	
	public static int key_arr;
	public static int val_arr;
	
	public static int total_cost;
	public static HashMap<Integer,Integer> product_map = new HashMap<>(); // ���� ����Ҷ� ���� ��
	private HashMap<Integer, Integer> order_map = new HashMap<>(); // �ֹ��� �� ���°� ( product_map�̶� ���̾��µ� �׳�  ���λ��)
	
	public int getColCount() {
		return table.getColumnCount();
	}
	public int getRow() {
		return row;
	}

	public DeliveryView_MouseEventListener(JTable table) {
		this.table = table;
	}

	public String getProduct_no() {
		int idx = product_no.indexOf(".");

		return product_no.substring(1, idx);
	}

	// �� ���� ���ϱ� 
	public int getTotalCost(JTable table) {
		int[] int_arr;
		int_arr = new int[table.getRowCount()];
		str_arr = new String[table.getRowCount()];
		product_map = new HashMap<>();
		this.product_no = (String) table.getValueAt(row, 1);
		int idx = product_no.indexOf(".");
		for(int i=0; i<table.getRowCount(); i++) {

			int_arr[i] = Integer.parseInt(String.valueOf(table.getValueAt(i, 3)));
			str_arr[i] = table.getValueAt(i, 1).toString().substring(0,idx+1).replaceAll("[^\\d]","");
			
			product_map.put(Integer.parseInt(str_arr[i]), int_arr[i]);
		}
//		System.out.println(product_map);
		total_cost = deliveryCont.getTotalCost(product_map);
		return total_cost;
	}
	
	// �ֹ� �Ϸ� �ϱ� 
	public void addProducts(JTable table) {
		int[] key_arr; // p_no
		int[] val_arr; // ����
		
		key_arr = new int[table.getRowCount()];
		val_arr = new int[table.getRowCount()];
		
		this.product_no = (String) table.getValueAt(row, 1);
		int idx = product_no.indexOf(".");
		for(int i=0; i<table.getRowCount(); i++) {

			key_arr[i] = Integer.parseInt(table.getValueAt(i, 1).toString().substring(0,idx+1).replaceAll("[^\\d]","")); // p_no  
			val_arr[i] = Integer.parseInt(String.valueOf(table.getValueAt(i, 3))); // ����
			
			order_map.put(key_arr[i], val_arr[i]);
		}
		deliveryCont.deliveryOrder(order_map); // DeliveryCont�� p_no/���� �� ��� �ִ� map ����
	}
	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getButton() == 1) {
			this.row = table.getSelectedRow();
			this.product_no = (String) table.getValueAt(row, 1);
//			System.out.println(row);
			int idx = product_no.indexOf(".");
			System.out.println("dd : " + table.getValueAt(row, 1));
			product_no = product_no.substring(0,idx);
			System.out.println(product_no);

			int temp = 0 ;

			// serial_no �޾ƿ��� (������������ set�� ���)
			nSelectedRow = table.getSelectedRows(); // ���õ� ��

			str_arr = null;
			String strTemp = "";

			str_arr = new String[nSelectedRow.length];
			int[] int_arr = new int[nSelectedRow.length];
			
			int j = 0;
			// ���õ� ����� ��ǰ�ڵ�(p_no)���� #�� ������ strTemp�� �����
			for (int i : nSelectedRow) {
				strTemp = strTemp + "#" + table.getValueAt(i, 1).toString().substring(0,idx).replace(".","");
//				int_arr[j] = Integer.parseInt(String.valueOf(table.getValueAt(nSelectedRow[i], 3)));
//				str_arr[j++] = table.getValueAt(i, 1).toString().substring(0,idx).replace(".","");
			}

			
			// ���õ� ��ü ����� ���� + �̰� ��� !!!!!!!!!!!
			for(int i=0; i<nSelectedRow.length; i++) {
				temp = 0;
				temp = Integer.parseInt(String.valueOf(table.getValueAt(nSelectedRow[i], 3)));
				
				int_arr[i] = Integer.parseInt(String.valueOf(table.getValueAt(nSelectedRow[i], 3)));
				str_arr[i] = table.getValueAt(i, 1).toString().substring(0,idx).replace(".","");
//				System.out.println(i + "��° pno : " + product_no);
//				System.out.println(i + "��° ���� : " + table.getValueAt(nSelectedRow[i], 3));
//				table.setValueAt(temp+1, nSelectedRow[i], 3);
			}

			int_arr = new int[table.getRowCount()];
			str_arr = new String[table.getRowCount()];
			product_map = new HashMap<>();
			for(int i=0; i<table.getRowCount(); i++) {
				
				temp = 0;
				temp = Integer.parseInt(String.valueOf(table.getValueAt(i, 3)));

				int_arr[i] = Integer.parseInt(String.valueOf(table.getValueAt(i, 3)));
				str_arr[i] = table.getValueAt(i, 1).toString().substring(0,idx+1).replaceAll("[^\\d]","");
				
				product_map.put(Integer.parseInt(str_arr[i]), int_arr[i]);
			}
//			System.out.println(product_map);
			total_cost = deliveryCont.getTotalCost(product_map);
//			System.out.println("total : " + total_cost);

		} // Ŭ��

		if (e.getClickCount() == 2) {
			this.row = table.getSelectedRow();
			this.product_no = (String) table.getValueAt(row, 1);
			System.out.println("����Ŭ�� row : " + this.row);
			System.out.println("����Ŭ�� sno : " + this.product_no);
			
		} 

		if (e.getButton() == 3) {
		} // ������ Ŭ��
	}
}