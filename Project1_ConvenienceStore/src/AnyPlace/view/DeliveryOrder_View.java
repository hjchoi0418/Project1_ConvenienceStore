package AnyPlace.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import AnyPlace.controller.DeliveryCont;
import AnyPlace.controller.DisposalCont;
import AnyPlace.mouseEventListener.DeliveryView_MouseEventListener;

public class DeliveryOrder_View extends JPanel {
//	ImageIcon icon;
//
//	public Dimension getPreferredSize() {
//		Dimension largeBtnSz = new Dimension(super.getPreferredSize().width + 30, super.getPreferredSize().height + 30);
//		return largeBtnSz;
//	}
	JTable table;
	JScrollPane scroll; // 테이블 위에 열 라벨을 넣어주자~ scroll
	
	String col_name[] = { "중분류", "상품코드", "상품명", "구매수량" };
	String data[][];// {{ "1.도시락", "1", "알찬도시락", "1", "06-11 00:00" }};
	DeliveryCont deliveryCont = new DeliveryCont();
	private JButton button;
	private JButton button_1;

	// 주문 수량, 원가
	private int cnt = 0;
	private int total_cost = 0;

	int row;
	DeliveryView_MouseEventListener dvm = new DeliveryView_MouseEventListener(table);

	public DeliveryOrder_View() {
//		setTitle("Any Place");
//		getContentPane().setLayout(null);
//		try {
//			final Image backgroundImage = javax.imageio.ImageIO.read(new File("./img/애니플_보드.jpg"));
//			setContentPane(new JPanel(new BorderLayout()) {
//				@Override
//				public void paintComponent(Graphics g) {
//					g.drawImage(backgroundImage, 0, 0, null);
//					setOpaque(false);
//					super.paintComponent(g);
//				}
//			});
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}

		// 테이블
		data = deliveryCont.allProductsCount();
		DefaultTableModel model = new DefaultTableModel(data, col_name) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if (column >= 0) {
					return false;
				} else {
					return true;
				}
			}
		};
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // 단일선택
		table.setRowSelectionAllowed(true); // 셀 선택되는 색이 ..
		table.addMouseListener(new DeliveryView_MouseEventListener(table));

		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scroll = new JScrollPane(table);
		scroll.setBounds(500, 220, 760, 350);
		add(scroll);

		// textarea
//		waste_count = disposalCont.waste_count;
//		total_waste_price = disposalCont.total_waste_price;
		// #################
		// 실시간으로 textArea 수량 + 원가금액 표시 나중에 처리
		// 일단 주문하면 팝업창을 띄워서 알림
		
//		JTextArea textArea = new JTextArea("합계수량  " + order_count + "\t\t원가 금액 합계  " + total_cost);
		JTextArea textArea = new JTextArea("합계수량  " + cnt + "\t\t원가 금액 합계  " + total_cost);
		textArea.setForeground(Color.ORANGE);
		textArea.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		textArea.setEditable(false);
		textArea.setBackground(new Color(72, 61, 139));
		textArea.setBounds(500, 570, 560 ,46);
		add(textArea);

		button_1 = new JButton("주문");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dvm.addProducts(table);
			}
		});
		button_1.setBackground(new Color(72, 61, 139));
		button_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
