package AnyPlace.controller.BuyProduct;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class buy_main {

	private JFrame frame;
	private JPanel currPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					buy_main window = new buy_main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public buy_main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1350, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// 메인 패널
		ImagePanel mainpanel = new ImagePanel(new ImageIcon("./kimage/애니플_보드.jpg").getImage());
		mainpanel.setLocation(0, 0);
		mainpanel.setVisible(true);
		frame.setSize(mainpanel.getDim());
		frame.setPreferredSize(mainpanel.getDim());
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(mainpanel);
		currPanel = mainpanel;  //패널 이동할 때 쓰임
		
		// 조회 패널
		ImagePanel lookup_panel = new ImagePanel(new ImageIcon("./kimage/애니플_보드.jpg").getImage());
		lookup_panel.setLocation(0, 0);
		lookup_panel.setVisible(false);
		frame.setSize(lookup_panel.getDim());
		frame.setPreferredSize(lookup_panel.getDim());
		frame.getContentPane().add(lookup_panel);
		frame.pack();
		
		// 테이블 패널
		JPanel table_panel = new JPanel();
		table_panel.setBackground(Color.WHITE);
		table_panel.setBounds(380, 170, 1000, 400);
		lookup_panel.add(table_panel);
		
		String[][] data = Lookup_method.getproduct();
		String[] headers = new String [] {"상품번호", "분류", "상품 이름", "상품 가격", "재고"};
		
		JTable table = new JTable(data, headers);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setPreferredSize(new Dimension(950, 380));
		table.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		table.setBackground(new Color(255, 255, 255));
		table.setForeground(new Color(0, 0, 0));
		table.setRowHeight(40);
		table_panel.add(scrollpane);
	
		// 헤더 폰트
		JTableHeader header = table.getTableHeader();
	    header.setBackground(Color.blue);
	    header.setForeground(Color.white);
	    header.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		
	    // 가운데 정렬
	    DefaultTableCellRenderer tScheduleCellRenderer1 = new DefaultTableCellRenderer();
		tScheduleCellRenderer1.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule1 = table.getColumnModel();
		for (int i = 0; i < tcmSchedule1.getColumnCount(); i++) {
		tcmSchedule1.getColumn(i).setCellRenderer(tScheduleCellRenderer1);
		}
	    
	    // 컬럼 사이 간격 조정
		TableColumnModel columnModels = table.getColumnModel();
		columnModels.getColumn(0).setPreferredWidth(30);
		columnModels.getColumn(1).setPreferredWidth(60);
		columnModels.getColumn(2).setPreferredWidth(200);
		columnModels.getColumn(3).setPreferredWidth(100);
		columnModels.getColumn(4).setPreferredWidth(1);
		table_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		// 텍스트 입력창
		JTextField search = new JTextField();
		search.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		search.setBounds(920, 654, 230, 50);
		lookup_panel.add(search);
		search.setBackground(SystemColor.WHITE);
		search.setColumns(10);
		search.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String val = search.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<>(table.getModel());
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});
		// 검색 이미지
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(520, 580, 1000, 200);
		lookup_panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("./kimage/검색.PNG"));
		
		// 뒤로가기(조회 패널)
		JButton btnback1 = new JButton("");
		btnback1.setIcon(new ImageIcon("./kimage/뒤로가기.PNG"));
		btnback1.setBounds(1210, 80, 160, 60);
		lookup_panel.add(btnback1);
		btnback1.setBorder(BorderFactory.createLineBorder(Color.WHITE));  //테두리 색깔 변경
		btnback1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currPanel.setVisible(false);
				mainpanel.setVisible(true);
				currPanel = mainpanel;
			}
		});
		
		// 상품 구매 패널
		ImagePanel buypanel = new ImagePanel(new ImageIcon("./kimage/애니플_보드.jpg").getImage());
		buypanel.setLocation(0, 0);
		buypanel.setVisible(false);
		frame.setSize(buypanel.getDim());
		frame.setPreferredSize(buypanel.getDim());
		frame.getContentPane().add(buypanel);
		frame.pack();
		
		// 테이블 패널 (상품 확인창) 
		JPanel buy_table_panel = new JPanel();
		buy_table_panel.setBackground(Color.WHITE);
		buy_table_panel.setBounds(380, 220, 590, 360);
		buypanel.add(buy_table_panel);
		
		String[][] data1 = Lookup_method.getproduct();
		String[] headers1 = new String [] {"상품번호", "분류", "상품 이름", "상품 가격", "재고"};
		DefaultTableModel buy_model = new DefaultTableModel(data1, headers1);
		JTable buy_table = new JTable(buy_model);
		JScrollPane buy_scrollpane = new JScrollPane(buy_table);
		buy_scrollpane.setPreferredSize(new Dimension(580, 350));
		buy_table.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		buy_table.setBackground(new Color(255, 255, 255));
		buy_table.setForeground(new Color(0, 0, 0));
		buy_table.setRowHeight(40);
		buy_table_panel.add(buy_scrollpane);
		
		// 헤더 폰트
		JTableHeader header1 = buy_table.getTableHeader();
		header1.setBackground(Color.blue);
		header1.setForeground(Color.white);
		header1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		
		// 가운데 정렬
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule = buy_table.getColumnModel();
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
		tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}
		
		// 컬럼 사이 간격 조정
		TableColumnModel columnModels1 = buy_table.getColumnModel();
		columnModels1.getColumn(0).setPreferredWidth(40);
		columnModels1.getColumn(1).setPreferredWidth(40);
		columnModels1.getColumn(2).setPreferredWidth(170);
		columnModels1.getColumn(3).setPreferredWidth(60);
		columnModels1.getColumn(4).setPreferredWidth(1);
		buy_table_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		// 상품목록
		JLabel productLabel = new JLabel("");
		productLabel.setBounds(500, 120, 350, 80);
		buypanel.add(productLabel);
		productLabel.setIcon(new ImageIcon("./kimage/상품목록.PNG"));

		// 뒤로가기(구매 패널)
		JButton btnback2 = new JButton("");
		btnback2.setIcon(new ImageIcon("./kimage/뒤로가기.PNG"));
		btnback2.setBounds(1210, 80, 160, 60);
		buypanel.add(btnback2);
		btnback2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		btnback2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currPanel.setVisible(false);
				mainpanel.setVisible(true);
				currPanel = mainpanel;
			}
		});
		
		JPanel order_table_panel = new JPanel();
		order_table_panel.setBackground(Color.WHITE);
		order_table_panel.setBounds(1000, 220, 350, 360);
		buypanel.add(order_table_panel);
		
		//벡터이용
		Vector<String> order_headers = new Vector<String>();
		order_headers.add("상품 이름");
		order_headers.add("총 가격");
		order_headers.add("수량");
		
		//오더 테이블
		DefaultTableModel order_model = new DefaultTableModel(order_headers, 0);
		JTable order_table = new JTable(order_model);
		JScrollPane order_scrollpane = new JScrollPane(order_table);
		order_scrollpane.setPreferredSize(new Dimension(340, 350));
		order_table.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		order_table.setBackground(new Color(255, 255, 255));
		order_table.setForeground(new Color(0, 0, 0));
		order_table.setRowHeight(40);
		order_table_panel.add(order_scrollpane);
		
		// 헤더 폰트
		JTableHeader order_header = order_table.getTableHeader();
		order_table.setBackground(Color.white);
		order_table.setForeground(Color.black);
		order_table.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
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
		order.setBounds(605, 600, 100, 40);
		buypanel.add(order);
		order.setBackground(SystemColor.WHITE);
		order.setColumns(10);
		
		// 수량 입력창
		JTextField count = new JTextField();
		count.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		count.setBounds(840, 600, 100, 40);
		buypanel.add(count);
		count.setBackground(SystemColor.WHITE);
		count.setColumns(10);
		// 결제정보
		ArrayList<Order_receipt> order_receipt = new ArrayList<Order_receipt>();
		// 장바구니 추가
		JButton btnadd = new JButton("");
		btnadd.setIcon(new ImageIcon("./kimage/장바구니추가.PNG"));
		btnadd.setBounds(380, 650, 185, 128);
		btnadd.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		buypanel.add(btnadd);
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> a = Buy_method.getorder(order.getText(), count.getText());
				if(Integer.parseInt(count.getText()) > Buy_method.search(a.get(0))) {
					Error e_message = new Error(frame);
					e_message.setVisible(true);
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
		JButton btnclear = new JButton("");
		btnclear.setIcon(new ImageIcon("./kimage/장바구니초기화.PNG"));
		btnclear.setBounds(780, 650, 185, 128);
		btnclear.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		buypanel.add(btnclear);
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)order_table.getModel();
				model.setNumRows(0);
				order_receipt.clear();
			}
		});
		
		// 결제 버튼
		JButton btnbuy = new JButton("");
		btnbuy.setIcon(new ImageIcon("./kimage/카드결제.PNG"));
		btnbuy.setBounds(1070, 580, 220, 80);
		btnbuy.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		buypanel.add(btnbuy);
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
				Complete c_message = new Complete(frame);
				c_message.setVisible(true);
			}
		});

							
		// 주문판
		JLabel orderLabel = new JLabel("");
		orderLabel.setBounds(370, 520, 1000, 200);
		buypanel.add(orderLabel);
		orderLabel.setIcon(new ImageIcon("./kimage/주문판.PNG"));

		// 상품조회 버튼
		JButton btnlookup = new JButton("");
		btnlookup.setIcon(new ImageIcon("./kimage/상품조회.PNG"));
		btnlookup.setBounds(460, 280, 360, 320);
		btnlookup.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		mainpanel.add(btnlookup);
		btnlookup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currPanel.setVisible(false);
				lookup_panel.setVisible(true);
				currPanel = lookup_panel;
			}
		});
		// 상품구매 버튼
		JButton btnproductbuy = new JButton("");
		btnproductbuy.setIcon(new ImageIcon("./kimage/물품구매.PNG"));
		btnproductbuy.setBounds(950, 280, 360, 320);
		btnproductbuy.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		mainpanel.add(btnproductbuy);
		btnproductbuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currPanel.setVisible(false);
				buypanel.setVisible(true);
				currPanel = buypanel;
			}
		});
	}
	
}