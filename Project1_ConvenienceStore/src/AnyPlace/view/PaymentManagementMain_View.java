package AnyPlace.view;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class PaymentManagementMain_View extends JFrame{
	public PaymentManagementMain_View() {
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("폐기등록");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new PaymentManagementDisposal_View();
			}
		});
		btnNewButton.setBounds(248, 91, 106, 166);
		getContentPane().add(btnNewButton);
		
		JButton button = new JButton("배송주문");
		button.setBounds(413, 91, 106, 166);
		getContentPane().add(button);
		
		setSize(800, 600);
		setVisible(true);
	}
	public static void main(String[] args) {
		new PaymentManagementMain_View();
	}
}
