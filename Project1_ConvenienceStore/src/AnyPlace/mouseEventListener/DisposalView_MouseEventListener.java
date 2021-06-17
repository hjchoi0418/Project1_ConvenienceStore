package AnyPlace.mouseEventListener;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.HashSet;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class DisposalView_MouseEventListener extends MouseAdapter {
	private JTable table;
	private int row;
	private String serial_no;
	public static String[] str_arr;
	public static int[] rows;
	public int getRow() {
		return row;
	}

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

			// serial_no 받아오기 (여러개선택후 set에 담기)
			int[] nSelectedRow = table.getSelectedRows(); // 선택된 행

			str_arr = null;
			String strTemp = "";
			this.rows = new int[nSelectedRow.length];
			int j = 0 ;
			// 선택된 행들의 상품코드(s_no)들을 #을 붙혀서 strTemp에 담아줌
			for (int i : nSelectedRow) {
				strTemp = strTemp + "#" + table.getValueAt(i, 1).toString();
				rows[j++] = i;
			}

			// #이 들어간 갯수 구함 (총 선택된 상품 갯수)
			
			int str_cnt = strTemp.length() - strTemp.replace(String.valueOf('#'), "").length();
			this.str_arr = new String[nSelectedRow.length];

			
			// substring을 사용하여 s_no하나하나 배열에 담아줌 
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

		} // 클릭

		if (e.getClickCount() == 2) {
			this.row = table.getSelectedRow();
			this.serial_no = (String) table.getValueAt(row, 1);
			System.out.println("더블클릭 row : " + this.row);
			System.out.println("더블클릭 sno : " + this.serial_no);
			
		} 

		if (e.getButton() == 3) {
		} // 오른쪽 클릭
	}
}
