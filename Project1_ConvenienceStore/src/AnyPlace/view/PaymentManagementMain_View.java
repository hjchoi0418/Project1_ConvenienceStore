package AnyPlace.view;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

public class PaymentManagementMain_View extends JFrame {
	ImageIcon icon;

	public Dimension getPreferredSize() {
		Dimension largeBtnSz = new Dimension(super.getPreferredSize().width + 30, super.getPreferredSize().height + 30);
		return largeBtnSz;
	}

	public PaymentManagementMain_View() {

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

		JButton menu1 = new JButton();
		menu1.setIcon(new ImageIcon("./img/menu_A/메뉴_01.png"));
		menu1.setSelectedIcon(new ImageIcon("./img/menu_B/메뉴_over_01.png"));
		menu1.setPressedIcon(new ImageIcon("./img/menu_B/메뉴_over_01.png"));
		menu1.setBorderPainted(false);
		menu1.setContentAreaFilled(false);
		menu1.setFocusPainted(false);
		menu1.setBounds(95, 269, 239, 86);
		getContentPane().add(menu1);

		JButton menu2 = new JButton(new ImageIcon("./img/menu_A/메뉴_02.png"));
		menu2.setSelectedIcon(new ImageIcon("./img/menu_B/메뉴_over_02.png"));
		menu2.setPressedIcon(new ImageIcon("./img/menu_B/메뉴_over_02.png"));
		menu2.setBorderPainted(false);
		menu2.setContentAreaFilled(false);
		menu2.setFocusPainted(false);
		menu2.setBounds(95, 355, 239, 86);
		getContentPane().add(menu2);

		JButton menu3 = new JButton(new ImageIcon("./img/menu_A/메뉴_03.png"));
		menu3.setSelectedIcon(new ImageIcon("./img/menu_B/메뉴_over_03.png"));
		menu3.setPressedIcon(new ImageIcon("./img/menu_B/메뉴_over_03.png"));
		menu3.setBorderPainted(false);
		menu3.setContentAreaFilled(false);
		menu3.setFocusPainted(false);
		menu3.setBounds(95, 441, 239, 86);
		getContentPane().add(menu3);

		JButton menu4 = new JButton(new ImageIcon("./img/menu_B/메뉴_over_04.png"));
		menu4.setSelectedIcon(new ImageIcon("./img/menu_B/메뉴_over_04.png"));
		menu4.setPressedIcon(new ImageIcon("./img/menu_B/메뉴_over_04.png"));
		menu4.setBorderPainted(false);
		menu4.setContentAreaFilled(false);
		menu4.setFocusPainted(false);
		menu4.setBounds(95, 527, 239, 86);
		getContentPane().add(menu4);

		JButton menu5 = new JButton(new ImageIcon("./img/menu_A/메뉴_05.png"));
		menu5.setSelectedIcon(new ImageIcon("./img/menu_B/메뉴_over_05.png"));
		menu5.setPressedIcon(new ImageIcon("./img/menu_B/메뉴_over_05.png"));
		menu5.setBorderPainted(false);
		menu5.setContentAreaFilled(false);
		menu5.setFocusPainted(false);
		menu5.setBounds(95, 613, 239, 86);
		getContentPane().add(menu5);

		// 그 외 버튼

		JButton 폐기등록 = new JButton(new ImageIcon("./img/menu_C/폐기등록.png"));
		폐기등록.setPressedIcon(new ImageIcon("./img/menu_C/폐기등록_over.png"));
		폐기등록.setBorderPainted(false);
		폐기등록.setContentAreaFilled(false);
		폐기등록.setFocusPainted(false);
		폐기등록.setBounds(450, 230, 249, 348);
		getContentPane().add(폐기등록);

		JButton 배송주문 = new JButton(new ImageIcon("./img/menu_C/배송주문.png"));
		배송주문.setPressedIcon(new ImageIcon("./img/menu_C/배송주문_over.png"));
		배송주문.setBorderPainted(false);
		배송주문.setContentAreaFilled(false);
		배송주문.setFocusPainted(false);
		배송주문.setBounds(750, 230, 249, 348);
		getContentPane().add(배송주문);



		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(370, 50);
		setSize(1467, 902);
		getContentPane().setLayout(null);
		setVisible(true);

	}

	public static void main(String[] args) {
		new PaymentManagementMain_View();
	}
}