//		button_1.setBorderPainted(false);
		button_1.setContentAreaFilled(false);
		button_1.setFocusPainted(false);
		button_1.setBounds(1109, 570, 150, 46);
		add(button_1);
		
		JButton btnNewButton_2 = new JButton("+");
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int temp;
				
				for(int i=0; i<dvm.nSelectedRow.length; i++) {
					temp = 0;
					temp = Integer.parseInt(String.valueOf(table.getValueAt(dvm.nSelectedRow[i], 3))); //temp = 현재 선택된 셀들의 [i] 번째 셀의 수량
					table.setValueAt(temp+1,dvm.nSelectedRow[i], 3); // 선택된 셀의 수량을 현재 수량 + 1 아래 버튼들도 동일한 방법
					cnt++; // 물품 총 수량 ++
					total_cost = dvm.getTotalCost(table); // 물품 총 원가 
					textArea.setText("합계수량  " + cnt + "\t\t원가 금액 합계  " + total_cost);  
				}
			}
		});
		btnNewButton_2.setBounds(700, 650, 70, 70);
		add(btnNewButton_2);
		
		JButton button_2 = new JButton("+10");
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int temp;
				for(int i=0; i<dvm.nSelectedRow.length; i++) {
					temp = 0;
					temp = Integer.parseInt(String.valueOf(table.getValueAt(dvm.nSelectedRow[i], 3)));
					table.setValueAt(temp+10,dvm.nSelectedRow[i], 3);
					cnt = cnt+10;
					total_cost = dvm.getTotalCost(table); // 물품 총 원가 
					textArea.setText("합계수량  " + cnt + "\t\t원가 금액 합계  " + total_cost);  
				}
			}
		});
		button_2.setBounds(790, 650, 70, 70);
		add(button_2);
		
		JButton button_3 = new JButton("+100");
		button_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int temp;
				for(int i=0; i<dvm.nSelectedRow.length; i++) {
					temp = 0;
					temp = Integer.parseInt(String.valueOf(table.getValueAt(dvm.nSelectedRow[i], 3)));
					table.setValueAt(temp+100,dvm.nSelectedRow[i], 3);
					cnt = cnt+100;
					total_cost = dvm.getTotalCost(table); // 물품 총 원가 
					textArea.setText("합계수량  " + cnt + "\t\t원가 금액 합계  " + total_cost);  
				}
			}
		});
		button_3.setBounds(880, 650, 70, 70);
		add(button_3);
		
		JButton button_4 = new JButton("-");
		button_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int temp;
				for(int i=0; i<dvm.nSelectedRow.length; i++) {
					temp = 0;
					temp = Integer.parseInt(String.valueOf(table.getValueAt(dvm.nSelectedRow[i], 3)));
					if(Integer.parseInt(String.valueOf(table.getValueAt(dvm.nSelectedRow[i], 3))) != 0) {
						table.setValueAt(temp-1,dvm.nSelectedRow[i], 3);
						cnt--;
						total_cost = dvm.getTotalCost(table); // 물품 총 원가 
						textArea.setText("합계수량  " + cnt + "\t\t원가 금액 합계  " + total_cost);
					}
				}
			}
		});
		button_4.setBounds(700, 740, 70, 70);
		add(button_4);
		
		JButton button_5 = new JButton("-10");
		button_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int temp;
				for(int i=0; i<dvm.nSelectedRow.length; i++) {
					temp = 0;
					// temp = 현재 선택된 셀들의 [i] 번째 셀의 수량 정보
					temp = Integer.parseInt(String.valueOf(table.getValueAt(dvm.nSelectedRow[i], 3)));
					// 현재 셀의 수량이 0보다 작거나, -10했을때 0 보다 작을 경우 수량을 0 으로 초기화
					if(Integer.parseInt(String.valueOf(table.getValueAt(dvm.nSelectedRow[i], 3))) <= 0 || 
							Integer.parseInt(String.valueOf(table.getValueAt(dvm.nSelectedRow[i], 3))) -10 <= 0) {
						table.setValueAt(0,dvm.nSelectedRow[i], 3);
						cnt = cnt-(temp);
						total_cost = dvm.getTotalCost(table); // 물품 총 원가 
						textArea.setText("합계수량  " + cnt + "\t\t원가 금액 합계  " + total_cost);
					// 현재 셀이 10보다 클경우 -10 정상 동작
					}else if(Integer.parseInt(String.valueOf(table.getValueAt(dvm.nSelectedRow[i], 3))) > 10) {
						table.setValueAt(temp-10,dvm.nSelectedRow[i], 3);
						cnt = cnt-10;
						total_cost = dvm.getTotalCost(table); // 물품 총 원가 
						textArea.setText("합계수량  " + cnt + "\t\t원가 금액 합계  " + total_cost);
					}
				}
			}
		});
		button_5.setBounds(790, 740, 70, 70);
		add(button_5);
		
		JButton button_6 = new JButton("-100");
		button_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int temp;
				for(int i=0; i<dvm.nSelectedRow.length; i++) {
					temp = 0;
					temp = Integer.parseInt(String.valueOf(table.getValueAt(dvm.nSelectedRow[i], 3)));
					if(Integer.parseInt(String.valueOf(table.getValueAt(dvm.nSelectedRow[i], 3))) <= 0 || Integer.parseInt(String.valueOf(table.getValueAt(dvm.nSelectedRow[i], 3))) -100 <= 0) {
						table.setValueAt(0,dvm.nSelectedRow[i], 3);
						cnt = cnt-(temp);
						total_cost = dvm.getTotalCost(table); // 물품 총 원가 
						textArea.setText("합계수량  " + cnt + "\t\t원가 금액 합계  " + total_cost);
					}else if(Integer.parseInt(String.valueOf(table.getValueAt(dvm.nSelectedRow[i], 3))) > 10) {
						table.setValueAt(temp-100,dvm.nSelectedRow[i], 3);
						cnt = cnt-100;
						total_cost = dvm.getTotalCost(table); // 물품 총 원가 
						textArea.setText("합계수량  " + cnt + "\t\t원가 금액 합계  " + total_cost);
					}
				}
			}
		});
		button_6.setBounds(880, 740, 70, 70);
		add(button_6);

		JButton menu1 = new JButton();
		menu1.setIcon(new ImageIcon("./img/menu_A/메뉴_01.png"));
		menu1.setSelectedIcon(new ImageIcon("./img/menu_B/메뉴_over_01.png"));
		menu1.setPressedIcon(new ImageIcon("./img/menu_B/메뉴_over_01.png"));
		menu1.setBorderPainted(false);
		menu1.setContentAreaFilled(false);
		menu1.setFocusPainted(false);
		menu1.setBounds(95, 269, 239, 86);
		add(menu1);

		JButton menu2 = new JButton(new ImageIcon("./img/menu_A/메뉴_02.png"));
		menu2.setSelectedIcon(new ImageIcon("./img/menu_B/메뉴_over_02.png"));
		menu2.setPressedIcon(new ImageIcon("./img/menu_B/메뉴_over_02.png"));
		menu2.setBorderPainted(false);
		menu2.setContentAreaFilled(false);
		menu2.setFocusPainted(false);
		menu2.setBounds(95, 355, 239, 86);
		add(menu2);

		JButton menu3 = new JButton(new ImageIcon("./img/menu_A/메뉴_03.png"));
		menu3.setSelectedIcon(new ImageIcon("./img/menu_B/메뉴_over_03.png"));
		menu3.setPressedIcon(new ImageIcon("./img/menu_B/메뉴_over_03.png"));
		menu3.setBorderPainted(false);
		menu3.setContentAreaFilled(false);
		menu3.setFocusPainted(false);
		menu3.setBounds(95, 441, 239, 86);
		add(menu3);

		JButton menu4 = new JButton(new ImageIcon("./img/menu_B/메뉴_over_04.png"));
		menu4.setSelectedIcon(new ImageIcon("./img/menu_B/메뉴_over_04.png"));
		menu4.setPressedIcon(new ImageIcon("./img/menu_B/메뉴_over_04.png"));
		menu4.setBorderPainted(false);
		menu4.setContentAreaFilled(false);
		menu4.setFocusPainted(false);
		menu4.setBounds(95, 527, 239, 86);
		add(menu4);

		JButton menu5 = new JButton(new ImageIcon("./img/menu_A/메뉴_05.png"));
		menu5.setSelectedIcon(new ImageIcon("./img/menu_B/메뉴_over_05.png"));
		menu5.setPressedIcon(new ImageIcon("./img/menu_B/메뉴_over_05.png"));
		menu5.setBorderPainted(false);
		menu5.setContentAreaFilled(false);
		menu5.setFocusPainted(false);
		menu5.setBounds(95, 613, 239, 86);
		add(menu5);
		
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(370, 50);
		setSize(1467, 902);
//		getContentPane().setLayout(null);
		setVisible(true);

//		setTitle("Any Place");
//
//		getContentPane().setLayout(null);
//
//		try {
//			final Image backgroundImage = javax.imageio.ImageIO.read(new File("./img/애니플_보드.jpg"));
//			setContentPane(new JPanel(new BorderLayout()) {
//				@Override
//				public void paintComponent(Graphics g) {
//					g.drawImage(backgroundImage, 0, 0, null);
//					setOpaque(false);
//					super.paintComponent(g);
//				}
//			});
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setLocation(400, 400);
//		setSize(1467, 902);
//		getContentPane().setLayout(null);
//		setVisible(true);
	}

	public static void main(String[] args) {
		new DeliveryOrder_View();
	}
}
