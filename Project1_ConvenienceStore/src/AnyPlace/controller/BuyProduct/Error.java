package AnyPlace.controller.BuyProduct;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class Error extends JDialog{
	public Error(Window parent) {
		super(parent, "수량 초과", ModalityType.APPLICATION_MODAL);
		setSize(600, 150);
		setLayout(null);
		JLabel lb = new JLabel("주문 수량이 재고 수량보다 많습니다");
		lb.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lb.setBounds(100, 30, 500, 50);
		add(lb);
	}
	

}