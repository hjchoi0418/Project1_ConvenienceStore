package AnyPlace.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Cash_Management_view extends JFrame {

	public Cash_Management_view() {
		setTitle("��������");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setBounds(400, 100, 400, 220);

		// ǥ ������
		String[] colNames = new String[] { "����", "����", "�ݾ�" };
		// ǥ�� �� �����͵� / ó���� �� ���̺� ����� ���� �����Ͱ�����ü ����
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);

		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout());

		JButton btnPrint = new JButton("����");

		bottomPanel.add(btnPrint);

		String[] rows = new String[3];

		rows[0] = "50,000��";
		rows[1] = "0";
		rows[2] = "0";
		model.addRow(rows);
		rows[0] = "10,000��";
		model.addRow(rows);
		rows[0] = "5,000��";
		model.addRow(rows);
		rows[0] = "1,000��";
		model.addRow(rows);
		rows[0] = "500��";
		model.addRow(rows);
		rows[0] = "100��";
		model.addRow(rows);
		rows[0] = "50��";
		model.addRow(rows);
		rows[0] = "10��";
		model.addRow(rows);

		add(bottomPanel, BorderLayout.SOUTH);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Cash_Management_view();
	}
}
