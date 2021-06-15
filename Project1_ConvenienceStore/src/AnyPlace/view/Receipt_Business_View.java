package AnyPlace.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import AnyPlace.controller.Receipt_Business;

public class Receipt_Business_View extends JFrame{
	ImageIcon icon;
	
	

	public Dimension getPreferredSize(){
        Dimension largeBtnSz = new Dimension(super.getPreferredSize().width+30, super.getPreferredSize().height+30);
        return largeBtnSz;
	}

	     public Receipt_Business_View() {
	    	 
	    	 
	    	
	    	 setTitle("Any Place");
	    	 
	    	 getContentPane().setLayout(null);
	    	 

	    	 try {	
	    			final Image backgroundImage = javax.imageio.ImageIO.read(new File("./img/�ִ���_����.jpg"));
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
		
	 // �޴���ư
	    
		JButton menu1=new JButton();
		menu1.setIcon(new ImageIcon("./img/menu_A/�޴�_01.png"));
		menu1.setSelectedIcon(new ImageIcon("./img/menu_B/�޴�_over_01.png"));
		menu1.setPressedIcon(new ImageIcon("./img/menu_B/�޴�_over_01.png"));
		menu1.setBorderPainted(false);
		menu1.setContentAreaFilled(false);
		menu1.setFocusPainted(false);
		menu1.setBounds(95,269,239, 86);    
		getContentPane().add(menu1);
		
		JButton menu2=new JButton(new ImageIcon("./img/menu_A/�޴�_02.png"));  
		menu2.setSelectedIcon(new ImageIcon("./img/menu_B/�޴�_over_02.png"));
		menu2.setPressedIcon(new ImageIcon("./img/menu_B/�޴�_over_02.png"));
		menu2.setBorderPainted(false);
		menu2.setContentAreaFilled(false);
		menu2.setFocusPainted(false);
		menu2.setBounds(95,355,239, 86);    
		getContentPane().add(menu2);
		
		JButton menu3=new JButton(new ImageIcon("./img/menu_A/�޴�_03.png"));
		menu3.setSelectedIcon(new ImageIcon("./img/menu_B/�޴�_over_03.png"));
		menu3.setPressedIcon(new ImageIcon("./img/menu_B/�޴�_over_03.png"));
		menu3.setBorderPainted(false);
		menu3.setContentAreaFilled(false);
		menu3.setFocusPainted(false);
		menu3.setBounds(95, 441 ,239, 86);    
		getContentPane().add(menu3);
		
		JButton menu4=new JButton(new ImageIcon("./img/menu_A/�޴�_04.png"));  
		menu4.setSelectedIcon(new ImageIcon("./img/menu_B/�޴�_over_04.png"));
		menu4.setPressedIcon(new ImageIcon("./img/menu_B/�޴�_over_04.png"));
		menu4.setBorderPainted(false);
		menu4.setContentAreaFilled(false);
		menu4.setFocusPainted(false);
		menu4.setBounds(95, 527, 239, 86);    
		getContentPane().add(menu4);
		
		JButton menu5=new JButton(new ImageIcon("./img/menu_A/�޴�_05.png"));   
		menu5.setSelectedIcon(new ImageIcon("./img/menu_B/�޴�_over_05.png"));
		menu5.setPressedIcon(new ImageIcon("./img/menu_B/�޴�_over_05.png"));
		menu5.setBorderPainted(false);
		menu5.setContentAreaFilled(false);
		menu5.setFocusPainted(false);
		menu5.setBounds(95, 613, 239, 86);    
		getContentPane().add(menu5);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(500,400);
		setSize(1467,902);
		getContentPane().setLayout(null);
		setVisible(true);
		

	
		
		create_serch_button(getContentPane());
		JButton option_btn1 = create_option_button("��������ȣ", 1);
		JButton option_btn2 = create_option_button("��ǰ�ڵ�", 2);
		JButton option_btn3 = create_option_button("�Ǹűݾ�", 3);
		JButton option_btn4 = create_option_button("��������", 4);
		JButton option_btn5 = create_option_button("�ŷ��Ⱓ", 5);
		JButton option_btn6 = create_option_button("���ⱸ��", 6);
		addtalbe(getContentPane());
		addlabel(getContentPane());
		add_Issuance_button(getContentPane());
		add_Resale_button(getContentPane());
		add_Return_button(getContentPane());
		getContentPane().add(option_btn1);
		getContentPane().add(option_btn2);
		getContentPane().add(option_btn3);
		getContentPane().add(option_btn4);
		getContentPane().add(option_btn5);
		getContentPane().add(option_btn6);
	     }
	     
	    public static void addlabel(Container pane) {
	     	JTextArea text_area = new JTextArea(7,20);
	     	text_area.append("asd\n");
	     	text_area.append("asd");
	     	text_area.append("asd");
	     	text_area.append("asd");
	     	text_area.append("asd");
	     	text_area.append("asd");
	     	text_area.append("asd");
	     	text_area.append("asd");
	     	
	    	JScrollPane panel = new JScrollPane(text_area);
	        panel.setBounds(850, 269, 400, 380);   

	        pane.add(panel);
	    }

	     
	    public static void addtalbe(Container pane) {
	    
	    	String [] title = {"����","������","�ݾ�","�ŷ�����"};
	        DefaultTableModel model = new DefaultTableModel(title,0);
	        JTable table = new JTable(model);
	        table.setRowSelectionAllowed(true);
	        
	        EtchedBorder eborder =  new EtchedBorder();   
	        table.setBorder(eborder); 
	        
	    	JScrollPane panel = new JScrollPane(table);
	    	panel.setBounds(420, 269, 400, 380);
	    	
	    	Receipt_Business rb = new Receipt_Business();
	    	ResultSet rs = rb.all_Receipt();
	    	String[] data;
	    	
	    	try {
	    	while(rs.next()) {
	    		data = new String[] {"1","1","1","1"};
	    	//data = new String[]{rs.getString(1), rs.getString(1), rs.getString(1), rs.getString(1)};
	    		model.addRow(data);
	    	}
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	}
	        pane.add(panel);
	        //�޼��� ���� ������ �����ҵ�..
	    } 


	 	public static void create_serch_button(Container pane) {
			ImageIcon icon = new ImageIcon("./image/serch.png");
			JButton btn = new JButton(icon);
			btn.setBackground(Color.white);
			btn.setBounds(1150,100,160,100);
			
			
			pane.add(btn);
		}
	 	
	 	public static JButton create_option_button(String menu, int option_num) {
			JButton btn = new JButton(menu);
			btn.setBackground(Color.gray);
			switch(option_num) {
				case 1:
					btn.setBounds(450, 100, 100, 40);
					break;
				case 2:
					btn.setBounds(565, 100, 100, 40);
					break;
				case 3:
					btn.setBounds(675, 100, 100, 40);
					break;
				case 4:
					btn.setBounds(785, 100, 100, 40);
					break;
				case 5:
					btn.setBounds(895, 100, 100, 40);
					break;
				case 6:
					btn.setBounds(1005, 100, 100, 40);
					break;
			}
			return btn;	
		}
	 	
	    public static void add_Issuance_button(Container pane) {
	    	JButton issuance_btn = new JButton("����������");
	    	issuance_btn.setBounds(550, 720, 200, 65);
	    	pane.add(issuance_btn);
	    }
	    public static void add_Resale_button(Container pane) {
	    	JButton issuance_btn = new JButton("��ǰ���Ǹ�");
	    	issuance_btn.setBounds(770, 720, 200, 65);
	    	pane.add(issuance_btn);
	    }
	    public static void add_Return_button(Container pane) {
	    	JButton issuance_btn = new JButton("��ǰ����");
	    	issuance_btn.setBounds(990, 720, 200, 65);
	    	pane.add(issuance_btn);
	    }
	 	
	public static void main(String[] args) {
		new Receipt_Business_View();
		
	}
}

