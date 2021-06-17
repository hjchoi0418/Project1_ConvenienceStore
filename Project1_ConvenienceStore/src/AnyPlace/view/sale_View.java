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

	// �� �� ��ư
		
		JButton ��ȸ����=new JButton(new ImageIcon("./img/��ǰ�Ǹ�btn/��ȸ����.png"));
		��ȸ����.setBorderPainted(false);
		��ȸ����.setContentAreaFilled(false);
		��ȸ����.setFocusPainted(false);
		��ȸ����.setBounds(1067, 88, 121, 46);    
		getContentPane().add(��ȸ����);
		
		JButton �Ǹź���=new JButton(new ImageIcon("./img/��ǰ�Ǹ�btn/�Ǹź���.png"));
		�Ǹź���.setBorderPainted(false);
		�Ǹź���.setContentAreaFilled(false);
		�Ǹź���.setFocusPainted(false);
		�Ǹź���.setBounds(1196, 88, 121, 46);    
		getContentPane().add(�Ǹź���);
		
		JButton ���ݰ���=new JButton(new ImageIcon("./img/��ǰ�Ǹ�btn/���ݰ���.png"));
		���ݰ���.setBorderPainted(false);
		���ݰ���.setContentAreaFilled(false);
		���ݰ���.setFocusPainted(false);
		���ݰ���.setBounds(980, 740, 179, 68);    
		getContentPane().add(���ݰ���);
		
		JButton ī�����=new JButton(new ImageIcon("./img/��ǰ�Ǹ�btn/ī�����.png"));
		ī�����.setBorderPainted(false);
		ī�����.setContentAreaFilled(false);
		ī�����.setFocusPainted(false);
		ī�����.setBounds(1181, 740, 179, 68);
		getContentPane().add(ī�����);
		

		JButton �˻�2=new JButton(new ImageIcon("./img/�������/�˻���ư.png"));
		�˻�2.setSelectedIcon(new ImageIcon("./img/�������/�˻���ư_B.png"));
		�˻�2.setPressedIcon(new ImageIcon("./img/�������/�˻���ư_B.png"));
		�˻�2.setBorderPainted(false);
		�˻�2.setContentAreaFilled(false);
		�˻�2.setFocusPainted(false);
		�˻�2.setBounds(1313, 232, 48, 48);
		getContentPane().add(�˻�2);
		
	
		JLabel label1 = new JLabel("�� ������ : �����濵�ý��� ������ �޴����� ��ȸ�ϴ� ���������� �������� �ݿ����� ���� ��������� ������ �Ǵ� ���");
		label1.setFont(new Font("�������", Font.BOLD, 12));
		label1.setForeground(new Color(22, 56, 81));
		JLabel label2 = new JLabel("�� ������� : �����濵�ý��� ����ȭ�鿡�� ��ȸ�Ǵ� ���������� �������� �԰��������� �ݿ��� ���");
		label2.setFont(new Font("�������", Font.BOLD, 12));
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

