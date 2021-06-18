package AnyPlace.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;

public class PaymentManagementMain_View extends JPanel {
	ImageIcon icon;
	JButton �����, ����ֹ�;

	public Dimension getPreferredSize() {
		Dimension largeBtnSz = new Dimension(super.getPreferredSize().width + 30, super.getPreferredSize().height + 30);
		return largeBtnSz;
	}

	public PaymentManagementMain_View() {
		setBackground(Color.WHITE);

		// �� �� ��ư

		����� = new JButton(new ImageIcon("./img/menu_C/�����.png"));
		�����.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				
				Container pmd_panel = new PaymentManagementDisposal_View();
				add(pmd_panel);
				
				updateUI();
			}
		});
		�����.setPressedIcon(new ImageIcon("./img/menu_C/�����_over.png"));
		�����.setBorderPainted(false);
		�����.setContentAreaFilled(false);
		�����.setFocusPainted(false);
		�����.setBounds(250, 175, 249, 348);
		add(�����);

		����ֹ� = new JButton(new ImageIcon("./img/menu_C/����ֹ�.png"));
		����ֹ�.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				
				Container dov_panel = new DeliveryOrder_View();
				add(dov_panel);
				updateUI();
			}
		});
		����ֹ�.setPressedIcon(new ImageIcon("./img/menu_C/����ֹ�_over.png"));
		����ֹ�.setBorderPainted(false);
		����ֹ�.setContentAreaFilled(false);
		����ֹ�.setFocusPainted(false);
		����ֹ�.setBounds(550, 175, 249, 348);
		add(����ֹ�);
		
		setLayout(null);
		setVisible(true);
	}
}
