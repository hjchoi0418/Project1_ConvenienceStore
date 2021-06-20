package AnyPlace.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import AnyPlace.controller.BuyProduct.Buy_method;
import AnyPlace.controller.BuyProduct.Lookup_method;
import AnyPlace.controller.BuyProduct.Order_receipt;

public class Sell_product_view extends JPanel {
	
	ImageIcon icon;
	JButton 장바구니추가, 장바구니초기화, 카드결제, 현금결제;
	JTable stock_table, order_table;
	JScrollPane scroll;
	DefaultTableModel dtm, order_model;
	JTextField sumTextField;
	int sum = 0;
	int sum_count = 0;
	boolean already_exist;
	
	ArrayList<String> product_name;
	ArrayList<Order_receipt> order_receipt;
	private String[][] data;
	private String[] columnType = {"상품번호", "카테고리", "상품 이름", "상품 가격", "재고"};
	
	public Sell_product_view() {
		
		setBorder(new EmptyBorder(20, 50, 20, 50));
		setBackground(Color.white);
		setLayout(null);
		
		JPanel buy_table_panel = new JPanel();
		buy_table_panel.setBackground(Color.white);
		buy_table_panel.setBounds(20, 20, 600, 580);
		add(buy_table_panel);
		
		data = Lookup_method.getproduct();
		dtm = new DefaultTableModel(data, columnType) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
		};
		
		stock_table = new JTable(dtm);
		scroll = new JScrollPane(stock_table);
		buy_table_panel.add(scroll);
		scroll.setPreferredSize(new Dimension(590, 570));
		
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
		stock_table.addMouseListener(new MyMouseListener1());

