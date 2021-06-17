package AnyPlace.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import AnyPlace.controller.BuyProduct.Buy_method;
import AnyPlace.controller.BuyProduct.Complete;
import AnyPlace.controller.BuyProduct.Lookup_method;
import AnyPlace.controller.BuyProduct.Order_receipt;
import AnyPlace.mouseEventListener.DisposalView_MouseEventListener;

public class Sell_product_view extends JPanel {
	
	String frame;
	ImageIcon icon;
	JButton ��ٱ����߰�, ��ٱ����ʱ�ȭ, ī�����, ���ݰ���;
	JTable stock_table, buy_table;
	JScrollPane scroll; // ���̺� ���� �� ���� �־�����~ scroll
	
	private String[][] data;
	private String[] columnType = {"��ǰ��ȣ", "�з�", "��ǰ �̸�", "��ǰ ����", "���"};

	public Sell_product_view() {
		setBorder(new EmptyBorder(20, 50, 20, 50));
		setBackground(Color.white);
		
		
		JPanel buy_table_panel = new JPanel();
		buy_table_panel.setBackground(Color.white);
		buy_table_panel.setBounds(380, 220, 590, 360);
		add(buy_table_panel);
		
		data = Lookup_method.getproduct();
		DefaultTableModel model = new DefaultTableModel(data, columnType);
		stock_table = new JTable(model);
		scroll = new JScrollPane(stock_table);
		buy_table_panel.add(scroll);
		scroll.setPreferredSize(new Dimension(500, 350));
		stock_table.setFont(new Font("���� ���", Font.BOLD, 16));
		stock_table.setBackground(new Color(255, 255, 255));
		stock_table.setForeground(new Color(0, 0, 0));
		stock_table.setRowHeight(40);

		// ��� ����
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule = stock_table.getColumnModel();
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}
		// �÷� ���� ���� ����
		TableColumnModel columnModels = stock_table.getColumnModel();
		columnModels.getColumn(0).setPreferredWidth(40);
		columnModels.getColumn(1).setPreferredWidth(40);
		columnModels.getColumn(2).setPreferredWidth(170);
		columnModels.getColumn(3).setPreferredWidth(60);
		columnModels.getColumn(4).setPreferredWidth(1);
		
		JPanel order_table_panel = new JPanel();
		order_table_panel.setBackground(Color.white);
		order_table_panel.setBounds(1000, 220, 350, 360);
		add(order_table_panel);
		
		Vector<String> order_headers = new Vector<String>();
		order_headers.add("��ǰ �̸�");
		order_headers.add("�� ����");
		order_headers.add("����");
		
		//���� ���̺�
		DefaultTableModel order_model = new DefaultTableModel(order_headers, 0);
		JTable order_table = new JTable(order_model);
		JScrollPane order_scrollpane = new JScrollPane(order_table);
		order_scrollpane.setPreferredSize(new Dimension(300, 350));
		order_table.setFont(new Font("���� ���", Font.BOLD, 16));
		order_table.setBackground(new Color(255, 255, 255));
		order_table.setForeground(new Color(0, 0, 0));
		order_table.setRowHeight(40);
		order_table_panel.add(order_scrollpane);
		
		// ��� ��Ʈ
		JTableHeader order_header = order_table.getTableHeader();
		order_table.setBackground(Color.white);
		order_table.setForeground(Color.black);
		order_table.setFont(new Font("���� ���", Font.BOLD, 15));
		
		// ��� ����
		DefaultTableCellRenderer tScheduleCellRenderer2 = new DefaultTableCellRenderer();
		tScheduleCellRenderer2.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule2 = order_table.getColumnModel();
		for (int i = 0; i < tcmSchedule2.getColumnCount(); i++) {
			tcmSchedule2.getColumn(i).setCellRenderer(tScheduleCellRenderer2);
		}
		
		// �÷� ���� ���� ����
		TableColumnModel orderModels = order_table.getColumnModel();
		orderModels.getColumn(0).setPreferredWidth(80);
		orderModels.getColumn(1).setPreferredWidth(30);
		orderModels.getColumn(2).setPreferredWidth(20);
		order_table_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		// ��ǰ ��ȣ �Է�â
		JTextField order = new JTextField();
		order.setFont(new Font("���� ���", Font.BOLD, 20));
		order.setBounds(605, 600, 100, 40);
		add(order);
		order.setBackground(SystemColor.WHITE);
		order.setColumns(10);
		
		// ���� �Է�â
		JTextField count = new JTextField();
		count.setFont(new Font("���� ���", Font.BOLD, 20));
		count.setBounds(840, 600, 100, 40);
		add(count);
		count.setBackground(SystemColor.WHITE);
		count.setColumns(10);
		// ��������
		ArrayList<Order_receipt> order_receipt = new ArrayList<Order_receipt>();
		// ��ٱ��� �߰�
		JButton btnadd = new JButton("�߰�");
		btnadd.setIcon(new ImageIcon("./image/��ٱ����߰�.PNG"));
		btnadd.setBounds(380, 650, 185, 128);
		btnadd.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		add(btnadd);
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> a = Buy_method.getorder(order.getText(), count.getText());
				if(Integer.parseInt(count.getText()) > Buy_method.search(a.get(0))) {
					order.setText("");
					count.setText("");
				}else {
					Order_receipt order_receipts = new Order_receipt();
					order_receipts.setProduct_name(a.get(0));
					order_receipts.setOrder_count(Integer.parseInt(a.get(2)));
					order_receipt.add(order_receipts);
					Vector<String> row = new Vector<String>();
					row.addElement(a.get(0));
					row.addElement(a.get(1));
					row.addElement(a.get(2));
					order_model.addRow(row);
					
					order.setText("");
					count.setText("");
				}
			}		
		});
		// �ʱ�ȭ
		JButton btnclear = new JButton("�ʱ�ȭ");
		btnclear.setIcon(new ImageIcon("./image/��ٱ����ʱ�ȭ.PNG"));
		btnclear.setBounds(780, 650, 185, 128);
		btnclear.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		add(btnclear);
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)order_table.getModel();
				model.setNumRows(0);
				order_receipt.clear();
			}
		});
		
		// ���� ��ư
		JButton btnbuy = new JButton("����");
		btnbuy.setIcon(new ImageIcon("./image/ī�����.PNG"));
		btnbuy.setBounds(1070, 580, 220, 80);
		btnbuy.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		add(btnbuy);
		btnbuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buy_method.Temporary_order();
				for(int i = 0; i < order_receipt.size(); ++i) {
					for(int j = 0; j < order_receipt.get(i).getOrder_count(); ++j) {
						Buy_method.detail_order(order_receipt.get(i).getProduct_name());
						
					}
				}
				Buy_method.update_order();
				DefaultTableModel model = (DefaultTableModel)order_table.getModel();
				model.setNumRows(0);
				order_receipt.clear();
			}
		});
		
//		table = new JTable(model);
//		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // ���ϼ���
//		table.setRowSelectionAllowed(true);	// �� ���õǴ� ���� .. 
//		table.getTableHeader().setReorderingAllowed(false);
//		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
//		table.addMouseListener(new DisposalView_MouseEventListener(table));
////		table.setForeground(new Color(75, 0, 130));
////		table.setBackground(new Color(192, 192, 192));
////		table.setFont(new Font("���� ���", Font.BOLD, 12));
////		table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
//
//		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//		scroll = new JScrollPane(table);
//		add(scroll);
		
	}
}
