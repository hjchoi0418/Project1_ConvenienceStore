package AnyPlace.view.receipt_business_output_view;

import java.awt.Container;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Receipt_issuance_view extends JFrame{
	public JTextArea text;
	public Receipt_issuance_view(){
		
		JFrame frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setLocation(0,0);
		setSize(400,300);
		getContentPane().setLayout(null);
		setVisible(true);
		
		text = new JTextArea();
		text.setBounds(50,50,300,200);
		getContentPane().add(text);

	}
	
	public void set_text (ResultSet rs) {
		try {
			while(rs.next()) {
				
			text.setText("ORDER_NO : " + rs.getString(1) + "\n");
			text.append("ORDER_DATE : " + rs.getString(2) + "\n");
			text.append("PAYMENT_METHOD : " + rs.getString(3) + "\n");
			text.append("ORDER_AMOUNT : " + rs.getString(4) + "\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Receipt_issuance_view();
	}
}
