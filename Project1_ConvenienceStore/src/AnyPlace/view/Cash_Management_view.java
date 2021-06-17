package AnyPlace.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import AnyPlace.controller.Cash_Management;

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
    private JScrollPane l_scrollPane;
    private JTable table;
	JPanel topPanel, centerPanel, bottomPanel;
	JLabel label;
	JButton btnPrint;
	private JScrollPane r_scrollPane;
	
	public Cash_Management_view() {
		setBorder(new EmptyBorder(20, 50, 20, 50));
		setBackground(Color.WHITE);
		
		table = new JTable(new DefaultTableModel(
			new Object[][] {
				{"50,000\uC6D0", new Integer(0), new Integer(0)},
				{"10,000\uC6D0", new Integer(0), new Integer(0)},
				{"5,000\uC6D0", new Integer(0), new Integer(0)},
				{"1,000\uC6D0", new Integer(0), new Integer(0)},
				{"500\uC6D0", new Integer(0), new Integer(0)},
				{"100\uC6D0", new Integer(0), new Integer(0)},
				{"50\uC6D0", new Integer(0), new Integer(0)},
				{"10\uC6D0", new Integer(0), new Integer(0)},
			},
			new String[] {
				"\uAD8C\uC885", "\uC218\uB7C9", "\uAE08\uC561"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, true, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		table.getTableHeader().setFont(new Font("나눔고딕", Font.BOLD, 20));
		table.getTableHeader().setBackground(new Color(22,56,81));
		table.getTableHeader().setForeground(new Color(255,255,255));
		table.getTableHeader().setPreferredSize(new Dimension(0, 60));
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowSelectionAllowed(true);
		table.getTableHeader().setReorderingAllowed(false);

		table.setIntercellSpacing(new Dimension(10, 1));
		table.setRowHeight(62);
		table.setFont(new Font("나눔고딕", Font.BOLD, 18));
		table.setBackground(new Color(235,235,235));
 		table.setForeground(new Color(22,56,81));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		l_scrollPane = new JScrollPane(table);
		l_scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		l_scrollPane.setBackground(Color.WHITE);
		topPanel = new JPanel();
		topPanel.setBackground(Color.WHITE);
		topPanel.setBorder(new EmptyBorder(0, 10, 15, 10));
		centerPanel = new JPanel();
		centerPanel.setBackground(Color.WHITE);
		bottomPanel = new JPanel();
		bottomPanel.setBorder(new EmptyBorder(5, 0, 5, 0));
		bottomPanel.setBackground(Color.WHITE);
		label = new JLabel("POS 현금");
		label.setForeground(new Color(22, 56, 81));
		label.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		btnPrint = new JButton("발행", null);
		btnPrint.setPreferredSize(new Dimension(57, 40));
		setLayout(new BorderLayout(0, 0));

		table.getModel().addTableModelListener(this);

		btnPrint.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String str = String.format("[시재점검표]\n"
						+ "50,000 / %d개 / %d\n"
						+ "10,000 / %d개 / %d\n"
						+ "5,000 / %d개 / %d\n"
						+ "1,000 / %d개 / %d\n"
						+ "500 / %d개 / %d\n"
						+ "100 / %d개 / %d\n"
						+ "50 / %d개 / %d\n"
						+ "10 / %d개 / %d\n"
						+ "-------------------\n"
						+ "점검계\t\t : %d\n"
						+ "POS기 현금\t\t : %d\n"
						+ "\n"
						+ "차이\t\t : %d"
						, get50000(), get50000() * 50000
						, get10000(), get10000() * 10000
						, get5000(), get5000() * 5000
						, get1000(), get1000() * 1000
						, get500(), get500() * 500
						, get100(), get100() * 100
						, get50(), get50() * 50
						, get10(), get10() * 10
						, Cash_Management.getDbCash()
						, getPosCash()
						, getPosCash() - Cash_Management.getDbCash());
				JOptionPane.showMessageDialog(null, str);
			}
		});
		topPanel.setLayout(new BorderLayout(0, 0));

		topPanel.add(label);

		centerPanel.setLayout(new GridLayout(0, 2, 20, 0));
		centerPanel.add(l_scrollPane);

		bottomPanel.setLayout(new GridLayout(0, 3, 0, 0));
		JPanel empty_panel = new JPanel();
		empty_panel.setBackground(Color.WHITE);
		bottomPanel.add(empty_panel);
		bottomPanel.add(btnPrint);
		
		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		
		JPanel logo_panel = new JPanel();
		logo_panel.setBackground(new Color(235, 235, 235));
		logo_panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("./img/logo.jpg"));
		
		logo_panel.add(logo);
		centerPanel.add(logo_panel);
		
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
	
	public int getPosCash() {
		return Integer.parseInt("" + table.getValueAt(0, 2)) +
				Integer.parseInt("" + table.getValueAt(1, 2)) +
				Integer.parseInt("" + table.getValueAt(2, 2)) +
				Integer.parseInt("" + table.getValueAt(3, 2)) +
				Integer.parseInt("" + table.getValueAt(4, 2)) +
				Integer.parseInt("" + table.getValueAt(5, 2)) +
				Integer.parseInt("" + table.getValueAt(6, 2)) +
				Integer.parseInt("" + table.getValueAt(7, 2));
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