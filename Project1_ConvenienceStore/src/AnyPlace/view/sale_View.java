package AnyPlace.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import AnyPlace.controller.Login;

import java.awt.Font;

public class sale_View extends JFrame {
	ImageIcon icon;
	JTextField search = new JTextField();
	private JTextField search1;
	private JTextField search2;
		

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
	
		JButton 바코드=new JButton(new ImageIcon("./img/재고점검/바코드.png"));
		바코드.setBorderPainted(false);
		바코드.setContentAreaFilled(false);
		바코드.setFocusPainted(false);
		바코드.setBounds(372, 232, 123, 48);    
		getContentPane().add(바코드);
		
		JButton 상품명검색=new JButton(new ImageIcon("./img/재고점검/상품명검색.png"));
		상품명검색.setBorderPainted(false);
		상품명검색.setContentAreaFilled(false);
		상품명검색.setFocusPainted(false);
		상품명검색.setBounds(882, 232, 123, 48);
		getContentPane().add(상품명검색);
		
<<<<<<< HEAD
		JButton 판매보류=new JButton(new ImageIcon("./img/상품판매btn/판매보류.png"));
//		판매보류.setBorderPainted(false);
//		판매보류.setContentAreaFilled(false);
//		판매보류.setFocusPainted(false);
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
=======
		JButton 검색1=new JButton(new ImageIcon("./img/재고점검/검색버튼.png")); 
		검색1.setSelectedIcon(new ImageIcon("./img/재고점검/검색버튼_B.png"));
		검색1.setPressedIcon(new ImageIcon("./img/재고점검/검색버튼_B.png"));
		검색1.setBorderPainted(false);
		검색1.setContentAreaFilled(false);
		검색1.setFocusPainted(false);
		검색1.setBounds(804, 232, 48, 48);
		getContentPane().add(검색1);
>>>>>>> refs/remotes/origin/Wonhyeyoung
		
		
	     
		search1 = new JTextField();
		search1.setToolTipText("스캐닝 또는 코드명을 입력하세요.");
		search1.setHorizontalAlignment(SwingConstants.LEFT);
		search1.setFont(new Font("나눔고딕", Font.BOLD, 15));
		search1.setBounds(372, 232, 480, 48);
		getContentPane().add(search1);
		search1.setColumns(50);
		setVisible(true);
		
		search2 = new JTextField();
		search2.setToolTipText("조회하실 상품명을 입력하세요.");
		search2.setHorizontalAlignment(SwingConstants.LEFT);
		search2.setFont(new Font("나눔고딕", Font.BOLD, 15));
		search2.setBounds(372, 232, 480, 48);
		getContentPane().add(search2);
		search2.setColumns(50);
		setVisible(true);
		
		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//
//			Login login = new Login();
//			JTextField id_input = textField;
//			String id = textField.getText();
//
//			if (id.equals(Login.getID(id))) {
//				JOptionPane.showMessageDialog(null, "You have logged in successfully");
//				new sale_View();
//				setVisible(false);
//			} else {
//				JOptionPane.showMessageDialog(null, "You failed to log In");
//			}
//
//		}
//
//	});
//		

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
		
		
		
		final JTable table = new JTable(new DefaultTableModel(new String[] {
		        "title", "info" }, 3));
		frame.getContentPane().setLayout(
		        new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(table.getTableHeader());
		frame.getContentPane().add(table);
		frame.pack();
		frame.setVisible(true);

		// listener
		table.getTableHeader().addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int col = table.columnAtPoint(e.getPoint());
		        String name = table.getColumnName(col);
		        System.out.println("Column index selected " + col + " " + name);
		    }
		});
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(400,400);
		setSize(1467,902);
		getContentPane().setLayout(null);
		setVisible(true);

	     }

	public static void main(String[] args) {
		new sale_View();
		
	}
}

