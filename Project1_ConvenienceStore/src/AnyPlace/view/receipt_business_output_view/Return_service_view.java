package AnyPlace.view.receipt_business_output_view;

import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Return_service_view extends JFrame{
	
	JFrame frame = new JFrame(); 
	
	public Return_service_view() {
		setTitle("Any Place");
	   	getContentPane().setLayout(null);
	   	
	   	try {	
			Image backgroundImage = javax.imageio.ImageIO.read(new File("./img/애니플_보드.jpg"));
		    setContentPane(
		    		new JPanel() {
		    			@Override 
		    			public void paintComponent(Graphics g) {
		    				g.drawImage(backgroundImage, 0, 0, null);

		    			}
		    		});
			} catch (IOException e) {
			    throw new RuntimeException(e);
			}
	   	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(0,0);
		setSize(1467,902);
		getContentPane().setLayout(null);
		setVisible(true);
 
	   	
	   	
	   	JLabel label = new JLabel("삭제완료");
	   	label.setBounds(700,300,200,200);
	   	getContentPane().add(label);
	   	Font font = new Font("맑은 고딕", Font.BOLD, 40);
	   	label.setFont(font);
	   	
	}
	
	public static Container get_Container(JFrame frame) {
		
		return frame.getContentPane();
	}
	public static void main(String[] args) {
		Return_service_view rsv = new Return_service_view();
	}
}
