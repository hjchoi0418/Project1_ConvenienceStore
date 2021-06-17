package AnyPlace.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import AnyPlace.controller.Receipt_Business;
import AnyPlace.controller.Receipt_Lookup;
import AnyPlace.model.Order_;
import AnyPlace.view.receipt_business_output_view.Return_service_view;

public class Receipt_Business_View extends JFrame{
	
	public Receipt_Business_View() {
		
		setTitle("Any Place");
	   	getContentPane().setLayout(null);
	   	
	   	try {	
			Image backgroundImage = javax.imageio.ImageIO.read(new File("./img/애니플_보드.jpg"));
		    setContentPane(
		    		new JPanel() {
		    			@Override 
		    			public void paintComponent(Graphics g) {
		    				g.drawImage(backgroundImage, 0, 0, null);

		    			}
		    		});
			} catch (IOException e) {
			    throw new RuntimeException(e);
			}
	   	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(1300,700);
		setSize(1467,902);
		getContentPane().setLayout(null);
		setVisible(true);
 
	   	JFrame frame = new JFrame();   
			
		 // 메뉴버튼
		    
	   	JButton menu1=new JButton();
	   	menu1.setIcon(new ImageIcon("./img/menu_A/메뉴_01.png"));
	   	menu1.setSelectedIcon(new ImageIcon("./img/menu_B/메뉴_over_01.png"));
	   	menu1.setPressedIcon(new ImageIcon("./img/menu_B/메뉴_over_01.png"));
	   	menu1.setBorderPainted(false);
	   	menu1.setContentAreaFilled(false);
	   	menu1.setFocusPainted(false);
	   	menu1.setBounds(95,269,239, 86);    
	   	getContentPane().add(menu1);
		
	   	JButton menu2=new JButton(new ImageIcon("./img/menu_A/메뉴_02.png"));  
	   	menu2.setSelectedIcon(new ImageIcon("./img/menu_B/메뉴_over_02.png"));
	   	menu2.setPressedIcon(new ImageIcon("./img/menu_B/메뉴_over_02.png"));
	   	menu2.setBorderPainted(false);
	   	menu2.setContentAreaFilled(false);
	   	menu2.setFocusPainted(false);
	   	menu2.setBounds(95,355,239, 86);    
	   	getContentPane().add(menu2);
	   	
	   	JButton menu3=new JButton(new ImageIcon("./img/menu_A/메뉴_03.png"));
	   	menu3.setSelectedIcon(new ImageIcon("./img/menu_B/메뉴_over_03.png"));
	   	menu3.setPressedIcon(new ImageIcon("./img/menu_B/메뉴_over_03.png"));
	   	menu3.setBorderPainted(false);
	   	menu3.setContentAreaFilled(false);
	   	menu3.setFocusPainted(false);
	   	menu3.setBounds(95, 441 ,239, 86);    
	   	getContentPane().add(menu3);
	   	
	   	JButton menu4=new JButton(new ImageIcon("./img/menu_A/메뉴_04.png"));  
	   	menu4.setSelectedIcon(new ImageIcon("./img/menu_B/메뉴_over_04.png"));
	   	menu4.setPressedIcon(new ImageIcon("./img/menu_B/메뉴_over_04.png"));
	   	menu4.setBorderPainted(false);
	   	menu4.setContentAreaFilled(false);
	   	menu4.setFocusPainted(false);
	   	menu4.setBounds(95, 527, 239, 86);    
	   	getContentPane().add(menu4);
	   	
	   	JButton menu5=new JButton(new ImageIcon("./img/menu_A/메뉴_05.png"));   
	   	menu5.setSelectedIcon(new ImageIcon("./img/menu_B/메뉴_over_05.png"));
	   	menu5.setPressedIcon(new ImageIcon("./img/menu_B/메뉴_over_05.png"));
	   	menu5.setBorderPainted(false);
	   	menu5.setContentAreaFilled(false);
	   	menu5.setFocusPainted(false);
	   	menu5.setBounds(95, 613, 239, 86);    
	   	getContentPane().add(menu5);
	   	
	   	setDefaultCloseOperation(EXIT_ON_CLOSE);
	   	setLocation(0,0);
	   	setSize(1467,902);
	   	getContentPane().setLayout(null);
	   	setVisible(true);
	   	
	   	

		
		JTable order_table = table_set_data(getContentPane()); // 테이블 초기 주문서 
		JTable detail_table = table2_set_data(getContentPane()); // 영수증 상세

		
		JLabel option_label1 = create_option_label("매출구분", 1, getContentPane());
		JLabel option_label2 = create_option_label("거래기간", 2, getContentPane());
		JLabel option_label3 = create_option_label("결제수단", 3, getContentPane());
		JLabel option_label4 = create_option_label("판매금액", 4, getContentPane());
		JLabel option_label5 = create_option_label("상품코드", 5, getContentPane());
		JLabel option_label6 = create_option_label("영수증번호", 6, getContentPane());
		
		JTextArea option_text1 = create_option_text_area(getContentPane(),1);
		option_text1.setText(null);
		JTextArea option_text2 = create_option_text_area(getContentPane(),2);
		JTextArea option_text3 = create_option_text_area(getContentPane(),3);
		JTextArea option_text4 = create_option_text_area(getContentPane(),4);
		JTextArea option_text5 = create_option_text_area(getContentPane(),5);
		JTextArea option_text6 = create_option_text_area(getContentPane(),6);
		
		JButton issuance_button = add_Issuance_button(getContentPane()); // 영수증발행 버튼
		JButton resale_button = add_Resale_button(getContentPane()); // 반품재판매 버튼
		JButton return_button = add_Return_button(getContentPane()); // 반품 버튼
		JButton serch_button = create_serch_button(getContentPane()); // 검색버튼
		
		resale_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = order_table.getSelectedRow();
				Object value = order_table.getValueAt(row, 1); // order_no 를 가져옴
				Receipt_Business rb = new Receipt_Business();
				ResultSet rs;
				try {
					rs = rb.Return_resale((String) value); // 영수증 테이블 클릭한다음 버튼 클릭하면 삭제됨
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				} 
			}
		});
		
		return_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = order_table.getSelectedRow();
				Object value = order_table.getValueAt(row, 1); // order_no 를 가져옴
				Receipt_Business rb = new Receipt_Business();
				try {
					rb.return_service((String) value); // 영수증 테이블 클릭한다음 버튼 클릭하면 삭제됨
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				} 
				Return_service_view rsv = new Return_service_view();
				

			}
		});
		
		//----------------------------------------------------------------------- 상세 영수증 출력 이벤트 
		order_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		order_table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				int row = order_table.getSelectedRow();
				Object value = order_table.getValueAt(row, 1);
				Receipt_Lookup rl = new Receipt_Lookup();
				ResultSet rs;
				rs = rl.receipt_number((String)value);
				DefaultTableModel model = (DefaultTableModel)detail_table.getModel();
				model.setNumRows(0);
				
					try {
						while(rs.next()) {
							String[] data = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)};
							model.addRow(data);
							} 
					}catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

		});
		//----------------------------------------------------------------------- 상세 영수증 출력 이벤트 
		
		//-------------------------------------------------------------------------------- serch_button 클릭이벤트
		serch_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Receipt_Business rb = new Receipt_Business();
				ResultSet rs;
				ArrayList<JTextArea> list = new ArrayList<>();
				ArrayList<JTextArea> serch_list = new ArrayList<>();
				DefaultTableModel model = (DefaultTableModel)order_table.getModel();
				String [] input_data;
				
				list.add(option_text1);
				list.add(option_text2);
				list.add(option_text3);
				list.add(option_text4);
				list.add(option_text5);
				list.add(option_text6);
				
				for(int i=0; i<6; i++) { // 내용이 들어있는 text_area를 찾는다.
					if(list.get(i).getText().trim().length()!=0) {
						serch_list.add(list.get(i));
					}			
				}
				
				if (serch_list.get(0) == option_text1) {
					rs = Receipt_Business.method_of_payment(option_text1.getText());
					
					model.setNumRows(0);
			    	try {

						while(rs.next()) {
							input_data = new String[]{rs.getString(2), rs.getString(1), rs.getString(4), rs.getString(3)};
							model.addRow(input_data);
							}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}
				if(serch_list.get(0) == option_text2) {	
					rs = Receipt_Business.trading_period(option_text2.getText());
					model.setNumRows(0);
					try {
						while(rs.next()) {
							input_data = new String[]{rs.getString(2), rs.getString(1), rs.getString(4), rs.getString(3)};
							model.addRow(input_data);
							}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				if(serch_list.get(0) == option_text3) {
					rs = rb.method_of_payment(option_text3.getText());
					model.setNumRows(0);
					try {
						while(rs.next()) {
							input_data = new String[]{rs.getString(2), rs.getString(1), rs.getString(4), rs.getString(3)};
							model.addRow(input_data);
							}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				if(serch_list.get(0) == option_text4) {
					rs = rb.sale_price(option_text4.getText());
					model.setNumRows(0);
					try {
						while(rs.next()) {
							input_data = new String[]{rs.getString(2), rs.getString(1), rs.getString(4), rs.getString(3)};
							model.addRow(input_data);
							}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				if(serch_list.get(0) == option_text5) {
					rs = rb.product_code(option_text5.getText());
					model.setNumRows(0);
					try {
						while(rs.next()) {
							input_data = new String[]{rs.getString(2), rs.getString(1), rs.getString(4), rs.getString(3)};
							model.addRow(input_data);
							}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				if(serch_list.get(0) == option_text6) {
					rs = rb.receipt_number(option_text6.getText());
					model.setNumRows(0);
					try {
						while(rs.next()) {
							input_data = new String[]{rs.getString(2), rs.getString(1), rs.getString(4), rs.getString(3)};
							model.addRow(input_data);
							}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}}}});
		//-------------------------------------------------------------------------------- serch_button 클릭이벤트
		
	    }

	public static JTextArea create_option_text_area(Container pane, int option_num) {
		JTextArea text_area = new JTextArea();
		JScrollPane panel = new JScrollPane(text_area);
		switch(option_num) {
		case 1:
			panel.setBounds(450, 140, 100, 60);
			pane.add(panel);
			break;
		case 2:
			panel.setBounds(565, 140, 100, 60);
			pane.add(panel);
			break;
		case 3:
			panel.setBounds(675, 140, 100, 60);
			pane.add(panel);
			break;
		case 4:
			panel.setBounds(785, 140, 100, 60);
			pane.add(panel);
			break;
		case 5:
			panel.setBounds(895, 140, 100, 60);
			pane.add(panel);
			break;
		case 6:
			panel.setBounds(1005, 140, 100, 60);
			pane.add(panel);
			break;
	}
		return text_area;
	}
 	public static JLabel create_option_label(String menu, int option_num, Container pane) {
 		JLabel label = new JLabel(menu);
		switch(option_num) {
			case 1:
				label.setBounds(450, 100, 100, 40);
				pane.add(label);
				break;
			case 2:
				label.setBounds(565, 100, 100, 40);
				pane.add(label);
				break;
			case 3:
				label.setBounds(675, 100, 100, 40);
				pane.add(label);
				break;
			case 4:
				label.setBounds(785, 100, 100, 40);
				pane.add(label);
				break;
			case 5:
				label.setBounds(895, 100, 100, 40);
				pane.add(label);
				break;
			case 6:
				label.setBounds(1005, 100, 100, 40);
				pane.add(label);
				break;
		}
		return label;	
	}
	     
 	  public static JTable table2_set_data(Container pane) {
			JTable table;
	    	String [] title = {"상세영수증번호","영수증번호","제품시리얼번호","제품가격","제품번호"};
			DefaultTableModel model = new DefaultTableModel(title,0);
			table = new JTable(model);

			JScrollPane scroll_panel = new JScrollPane(table);
			scroll_panel.setBounds(850, 269, 450, 380);

			pane.add(scroll_panel);  
			return table;

		}

	    public static JTable table_set_data(Container pane) {
			JTable table;
	    	try {
	    		String [] title = {"일자","영수증","금액","거래구분"};
	            DefaultTableModel model = new DefaultTableModel(title,0);
	            table = new JTable(model);
	            table.getColumnModel().getColumn(0).setPreferredWidth(200);

	        	JScrollPane scroll_panel = new JScrollPane(table);
	        	scroll_panel.setBounds(420, 269, 400, 380);

	            Receipt_Business rb = new Receipt_Business();
	        	ResultSet rs = rb.all_Receipt();
	    		//System.out.println(rs.isBeforeFirst()); 널체크 false == null

	        	String [] input_data;
	        	
		    	while(rs.next()) {
		    		input_data = new String[]{rs.getString(2), rs.getString(1), rs.getString(4), rs.getString(3)};
		    		model.addRow(input_data);
		    		}
		   
		     	pane.add(scroll_panel);  
		     	return table;
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    		return null;
	    	}

		}



	 	public static JButton create_serch_button(Container pane) {
			ImageIcon icon = new ImageIcon("./image/serch.png");
			JButton btn = new JButton(icon);
			btn.setBackground(Color.white);
			btn.setBounds(1150,100,160,100);
			pane.add(btn);
			return btn;
		}
	 	
	 	
	    public static JButton add_Issuance_button(Container pane) {
	    	JButton issuance_btn = new JButton("영수증발행");
	    	issuance_btn.setBounds(550, 720, 200, 65);
	    	pane.add(issuance_btn);
			return issuance_btn;
	    }
	    public static JButton add_Resale_button(Container pane) {
	    	JButton issuance_btn = new JButton("반품재판매");
	    	issuance_btn.setBounds(770, 720, 200, 65);
	    	pane.add(issuance_btn);
			return issuance_btn;
	    }
	    public static JButton add_Return_button(Container pane) {
	    	JButton issuance_btn = new JButton("반품업무");
	    	issuance_btn.setBounds(990, 720, 200, 65);
	    	pane.add(issuance_btn);
			return issuance_btn;
	    }
	 	
	public static void main(String[] args) {
		new Receipt_Business_View();
		
	}
}