		// 가운데 정렬
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule = stock_table.getColumnModel();
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}
		// 컬럼 사이 간격 조정
		TableColumnModel columnModels = stock_table.getColumnModel();
		columnModels.getColumn(0).setPreferredWidth(40);
		columnModels.getColumn(1).setPreferredWidth(60);
		columnModels.getColumn(2).setPreferredWidth(160);
		columnModels.getColumn(3).setPreferredWidth(60);
		columnModels.getColumn(4).setPreferredWidth(1);
		
		JPanel order_table_panel = new JPanel();
		order_table_panel.setBackground(Color.white);
		order_table_panel.setBounds(630, 20, 400, 500);
		add(order_table_panel);
		
		Vector<String> order_headers = new Vector<String>();
		order_headers.add("상품 이름");
		order_headers.add("총 가격");
		order_headers.add("수량");
		
		//오더 테이블
		order_model = new DefaultTableModel(order_headers, 0) {
			boolean[] columnEditables = new boolean[] {
					false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
		};
		order_table = new JTable(order_model);
		JScrollPane order_scrollpane = new JScrollPane(order_table);
		order_scrollpane.setPreferredSize(new Dimension(380, 490));

		// 헤더 폰트
		order_table.getTableHeader().setFont(new Font("나눔고딕", Font.BOLD, 20));
		order_table.getTableHeader().setBackground(new Color(22,56,81));
		order_table.getTableHeader().setForeground(new Color(255,255,255));
		order_table.getTableHeader().setPreferredSize(new Dimension(0, 60));
		order_table.getTableHeader().setReorderingAllowed(false);
		order_table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		order_table.setRowSelectionAllowed(true);
		order_table.getTableHeader().setReorderingAllowed(false);
		
		order_table.setRowHeight(40);
		order_table.setFont(new Font("나눔고딕", Font.BOLD, 15));
		order_table.setBackground(new Color(198,198,198));
		order_table.setForeground(new Color(22,56,81));
		order_table.setRowSelectionAllowed(true);
		order_table_panel.add(order_scrollpane);
		order_table.addMouseListener(new MyMouseListener2());
		
		// 가운데 정렬
		DefaultTableCellRenderer tScheduleCellRenderer2 = new DefaultTableCellRenderer();
		tScheduleCellRenderer2.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule2 = order_table.getColumnModel();
		for (int i = 0; i < tcmSchedule2.getColumnCount(); i++) {
			tcmSchedule2.getColumn(i).setCellRenderer(tScheduleCellRenderer2);
		}
		
		// 컬럼 사이 간격 조정
		TableColumnModel orderModels = order_table.getColumnModel();
		orderModels.getColumn(0).setPreferredWidth(80);
		orderModels.getColumn(1).setPreferredWidth(30);
		orderModels.getColumn(2).setPreferredWidth(20);
		order_table_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		// 제품 번호 입력창
		JTextField order = new JTextField();
		add(order);
		
		// 수량 입력창
		JTextField count = new JTextField();
		add(count);
		
		JLabel sum_label = new JLabel(new ImageIcon("./img/menu_D/결제금액.PNG"));
		sum_label.setBounds(575, 530, 300, 150);
		add(sum_label);
		
		// 장바구니 금액 합계
		sumTextField = new JTextField();
		sumTextField.setBounds(680, 620, 100, 40);
		sumTextField.setBackground(SystemColor.WHITE);
		sumTextField.setFont(new Font("나눔고딕", Font.BOLD, 20));
		add(sumTextField);
			
		// 결제정보
		product_name = new ArrayList<String>();
		product_name.add("fake_product");
		order_receipt = new ArrayList<Order_receipt>();

		// 초기화
		JButton btnclear = new JButton("장바구니 초기화");
		btnclear.setIcon(new ImageIcon("./img/menu_D/장바구니초기화.PNG"));
		btnclear.setBounds(200, 600, 235, 70);
		btnclear.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		add(btnclear);
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)order_table.getModel();
				model.setNumRows(0);
				order_receipt.clear();
				product_name.clear();
				product_name.add("fake_product");
				sum = 0;
				sum_count = 0;
				sumTextField.setText("");
			}
		});
			
		// 카드 결제 버튼
		JButton btnbuycard = new JButton("카드 결제");
		btnbuycard.setIcon(new ImageIcon("./img/menu_D/카드결제.PNG"));
		btnbuycard.setBounds(870, 530, 162, 70);
		btnbuycard.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		add(btnbuycard);
		btnbuycard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buy_method.Temporary_order_card();
				for(int i = 0; i < order_receipt.size(); ++i) {
					for(int j = 0; j < order_receipt.get(i).getOrder_count(); ++j) {
						Buy_method.detail_order(order_receipt.get(i).getProduct_name());
						
					}
				}
				Buy_method.update_order();
				DefaultTableModel model = (DefaultTableModel)order_table.getModel();
				model.setNumRows(0);
				order_receipt.clear();
				product_name.clear();
				product_name.add("fake_product");
				
				dtm = (DefaultTableModel)stock_table.getModel();
				dtm.setNumRows(0);
				
				ArrayList<String> product_list = Lookup_method.getproduct_list();
				int count = 0;
				for(int i = 0; i < product_list.size() / 5; ++i) {
					Vector<String>products = new Vector<String>();
					products.addElement(product_list.get(count));
					products.addElement(product_list.get(count + 1));
					products.addElement(product_list.get(count + 2));
					products.addElement(product_list.get(count + 3));
					products.addElement(product_list.get(count + 4));
					dtm.addRow(products);
					count = count + 5;
				}
				
				JOptionPane.showMessageDialog(null, 
						"결제금액 : " + sum + "\n카드 결제 완료!", "Message", JOptionPane.INFORMATION_MESSAGE);
				sum = 0;
				sum_count = 0;
				sumTextField.setText("");
				
			}
		});
		// 현금 결제 btn
		JButton btnbuycash = new JButton("현금 결제");
		btnbuycash.setIcon(new ImageIcon("./img/menu_D/현금 결제.PNG"));
		btnbuycash.setBounds(870, 608, 160, 70);
		btnbuycash.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		add(btnbuycash);
		btnbuycash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buy_method.Temporary_order_cash();
				for(int i = 0; i < order_receipt.size(); ++i) {
					for(int j = 0; j < order_receipt.get(i).getOrder_count(); ++j) {
						Buy_method.detail_order(order_receipt.get(i).getProduct_name());
					}
				}
				Buy_method.update_order();
				Buy_method.Update_cash();
				DefaultTableModel model = (DefaultTableModel)order_table.getModel();
				model.setNumRows(0);
				order_receipt.clear();
				product_name.clear();
				product_name.add("fake_product");
				
				dtm = (DefaultTableModel)stock_table.getModel();
				dtm.setNumRows(0);
				
				ArrayList<String> product_list = Lookup_method.getproduct_list();
				int count = 0;
				for(int i = 0; i < product_list.size() / 5; ++i) {
					Vector<String>products = new Vector<String>();
					products.addElement(product_list.get(count));
					products.addElement(product_list.get(count + 1));
					products.addElement(product_list.get(count + 2));
					products.addElement(product_list.get(count + 3));
					products.addElement(product_list.get(count + 4));
					dtm.addRow(products);
					count = count + 5;
				}
				JOptionPane.showMessageDialog(null, 
						"결제금액 : " + sum + "\n현금 결제 완료!", "Message", JOptionPane.INFORMATION_MESSAGE);
				sum = 0;
				sum_count = 0;
				sumTextField.setText("");
			}
		});	
	}

	private class MyMouseListener1 extends MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			int row = stock_table.getSelectedRow();
			int column = stock_table.getSelectedColumn();
			
			for(int i = 0; i < product_name.size(); ++i) {
				if((String)stock_table.getValueAt(row, 2) == product_name.get(i)) {
					already_exist = true;
				}
			}
			if(already_exist) {
				JOptionPane.showMessageDialog(null, 
						"이미 장바구니에 있는 물건입니다", "Message", JOptionPane.ERROR_MESSAGE);
				already_exist = false;
			}				
			else if(Integer.parseInt((String)stock_table.getValueAt(row, 4)) == 0) {
				JOptionPane.showMessageDialog(null, 
						"현재 "+ (String)stock_table.getValueAt(row, 2) + "상품의 재고가 없습니다", 
						"Message", JOptionPane.ERROR_MESSAGE);
			}else {
				String count_product = JOptionPane.showInputDialog("구매하실 수량을 입력하세요.");
				ArrayList<String> receipt = Buy_method.getorder((String) stock_table.getValueAt(row, 0), count_product);				
				if(Integer.parseInt(count_product) > Buy_method.search(receipt.get(0))) {
					JOptionPane.showMessageDialog(null, 
							"주문수량이 재고보다 많습니다", "Message", JOptionPane.ERROR_MESSAGE);
				}else {
					Order_receipt order_receipts = new Order_receipt();
					order_receipts.setProduct_name(receipt.get(0));
					order_receipts.setOrder_count(Integer.parseInt(receipt.get(2)));
					order_receipt.add(order_receipts);
					Vector<String>buy_product = new Vector<String>();
					buy_product.addElement(receipt.get(0));
					buy_product.addElement(receipt.get(1));
					buy_product.addElement(receipt.get(2));
					order_model.addRow(buy_product);
					product_name.add((String)stock_table.getValueAt(row, 2));
					
					sum = sum + Integer.parseInt(order_model.getValueAt(sum_count, 1).toString());
					sumTextField.setText(Integer.toString(sum));
					++sum_count;
				}
			}	
		}
	}
	private class MyMouseListener2 extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			int row = order_table.getSelectedRow();
			int column = order_table.getSelectedColumn();
			
			sum = sum - Integer.parseInt((String)order_table.getValueAt(row, 1));
			sumTextField.setText(Integer.toString(sum));
			--sum_count;
			product_name.remove((String)order_table.getValueAt(row, 0));
			order_receipt.remove(row);
			((DefaultTableModel)order_table.getModel()).removeRow(row);			
		}
	}
}
				
				
				
				