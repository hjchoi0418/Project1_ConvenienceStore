package AnyPlace.controller.BuyProduct;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class Complete extends JDialog{
	public Complete(Window parent) {
		super(parent, "���� �Ϸ�", ModalityType.APPLICATION_MODAL);
		setSize(600, 150);
		setLayout(null);
		JLabel lb = new JLabel("���� �Ϸ�!");
		lb.setFont(new Font("���� ���", Font.PLAIN, 20));
		lb.setBounds(100, 30, 200, 50);
		add(lb);
	}

}