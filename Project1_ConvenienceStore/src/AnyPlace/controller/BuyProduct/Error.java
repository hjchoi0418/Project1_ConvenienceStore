package AnyPlace.controller.BuyProduct;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class Error extends JDialog{
	public Error(Window parent) {
		super(parent, "���� �ʰ�", ModalityType.APPLICATION_MODAL);
		setSize(600, 150);
		setLayout(null);
		JLabel lb = new JLabel("�ֹ� ������ ��� �������� �����ϴ�");
		lb.setFont(new Font("���� ���", Font.PLAIN, 20));
		lb.setBounds(100, 30, 500, 50);
		add(lb);
	}
	

}