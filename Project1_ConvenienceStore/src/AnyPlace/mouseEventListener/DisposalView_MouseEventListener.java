package AnyPlace.mouseEventListener;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.HashSet;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class DisposalView_MouseEventListener extends MouseAdapter {
	private JTable table;
	private int row;
	private String serial_no;
	public static String[] str_arr;

	public int getRow() {
		return row;
	}

	public DisposalView_MouseEventListener(JTable table) {
		this.table = table;
	}

	public String getSerial_no() {
		int idx = serial_no.indexOf("A");

		return serial_no.substring(0, idx);
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

			table.setForeground(new Color(75, 0, 130));

			// serial_no �޾ƿ��� (������������ set�� ���)
			int[] nSelectedRow = table.getSelectedRows(); // ���õ� ��

			str_arr = null;
			String strTemp = "";

			// ���õ� ����� ��ǰ�ڵ�(s_no)���� #�� ������ strTemp�� �����
			for (int i : nSelectedRow) {
				strTemp = strTemp + "#" + table.getValueAt(i, 1).toString();

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
