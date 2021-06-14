package AnyPlace.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import AnyPlace.controller.Cash_Management;

public class Cash_Management_view extends JFrame implements TableModelListener {

	// 표 제목줄
	String[] colNames = new String[] { "권종", "수량", "금액" };
	// 표에 들어갈 데이터들 / 처음엔 빈 테이블 만들기 위해 데이터관리객체 생성
	private Object[][] data = {
            {"50,000원", 0, 0},
            {"10,000원", 0, 0},
            {"5,000원", 0, 0},
            {"1,000원", 0, 0},
            {"500원", 0, 0},
            {"100원", 0, 0},
            {"50원", 0, 0},
            {"10원", 0, 0},
    };
    private String[] columnType = { "권종", "수량", "금액" };
	DefaultTableModel model = new DefaultTableModel(data, columnType) {
		Class[] columnTypes = new Class[] { String.class, Integer.class, Integer.class };

		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}

		boolean[] columnEditables = new boolean[] { false, true, false };

		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
	};
    private JScrollPane scrollPane;
    private JTable table;
	JPanel bottomPanel;
	JButton btnPrint;
	
	public Cash_Management_view() {
		setTitle("시재점검");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setBounds(100, 100, 1000, 500);
		setResizable(false);
		
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		bottomPanel = new JPanel();
		btnPrint = new JButton("발행");

		add(scrollPane, BorderLayout.CENTER);

		table.getModel().addTableModelListener(this);

		btnPrint.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Cash_Management.main(null);
			}
		});

		bottomPanel.setLayout(new GridLayout());
		bottomPanel.add(btnPrint);

		add(bottomPanel, BorderLayout.SOUTH);
		setVisible(true);
	}

	public int get50000() {
		return Integer.parseInt("" + table.getValueAt(0, 1));
	}
	
	public int get10000() {
		return Integer.parseInt("" + table.getValueAt(1, 1));
	}
	
	public int get5000() {
		return Integer.parseInt("" + table.getValueAt(2, 1));
	}
	
	public int get1000() {
		return Integer.parseInt("" + table.getValueAt(3, 1));
	}
	
	public int get500() {
		return Integer.parseInt("" + table.getValueAt(4, 1));
	}
	
	public int get100() {
		return Integer.parseInt("" + table.getValueAt(5, 1));
	}
	
	public int get50() {
		return Integer.parseInt("" + table.getValueAt(6, 1));
	}
	
	public int get10() {
		return Integer.parseInt("" + table.getValueAt(7, 1));
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		
		int row = e.getFirstRow();
        int column = e.getColumn();
		String str;

		if (column == 1) { // "수량" 컬럼
			TableModel model = (TableModel) e.getSource();
			String colName = model.getColumnName(column);
			int amount = (int) model.getValueAt(row, column);

			if (amount < 0) { // 입력한 수량 값이 0 미만인 경우 경고창을 띄운다.
				JOptionPane.showMessageDialog(this, "수량을 0 이상으로 설정해주세요.", "경고", JOptionPane.WARNING_MESSAGE);
				model.setValueAt(0, row, column);
				amount = 0;
			}
			
			switch (row) {
			case 0:
				model.setValueAt(50000 * amount, row, column + 1);
				break;
			case 1:
				model.setValueAt(10000 * amount, row, column + 1);
				break;
			case 2:
				model.setValueAt(5000 * amount, row, column + 1);
				break;
			case 3:
				model.setValueAt(1000 * amount, row, column + 1);
				break;
			case 4:
				model.setValueAt(500 * amount, row, column + 1);
				break;
			case 5:
				model.setValueAt(100 * amount, row, column + 1);
				break;
			case 6:
				model.setValueAt(50 * amount, row, column + 1);
				break;
			case 7:
				model.setValueAt(10 * amount, row, column + 1);
				break;
			}
		}
	}
}