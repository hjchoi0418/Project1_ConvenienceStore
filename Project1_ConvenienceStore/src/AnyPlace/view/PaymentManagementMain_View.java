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

		// �� �� ��ư

		JButton ����� = new JButton(new ImageIcon("./img/menu_C/�����.png"));
		�����.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getParent().removeAll();
				
				PaymentManagementDisposal_View pmd_panel = new PaymentManagementDisposal_View();
				getParent().add(pmd_panel);
				
				getRootPane().updateUI();
			}
		});
		�����.setPressedIcon(new ImageIcon("./img/menu_C/�����_over.png"));
		�����.setBorderPainted(false);
		�����.setContentAreaFilled(false);
		�����.setFocusPainted(false);
		�����.setBounds(250, 175, 249, 348);
		add(�����);

		JButton ����ֹ� = new JButton(new ImageIcon("./img/menu_C/����ֹ�.png"));
		����ֹ�.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		����ֹ�.setPressedIcon(new ImageIcon("./img/menu_C/����ֹ�_over.png"));
		����ֹ�.setBorderPainted(false);
		����ֹ�.setContentAreaFilled(false);
		����ֹ�.setFocusPainted(false);
		����ֹ�.setBounds(550, 175, 249, 348);
		this.add(����ֹ�);
		
		setSize(1467, 902);
		setLayout(null);
		setVisible(true);
	}
}
