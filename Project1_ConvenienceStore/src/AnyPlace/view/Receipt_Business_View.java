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
import AnyPlace.view.receipt_business_output_view.Receipt_issuance_view;
import AnyPlace.view.receipt_business_output_view.Return_service_view;

public class Receipt_Business_View extends JPanel{
	
	public Receipt_Business_View() {
		
		setLayout(null);
		setLocation(0,0);
		setSize(1467,902);
		setVisible(true);
		setBackground(Color.WHITE);
	   	JFrame frame = new JFrame();   
			
		 // 메뉴버튼
		    
	   	
		JTable order_table = table_set_data(this); // 테이블 초기 주문서 
		JTable detail_table = table2_set_data(this); // 영수증 상세

		
		JLabel option_label1 = create_option_label("매출구분", 1, this);
		JLabel option_label2 = create_option_label("거래기간", 2, this);
		JLabel option_label3 = create_option_label("결제수단", 3, this);
		JLabel option_label4 = create_option_label("판매금액", 4, this);
		JLabel option_label5 = create_option_label("상품코드", 5, this);
		JLabel option_label6 = create_option_label("영수증번호", 6, this);
		
		JTextArea option_text1 = create_option_text_area(this,1);
		option_text1.setText(null);
		JTextArea option_text2 = create_option_text_area(this,2);
		JTextArea option_text3 = create_option_text_area(this,3);
		JTextArea option_text4 = create_option_text_area(this,4);
		JTextArea option_text5 = create_option_text_area(this,5);
		JTextArea option_text6 = create_option_text_area(this,6);
		
		Color color = new Color(22,56,81);
		ImageIcon icon = new ImageIcon("./img/상품판매btn/버튼.png");		
		JButton issuance_button = add_Issuance_button(this); // 영수증발행 버튼
		issuance_button.setForeground(Color.WHITE);
		issuance_button.setFont(new Font("나눔고딕", Font.BOLD, 15));
		issuance_button.setBackground(color);
		
		
		JButton return_button = add_Return_button(this); // 반품 버튼
		return_button.setForeground(Color.WHITE);
		return_button.setFont(new Font("나눔고딕", Font.BOLD, 15));
		return_button.setBackground(color);
		
		JButton serch_button = create_serch_button(this); // 검색버튼
		JButton refresh = create_Refresh_btn(this);
		refresh.setForeground(Color.WHITE);
		refresh.setFont(new Font("나눔고딕", Font.BOLD, 15));
		refresh.setBackground(color);
		
		
		issuance_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { //영수증 출력
				int row = order_table.getSelectedRow();
				Object value = order_table.getValueAt(row, 1); // order_no 를 가져옴
				Receipt_Business rb = new Receipt_Business();
				ResultSet rs = rb.receipt_number((String) value);
				Receipt_issuance_view riv = new Receipt_issuance_view();
				riv.set_text(rs);

				
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
					Receipt_Business.return_service((String) value); // 영수증 테이블 클릭한다음 버튼 클릭하면 삭제됨
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				} 
				Return_service_view  rsv = new Return_service_view();
				new Receipt_Business_View();
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
	
	public static JButton create_Refresh_btn(Container pane) {
		JButton btn = new JButton("Refresh");
		btn.setBounds(350, 170, 100, 30);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				table_set_data(pane);
			}
		});
		pane.add(btn);
		return btn;
	}

	public static JTextArea create_option_text_area(Container pane, int option_num) {
		JTextArea text_area = new JTextArea();
		JScrollPane panel = new JScrollPane(text_area);
		switch(option_num) {
		case 1:
			panel.setBounds(50, 90, 100, 60);
			pane.add(panel);
			break;
		case 2:
			panel.setBounds(165, 90, 100, 60);
			pane.add(panel);
			break;
		case 3:
			panel.setBounds(280, 90, 100, 60);
			pane.add(panel);
			break;
		case 4:
			panel.setBounds(395, 90, 100, 60);
			pane.add(panel);
			break;
		case 5:
			panel.setBounds(510, 90, 100, 60);
			pane.add(panel);
			break;
		case 6:
			panel.setBounds(625, 90, 100, 60);
			pane.add(panel);
			break;
	}
		return text_area;
	}
 	public static JLabel create_option_label(String menu, int option_num, Container pane) {
 		JLabel label = new JLabel(menu);
		switch(option_num) {
			case 1:
				label.setBounds(50, 50, 100, 40);
				pane.add(label);
				break;
			case 2:
				label.setBounds(165, 50, 100, 40);
				pane.add(label);
				break;
			case 3:
				label.setBounds(280, 50, 100, 40);
				pane.add(label);
				break;
			case 4:
				label.setBounds(395, 50, 100, 40);
				pane.add(label);
				break;
			case 5:
				label.setBounds(510, 50, 100, 40);
				pane.add(label);
				break;
			case 6:
				label.setBounds(625, 50, 100, 40);
				pane.add(label);
				break;
		}
		return label;	
	}
	     
 	  public static JTable table2_set_data(Container pane) {
			JTable table;
	    	String [] title = {"상세영수증번호","영수증번호","제품시리얼번호","제품가격","제품이름"};
			DefaultTableModel model = new DefaultTableModel(title,0);
			table = new JTable(model);

			JScrollPane scroll_panel = new JScrollPane(table);
			scroll_panel.setBounds(480, 200, 450, 380);

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
	        	scroll_panel.setBounds(50, 200, 400, 380);

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
			btn.setBounds(760,50,160,100);
			pane.add(btn);
			return btn;
		}
	 	
	    public static JButton add_Issuance_button(Container pane) {
	    	JButton issuance_btn = new JButton("영수증발행");
	    	issuance_btn.setBounds(165, 610, 200, 50);
	    	pane.add(issuance_btn);
			return issuance_btn;
	    }

	    public static JButton add_Return_button(Container pane) {
	    	JButton return_btn = new JButton("반품업무");
	    	return_btn.setBounds(605, 610, 200, 50);
	    	pane.add(return_btn);
			return return_btn;
	    }
	 	
	public static void main(String[] args) {
		new Receipt_Business_View();
		
	}
}