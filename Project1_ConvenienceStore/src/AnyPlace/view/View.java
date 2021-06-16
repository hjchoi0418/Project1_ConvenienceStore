package AnyPlace.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class View extends JFrame implements Runnable {
	private JPanel main_panel;
	JButton menu1, menu2, menu3, menu4, menu5, logoutBtn;
	private JLabel time_label, user_label;
	private Thread thread;
	private SimpleDateFormat sf;

	public Dimension getPreferredSize() {
		Dimension largeBtnSz = new Dimension(super.getPreferredSize().width + 30, super.getPreferredSize().height + 30);
		return largeBtnSz;
	}

	public View() {

		setTitle("Any Place");

		getContentPane().setLayout(null);

		try {
			final Image backgroundImage = javax.imageio.ImageIO.read(new File("./img/애니플_보드.jpg"));
			setContentPane(new JPanel(new BorderLayout()) {
				@Override
				public void paintComponent(Graphics g) {
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

		menu1 = new JButton(new ImageIcon("./img/menu_A/메뉴_01.png"));
		menu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 시재점검 버튼
				btnEnable();
				menu1.setEnabled(false);
				main_panel.removeAll();
				
				Cash_Management_view cm_panel = new Cash_Management_view();
				main_panel.add(cm_panel);
				
				main_panel.updateUI();
			}
		});
		menu1.setPressedIcon(new ImageIcon("./img/menu_B/메뉴_over_01.png"));
		menu1.setDisabledIcon(new ImageIcon("./img/menu_B/메뉴_over_01.png"));
		menu1.setBorderPainted(false);
		menu1.setContentAreaFilled(false);
		menu1.setFocusPainted(false);
		menu1.setBounds(95, 269, 239, 86);
		getContentPane().add(menu1);

		menu2 = new JButton(new ImageIcon("./img/menu_A/메뉴_02.png"));
		menu2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 상품판매 버튼
				btnEnable();
				menu2.setEnabled(false);
				main_panel.removeAll();
				
				main_panel.updateUI();
			}
		});
		menu2.setPressedIcon(new ImageIcon("./img/menu_B/메뉴_over_02.png"));
		menu2.setDisabledIcon(new ImageIcon("./img/menu_B/메뉴_over_02.png"));
		menu2.setBorderPainted(false);
		menu2.setContentAreaFilled(false);
		menu2.setFocusPainted(false);
		menu2.setBounds(95, 355, 239, 86);
		getContentPane().add(menu2);

		menu3 = new JButton(new ImageIcon("./img/menu_A/메뉴_03.png"));
		menu3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 영수증업무 버튼
				btnEnable();
				menu3.setEnabled(false);
				main_panel.removeAll();
				
				main_panel.updateUI();
			}
		});
		menu3.setPressedIcon(new ImageIcon("./img/menu_B/메뉴_over_03.png"));
		menu3.setDisabledIcon(new ImageIcon("./img/menu_B/메뉴_over_03.png"));
		menu3.setBorderPainted(false);
		menu3.setContentAreaFilled(false);
		menu3.setFocusPainted(false);
		menu3.setBounds(95, 441, 239, 86);
		getContentPane().add(menu3);

		menu4 = new JButton(new ImageIcon("./img/menu_A/메뉴_04.png"));
		menu4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 수불관리 버튼
				btnEnable();
				menu4.setEnabled(false);
				main_panel.removeAll();
				
				Container pd_panel = new PaymentManagementMain_View();//.getContentPane();
				main_panel.add(pd_panel);
				
				main_panel.updateUI();
			}
		});
		menu4.setPressedIcon(new ImageIcon("./img/menu_B/메뉴_over_04.png"));
		menu4.setDisabledIcon(new ImageIcon("./img/menu_B/메뉴_over_04.png"));
		menu4.setBorderPainted(false);
		menu4.setContentAreaFilled(false);
		menu4.setFocusPainted(false);
		menu4.setBounds(95, 527, 239, 86);
		getContentPane().add(menu4);

		menu5 = new JButton(new ImageIcon("./img/menu_A/메뉴_05.png"));
		menu5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 재고점검 버튼
				btnEnable();
				menu5.setEnabled(false);
				main_panel.removeAll();
				
				main_panel.updateUI();
			}
		});
		menu5.setPressedIcon(new ImageIcon("./img/menu_B/메뉴_over_05.png"));
		menu5.setDisabledIcon(new ImageIcon("./img/menu_B/메뉴_over_05.png"));
		menu5.setBorderPainted(false);
		menu5.setContentAreaFilled(false);
		menu5.setFocusPainted(false);
		menu5.setBounds(95, 613, 239, 86);
		getContentPane().add(menu5);
		
		time_label = new JLabel("time");
		time_label.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		time_label.setBounds(1010, 10, 210, 40);
		getContentPane().add(time_label);
		
		user_label = new JLabel("user님");
		user_label.setHorizontalAlignment(SwingConstants.RIGHT);
		user_label.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		user_label.setBounds(1230, 10, 100, 40);
		getContentPane().add(user_label);
		
		logoutBtn = new JButton();
		logoutBtn.setBounds(1340, 10, 40, 40);
		getContentPane().add(logoutBtn);
		
		main_panel = new JPanel();
		main_panel.setLayout(new GridLayout());
		main_panel.setBounds(350, 100, 1030, 700);
		
		getContentPane().add(main_panel);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(200, 100);
		setSize(1467, 902);
		setResizable(false);
		getContentPane().setLayout(null);
		setVisible(true);
		
		sf = new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss");
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
	}

	public void run() {
		while (true) {
			time_label.setText(sf.format(new Date()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
	
	public void btnEnable() {
		menu1.setEnabled(true);
		menu2.setEnabled(true);
		menu3.setEnabled(true);
		menu4.setEnabled(true);
		menu5.setEnabled(true);
	}

	public static void main(String[] args) {
		new View();
	}
}