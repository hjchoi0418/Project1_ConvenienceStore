package AnyPlace.view;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Login_View extends JFrame {

	public Login_View() {
		setLayout(null);
		
		ArrayList<JButton> btns = new ArrayList<>();
		
//		btns.add(new Login_View(100, 100));
//
//		JButton loginBtn = new JButton(100, 300, btns);
		
		for (JButton btn : btns) {
			add(btn);
		}
//		add(loginBtn);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(1300,700);
		setSize(1467,902);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Login_View();
	}
}