package AnyPlace.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import AnyPlace.controller.Cash_Management;

public class Cash_Management_view extends JPanel implements TableModelListener {

	// ǥ�� �� �����͵� / ó���� �� ���̺� ����� ���� �����Ͱ�����ü ����
	private Object[][] data = {
            {"50,000��", 0, 0},
            {"10,000��", 0, 0},
            {"5,000��", 0, 0},
            {"1,000��", 0, 0},
            {"500��", 0, 0},
            {"100��", 0, 0},
            {"50��", 0, 0},
            {"10��", 0, 0},
    };
    private String[] columnType = { "����", "����", "�ݾ�" };
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
    private JTable l_table;
	JPanel topPanel, centerPanel, bottomPanel;
	JLabel label;
	JButton btnPrint;
	private JScrollPane r_scrollPane;
	private JTable r_table;
	
	public Cash_Management_view() {
		setBorder(new EmptyBorder(20, 50, 20, 50));
		setBackground(Color.WHITE);
		
		l_table = new JTable(new DefaultTableModel(
			new Object[][] {
				{"50,000\uC6D0", new Integer(0), new Integer(0)},
				{"10,000\uC6D0", new Integer(0), new Integer(0)},
				{"5,000\uC6D0", new Integer(0), new Integer(0)},
				{"1,000\uC6D0", new Integer(0), new Integer(0)},
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
		l_table.setIntercellSpacing(new Dimension(10, 1));
		l_table.setFont(new Font("���� ����", Font.PLAIN, 20));
		l_table.setRowHeight(134);
		l_table.getTableHeader().setReorderingAllowed(false);
		l_scrollPane = new JScrollPane(l_table);
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
		label = new JLabel("POS ����");
		label.setForeground(new Color(22, 56, 81));
		label.setFont(new Font("���� ����", Font.BOLD, 28));
		btnPrint = new JButton("����", null);
		btnPrint.setPreferredSize(new Dimension(57, 40));
		setLayout(new BorderLayout(0, 0));

		l_table.getModel().addTableModelListener(this);

		btnPrint.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String str = String.format("[��������ǥ]\n"
						+ "50,000\t %d��\t %d\n"
						+ "10,000\t %d��\t %d\n"
						+ "5,000\t %d�� \t %d\n"
						+ "1,000\t %d�� \t %d\n"
						+ "500\t %d�� \t %d\n"
						+ "100\t %d�� \t %d\n"
						+ "50\t %d�� \t %d\n"
						+ "10\t %d�� \t %d\n"
						+ "-------------------\n"
						+ "���˰�\t\t : %d\n"
						+ "POS�� ����\t\t : %d\n"
						+ "\n"
						+ "����\t\t : %d"
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

		centerPanel.setLayout(new GridLayout(0, 2, 0, 0));
		centerPanel.add(l_scrollPane);

		bottomPanel.setLayout(new GridLayout(0, 3, 0, 0));
		JPanel empty_panel = new JPanel();
		empty_panel.setBackground(Color.WHITE);
		bottomPanel.add(empty_panel);
		bottomPanel.add(btnPrint);
		
		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		
		r_scrollPane = new JScrollPane((Component) null);
		r_scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		r_scrollPane.setBackground(Color.WHITE);
		centerPanel.add(r_scrollPane);
		
		r_table = new JTable(new DefaultTableModel(
			new Object[][] {
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
		r_table.setIntercellSpacing(new Dimension(10, 1));
		r_scrollPane.setViewportView(r_table);
		r_table.setRowHeight(134);
		r_table.setFont(new Font("���� ����", Font.PLAIN, 20));
		add(bottomPanel, BorderLayout.SOUTH);
		setVisible(true);
	}

	public int get50000() {
		return Integer.parseInt("" + l_table.getValueAt(0, 1));
	}
	
	public int get10000() {
		return Integer.parseInt("" + l_table.getValueAt(1, 1));
	}
	
	public int get5000() {
		return Integer.parseInt("" + l_table.getValueAt(2, 1));
	}
	
	public int get1000() {
		return Integer.parseInt("" + l_table.getValueAt(3, 1));
	}
	
	public int get500() {
		return Integer.parseInt("" + r_table.getValueAt(0, 1));
	}
	
	public int get100() {
		return Integer.parseInt("" + r_table.getValueAt(1, 1));
	}
	
	public int get50() {
		return Integer.parseInt("" + r_table.getValueAt(2, 1));
	}
	
	public int get10() {
		return Integer.parseInt("" + r_table.getValueAt(3, 1));
	}
	
	public int getPosCash() {
		return Integer.parseInt("" + l_table.getValueAt(0, 2)) +
				Integer.parseInt("" + l_table.getValueAt(1, 2)) +
				Integer.parseInt("" + l_table.getValueAt(2, 2)) +
				Integer.parseInt("" + l_table.getValueAt(3, 2)) +
				Integer.parseInt("" + r_table.getValueAt(0, 2)) +
				Integer.parseInt("" + r_table.getValueAt(1, 2)) +
				Integer.parseInt("" + r_table.getValueAt(2, 2)) +
				Integer.parseInt("" + r_table.getValueAt(3, 2));
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		
		int row = e.getFirstRow();
        int column = e.getColumn();
		String str;

		if (column == 1) { // "����" �÷�
			TableModel model = (TableModel) e.getSource();
			String colName = model.getColumnName(column);
			int amount = (int) model.getValueAt(row, column);

			if (amount < 0) { // �Է��� ���� ���� 0 �̸��� ��� ���â�� ����.
				JOptionPane.showMessageDialog(this, "������ 0 �̻����� �������ּ���.", "���", JOptionPane.WARNING_MESSAGE);
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