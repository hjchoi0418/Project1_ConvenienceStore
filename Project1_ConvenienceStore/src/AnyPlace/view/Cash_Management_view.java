package AnyPlace.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import AnyPlace.controller.Cash_Management;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class Cash_Management_view extends JPanel implements TableModelListener {

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
	JPanel topPanel, centerPanel, bottomPanel;
	JLabel label;
	JButton btnPrint;
	private JPanel panel;
	private JLabel lblNewLabel;
	
	public Cash_Management_view() {
		setBackground(Color.WHITE);
		
		table = new JTable(model);
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		table.setRowHeight(72);
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane = new JScrollPane(table);
		scrollPane.setBackground(Color.WHITE);
		topPanel = new JPanel();
		topPanel.setBackground(Color.WHITE);
		topPanel.setBorder(new EmptyBorder(0, 10, 20, 10));
		centerPanel = new JPanel();
		centerPanel.setBackground(Color.WHITE);
		bottomPanel = new JPanel();
		bottomPanel.setBorder(new EmptyBorder(5, 0, 5, 0));
		bottomPanel.setBackground(Color.WHITE);
		label = new JLabel("POS 현금");
		label.setForeground(new Color(22, 56, 81));
		label.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		btnPrint = new JButton("발행");
		btnPrint.setPreferredSize(new Dimension(57, 40));
		setLayout(new BorderLayout(0, 0));

		table.getModel().addTableModelListener(this);

		btnPrint.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String str = String.format("[시재점검표]\n"
						+ "50,000\t %d개\t %d\n", get50000(), get50000() * 50000
						+ "10,000\t %d개\t %d\n", get10000(), get10000() * 10000
						+ "5,000\t %d개 \t %d\n", get5000(), get5000() * 5000
						+ "1,000\t %d개 \t %d\n", get1000(), get1000() * 1000
						+ "500\t %d개 \t %d\n", get500(), get500() * 500
						+ "100\t %d개 \t %d\n", get100(), get100() * 100
						+ "50\t %d개 \t %d\n", get50(), get50() * 50
						+ "10\t %d개 \t %d\n", get10(), get10() * 10
						+ "-------------------"
						+ "점검계\t\t : %d", Cash_Management.getDbCash()
						+ "POS기 현금\t\t : %d", Cash_Management.getPosCash()
						+ "\n"
						+ "차이\t\t : %d", Cash_Management.getPosCash() - Cash_Management.getDbCash()
						);
				JOptionPane.showMessageDialog(null, str);
			}
		});
		topPanel.setLayout(new BorderLayout(0, 0));

		topPanel.add(label);

		centerPanel.setLayout(new GridLayout(0, 2, 0, 0));
		centerPanel.add(scrollPane);

		bottomPanel.setLayout(new GridLayout(0, 3, 0, 0));
		JPanel empty_panel = new JPanel();
		empty_panel.setBackground(Color.WHITE);
		bottomPanel.add(empty_panel);
		bottomPanel.add(btnPrint);
		
		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		
		panel = new JPanel();
		centerPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("\uC5EC\uBC31\uC758 \uBBF8");
		lblNewLabel.setFont(new Font("궁서체", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
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