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
	
	String frame;
	ImageIcon icon;
	JButton 장바구니추가, 장바구니초기화, 카드결제, 현금결제;
	JTable stock_table, buy_table;
	JScrollPane scroll; // 테이블 위에 열 라벨을 넣어주자~ scroll
	
	private String[][] data;
	private String[] columnType = {"상품번호", "분류", "상품 이름", "상품 가격", "재고"};

	public Sell_product_view() {
		setBorder(new EmptyBorder(20, 50, 20, 50));
		setBackground(Color.white);
		setLayout(null);
		
		
		JPanel buy_table_panel = new JPanel();
		buy_table_panel.setBackground(Color.white);
		buy_table_panel.setBounds(20, 20, 600, 580);
		add(buy_table_panel);
		
		data = Lookup_method.getproduct();
		DefaultTableModel model = new DefaultTableModel(data, columnType) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
		};
		
		stock_table = new JTable(model);
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
		columnModels.getColumn(1).setPreferredWidth(40);
		columnModels.getColumn(2).setPreferredWidth(170);
		columnModels.getColumn(3).setPreferredWidth(60);
		columnModels.getColumn(4).setPreferredWidth(1);
		
		JPanel order_table_panel = new JPanel();
		order_table_panel.setBackground(Color.white);
		order_table_panel.setBounds(630, 20, 380, 580);
		add(order_table_panel);
		
		Vector<String> order_headers = new Vector<String>();
		order_headers.add("상품 이름");
		order_headers.add("총 가격");
		order_headers.add("수량");
		
		//오더 테이블
		DefaultTableModel order_model = new DefaultTableModel(order_headers, 0) {
			boolean[] columnEditables = new boolean[] {
					false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
		};
		JTable order_table = new JTable(order_model);
		JScrollPane order_scrollpane = new JScrollPane(order_table);
		order_scrollpane.setPreferredSize(new Dimension(370, 570));

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
		
//		order_table.setFont(new Font("맑은 고딕", Font.BOLD, 16));
//		order_table.setBackground(new Color(255, 255, 255));
//		order_table.setForeground(new Color(0, 0, 0));
//		order_table.setRowHeight(40);
		order_table_panel.add(order_scrollpane);
		
//		JTableHeader order_header = order_table.getTableHeader();
//		order_table.setBackground(Color.white);
//		order_table.setForeground(Color.black);
//		order_table.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
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
		order.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		order.setBounds(272, 620, 186, 33);
		add(order);
		order.setBackground(SystemColor.WHITE);
		order.setColumns(10);
		
		// 수량 입력창
		JTextField count = new JTextField();
		count.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		count.setBounds(463, 620, 186, 33);
		add(count);
		count.setBackground(SystemColor.WHITE);
		count.setColumns(10);
		// 결제정보
		ArrayList<Order_receipt> order_receipt = new ArrayList<Order_receipt>();
		// 장바구니 추가
		JButton btnadd = new JButton("추가");
		btnadd.setIcon(new ImageIcon("./image/장바구니추가.PNG"));
		btnadd.setBounds(654, 620, 27, 17);
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
		// 초기화
		JButton btnclear = new JButton("초기화");
		btnclear.setIcon(new ImageIcon("./image/장바구니초기화.PNG"));
		btnclear.setBounds(686, 620, 39, 17);
		btnclear.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		add(btnclear);
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)order_table.getModel();
				model.setNumRows(0);
				order_receipt.clear();
			}
		});
		
		// 결제 버튼
		JButton btnbuy = new JButton("결제");
		btnbuy.setIcon(new ImageIcon("./image/카드결제.PNG"));
		btnbuy.setBounds(730, 620, 27, 17);
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
		
		setSize(1030, 700);
//		table = new JTable(model);
//		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // 단일선택
//		table.setRowSelectionAllowed(true);	// 셀 선택되는 색이 .. 
//		table.getTableHeader().setReorderingAllowed(false);
//		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
//		table.addMouseListener(new DisposalView_MouseEventListener(table));
////		table.setForeground(new Color(75, 0, 130));
////		table.setBackground(new Color(192, 192, 192));
////		table.setFont(new Font("맑은 고딕", Font.BOLD, 12));
////		table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
//
//		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//		scroll = new JScrollPane(table);
//		add(scroll);
		
	}
}