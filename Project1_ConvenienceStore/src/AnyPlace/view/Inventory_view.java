package AnyPlace.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import AnyPlace.controller.BuyProduct.Lookup_method;
import javax.swing.border.LineBorder;

public class Inventory_view extends JPanel{
	
	ImageIcon icon;
	JButton 장바구니추가, 장바구니초기화, 카드결제, 현금결제;
	JTable stock_table, category_table;
	JScrollPane scroll, c_scroll;
	DefaultTableModel serch_model;
	JPanel buy_table_panel;
	
	private String[][] data, category_data;
	private String[] columnType = {"상품번호", "분류", "상품 이름", "상품 가격", "재고"};
	private String[] category = {"카테고리별 검색"};
 
	
	public Inventory_view() {
		
		setBorder(new EmptyBorder(20, 50, 20, 50));
		setBackground(Color.white);
		setLayout(null);
		
		
		JPanel category_table_panel = new JPanel();
		category_table_panel.setBackground(Color.white);
		category_table_panel.setBounds(10, 20, 170, 550);
		add(category_table_panel);
		
		category_data = Lookup_method.getcategory_name();
		DefaultTableModel category_model = new DefaultTableModel(category_data, category) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
		};
		category_table = new JTable(category_model);
		c_scroll = new JScrollPane(category_table);
		category_table_panel.add(c_scroll);
		c_scroll.setPreferredSize(new Dimension(168, 500));

		category_table.getTableHeader().setFont(new Font("나눔고딕", Font.BOLD, 20));
		category_table.getTableHeader().setBackground(new Color(22,56,81));
		category_table.getTableHeader().setForeground(new Color(255,255,255));
		category_table.getTableHeader().setPreferredSize(new Dimension(0, 60));
		category_table.getTableHeader().setReorderingAllowed(false);
		category_table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		category_table.setRowSelectionAllowed(true);
		category_table.getTableHeader().setReorderingAllowed(false);
		
		category_table.setRowHeight(40);
		category_table.setFont(new Font("나눔고딕", Font.BOLD, 15));
		category_table.setBackground(new Color(198,198,198));
		category_table.setForeground(new Color(22,56,81));
		category_table.setRowSelectionAllowed(true);
		category_table.addMouseListener(new MyMouseListener());
		
		// 가운데 정렬
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule = category_table.getColumnModel();
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}
		
		buy_table_panel = new JPanel();
		buy_table_panel.setBackground(Color.white);
		buy_table_panel.setBounds(200, 20, 810, 550);
		add(buy_table_panel);
		
		data = Lookup_method.getproduct();
		serch_model = new DefaultTableModel(data, columnType) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
		};

		stock_table = new JTable(serch_model);
		scroll = new JScrollPane(stock_table);
		buy_table_panel.add(scroll);
		scroll.setPreferredSize(new Dimension(800, 500));
		
		stock_table.getTableHeader().setFont(new Font("나눔고딕", Font.BOLD, 20));
		stock_table.getTableHeader().setBackground(new Color(22,56,81));
		stock_table.getTableHeader().setForeground(new Color(255,255,255));
		stock_table.getTableHeader().setPreferredSize(new Dimension(0, 60));
		stock_table.getTableHeader().setReorderingAllowed(false);
		stock_table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		stock_table.setRowSelectionAllowed(true);
		stock_table.getTableHeader().setReorderingAllowed(false);
		
		stock_table.setRowHeight(40);
		stock_table.setFont(new Font("나눔고딕", Font.BOLD, 15));
		stock_table.setBackground(new Color(198,198,198));
		stock_table.setForeground(new Color(22,56,81));
		stock_table.setRowSelectionAllowed(true);
		 

		// 가운데 정렬
		DefaultTableCellRenderer tScheduleCellRenderer1 = new DefaultTableCellRenderer();
		tScheduleCellRenderer1.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule1 = stock_table.getColumnModel();
		for (int i = 0; i < tcmSchedule1.getColumnCount(); i++) {
			tcmSchedule1.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}
		// 컬럼 사이 간격 조정
		TableColumnModel columnModels = stock_table.getColumnModel();
		columnModels.getColumn(0).setPreferredWidth(40);
		columnModels.getColumn(1).setPreferredWidth(40);
		columnModels.getColumn(2).setPreferredWidth(170);
		columnModels.getColumn(3).setPreferredWidth(60);
		columnModels.getColumn(4).setPreferredWidth(1);
		
		JLabel search_label = new JLabel(new ImageIcon("./img/menu_D/제품검색.PNG"));
		search_label.setBounds(200, 550, 600, 150);
		add(search_label);
		
//		JComboBox cBox = new JComboBox();
//		cBox.setModel(new DefaultComboBoxModel(new String[] {"상품번호", "분류", "상품 이름", "상품 가격", "재고"}));
//		cBox.setSize(80, 30);
//		cBox.setLocation(300, 610);
//		cBox.setFont(new Font("나눔고딕", Font.BOLD, 12));
//		add(cBox);
		
		JTextField search = new JTextField();
		search.setBorder(new LineBorder(new Color(22, 56, 81), 5, true));
		search.setFont(new Font("나눔고딕", Font.BOLD, 20));
		search.setBounds(500, 600, 200, 50);
		add(search);
		search.setBackground(SystemColor.WHITE);
		search.setColumns(10);
		search.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String val = search.getText();
				
				TableRowSorter<TableModel> trs = new TableRowSorter<>(stock_table.getModel());
				stock_table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});
	}
	private class MyMouseListener extends MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			serch_model = (DefaultTableModel)stock_table.getModel();
			serch_model.setNumRows(0);
			
			int row = category_table.getSelectedRow();
			int column = category_table.getSelectedColumn();
			ArrayList<String> category_list = Lookup_method.getcategory((String) category_table.getValueAt(row, column));
			int count = 0;
			for(int i = 0; i < category_list.size() / 5; ++i) {
				Vector<String>category = new Vector<String>();
				category.addElement(category_list.get(count));
				category.addElement(category_list.get(count + 1));
				category.addElement(category_list.get(count + 2));
				category.addElement(category_list.get(count + 3));
				category.addElement(category_list.get(count + 4));
				serch_model.addRow(category);
				count = count + 5;
			}
		}
	}	
}