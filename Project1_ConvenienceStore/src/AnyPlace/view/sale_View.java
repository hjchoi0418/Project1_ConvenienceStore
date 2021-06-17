package AnyPlace.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


import AnyPlace.controller.Cash_Management;
import AnyPlace.controller.Login;

import java.awt.Font;


public class sale_View extends JFrame {
	ImageIcon icon;
	
	
	public Dimension getPreferredSize(){
        Dimension largeBtnSz = new Dimension(super.getPreferredSize().width+30, super.getPreferredSize().height+30);
        return largeBtnSz;
	}

	     public sale_View() {
	    	
	    	 setTitle("Any Place");
	    	 
	    	 getContentPane().setLayout(null);
	    	 

	    	 try {	
	    			final Image backgroundImage = javax.imageio.ImageIO.read(new File("./img/애니플_보드.jpg"));
	    		    setContentPane(new JPanel(new BorderLayout()) {
	    		        @Override public void paintComponent(Graphics g) {
	    		            g.drawImage(backgroundImage, 0, 0, null);
	    		            setOpaque(false);
	    	                super.paintComponent(g);
	    		        }
	    		    });
	    			} catch (IOException e) {
	    			    throw new RuntimeException(e);
	    			}
	     
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

	// 그 외 버튼
		
		JButton 조회업무=new JButton(new ImageIcon("./img/상품판매btn/조회업무.png"));
		조회업무.setBorderPainted(false);
		조회업무.setContentAreaFilled(false);
		조회업무.setFocusPainted(false);
		조회업무.setBounds(1067, 88, 121, 46);    
		getContentPane().add(조회업무);
		
		JButton 판매보류=new JButton(new ImageIcon("./img/상품판매btn/판매보류.png"));
		판매보류.setBorderPainted(false);
		판매보류.setContentAreaFilled(false);
		판매보류.setFocusPainted(false);
		판매보류.setBounds(1196, 88, 121, 46);    
		getContentPane().add(판매보류);
		
		JButton 현금결제=new JButton(new ImageIcon("./img/상품판매btn/현금결제.png"));
		현금결제.setBorderPainted(false);
		현금결제.setContentAreaFilled(false);
		현금결제.setFocusPainted(false);
		현금결제.setBounds(980, 740, 179, 68);    
		getContentPane().add(현금결제);
		
		JButton 카드결제=new JButton(new ImageIcon("./img/상품판매btn/카드결제.png"));
		카드결제.setBorderPainted(false);
		카드결제.setContentAreaFilled(false);
		카드결제.setFocusPainted(false);
		카드결제.setBounds(1181, 740, 179, 68);
		getContentPane().add(카드결제);
		

		JButton 검색2=new JButton(new ImageIcon("./img/재고점검/검색버튼.png"));
		검색2.setSelectedIcon(new ImageIcon("./img/재고점검/검색버튼_B.png"));
		검색2.setPressedIcon(new ImageIcon("./img/재고점검/검색버튼_B.png"));
		검색2.setBorderPainted(false);
		검색2.setContentAreaFilled(false);
		검색2.setFocusPainted(false);
		검색2.setBounds(1313, 232, 48, 48);
		getContentPane().add(검색2);
		
	
		JLabel label1 = new JLabel("① 장부재고 : 점포경영시스템 재고관리 메뉴에서 조회하는 재고수량으로 폐기수량이 반영되지 않은 재고조사의 기준이 되는 재고");
		label1.setFont(new Font("나눔고딕", Font.BOLD, 12));
		label1.setForeground(new Color(22, 56, 81));
		JLabel label2 = new JLabel("② 발주재고 : 점포경영시스템 발주화면에서 조회되는 재고수량으로 폐기수량과 입고예정수량이 반영된 재고");
		label2.setFont(new Font("나눔고딕", Font.BOLD, 12));
		label2.setForeground(new Color(22, 56, 81));
		
		label1.setSize(860, 43);
		label2.setSize(860, 43);
		label1.setLocation(387, 159);
		label2.setLocation(387, 180);
		getContentPane().add(label1, BorderLayout.NORTH);
		getContentPane().add(label2, BorderLayout.NORTH);
//		getContentPane().pack();
		getContentPane().setVisible(true);



	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(1300,700);
		setSize(1467,902);
		getContentPane().setLayout(null);
		setVisible(true);
	     }

	     

	     
	public static void main(String[] args) {
		new sale_View();
	
	}
}

