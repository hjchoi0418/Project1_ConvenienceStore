package AnyPlace.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
		
		
		// ���̺�
		
		String colNames[] = {"No.", "��ǰ��", "����", "�ݾ׷�", "���", ""};
		DefaultTableModel saleModel = new DefaultTableModel(colNames, 0);
		
//		table = new JTable(model);
//		table.addMouseListner(new JTableMouseLisstner());
//		scrollPane = new JScrollPane(table);
//		scrollPane.setSize(500, 200);
//		add(scrollPane);
//		initilize();
		
		
//		JTable table = new JTable(contents, header);
//        //table.setLocation(0,0);
//
//        JScrollPane jscp1 = new JScrollPane(table); //�̷������� �����ÿ� ���̺��� �Ѱ��־�� ���������� �� �� �ִ�.
//                                                    //jscp1.add(table); �� ���� �����ϸ�, ���������� ��µ��� ����.
//        jscp1.setLocation(0,0);
//        jscp1.setSize(300,160);
//
//        frame.add(jscp1);
		
		
		
		
		
		
		
	//	graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
		
		
		
		
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
