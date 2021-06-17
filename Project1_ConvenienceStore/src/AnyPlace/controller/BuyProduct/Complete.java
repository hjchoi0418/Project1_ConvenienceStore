package AnyPlace.controller.BuyProduct;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class Complete extends JDialog{
	public Complete(Window parent) {
		super(parent, "결제 완료", ModalityType.APPLICATION_MODAL);
		setSize(600, 150);
		setLayout(null);
		JLabel lb = new JLabel("결제 완료!");
		lb.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lb.setBounds(100, 30, 200, 50);
		add(lb);
	}

}