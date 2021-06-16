package AnyPlace.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PaymentManagementMain_View extends JPanel {
	ImageIcon icon;

	public Dimension getPreferredSize() {
		Dimension largeBtnSz = new Dimension(super.getPreferredSize().width + 30, super.getPreferredSize().height + 30);
		return largeBtnSz;
	}

	public PaymentManagementMain_View() {

		// 그 외 버튼

		JButton 폐기등록 = new JButton(new ImageIcon("./img/menu_C/폐기등록.png"));
		폐기등록.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getParent().removeAll();
				
				PaymentManagementDisposal_View pmd_panel = new PaymentManagementDisposal_View();
				getParent().add(pmd_panel);
				
				getRootPane().updateUI();
			}
		});
		폐기등록.setPressedIcon(new ImageIcon("./img/menu_C/폐기등록_over.png"));
		폐기등록.setBorderPainted(false);
		폐기등록.setContentAreaFilled(false);
		폐기등록.setFocusPainted(false);
		폐기등록.setBounds(250, 175, 249, 348);
		add(폐기등록);

		JButton 배송주문 = new JButton(new ImageIcon("./img/menu_C/배송주문.png"));
		배송주문.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		배송주문.setPressedIcon(new ImageIcon("./img/menu_C/배송주문_over.png"));
		배송주문.setBorderPainted(false);
		배송주문.setContentAreaFilled(false);
		배송주문.setFocusPainted(false);
		배송주문.setBounds(550, 175, 249, 348);
		this.add(배송주문);
		
		setSize(1467, 902);
		setLayout(null);
		setVisible(true);
	}
}
