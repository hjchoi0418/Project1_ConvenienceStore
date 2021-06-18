package AnyPlace.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import AnyPlace.controller.Login;
import AnyPlace.model.Employee;


public class Login_View extends JFrame implements ActionListener{
	
	Login login=new Login();
	ImageIcon icon;
	JTextField id_field = new JTextField();
	private JTextField textField;
	public static Employee emp = new Employee();

	public Dimension getPreferredSize(){
        Dimension largeBtnSz = new Dimension(super.getPreferredSize().width+30, super.getPreferredSize().height+30);
        return largeBtnSz;
	}

	public Login_View() {

		setTitle("Any Place");

		getContentPane().setLayout(null);

		try {
			final Image backgroundImage = javax.imageio.ImageIO.read(new File("./img/·Î±×ÀÎ_¹è°æ.jpg"));
			setContentPane(new JPanel(new BorderLayout()) {
				@Override
				public void paintComponent(Graphics g) {
					g.drawImage(backgroundImage, 0, 0, null);
					setOpaque(false);
					super.paintComponent(g);
				}
			});
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		JFrame frame = new JFrame();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(200,100);
		setSize(1467,902);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setToolTipText("ID");
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		textField.setBounds(557, 421, 353, 55);
		getContentPane().add(textField);
		textField.setColumns(10);
		setVisible(true);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(255, 204, 51));
		btnNewButton.setFocusPainted(false);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Login login = new Login();
				JTextField id_input = textField;
				String id = textField.getText();

				if (id.equals(Login.getID(id))) {
					JOptionPane.showMessageDialog(null, "You have logged in successfully");
					emp = new Employee();
					emp.setEmployee_id(id);
					new View();
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "You failed to log In");
				}

			}

		});
		btnNewButton.setBounds(557, 498, 353, 55);
		getContentPane().add(btnNewButton);

		JButton joinButton = new JButton("join");
		// joinButton.setIcon(new ImageIcon("./img/°¡ÀÔ¹öÆ°.jpg"));
		// joinButton.setSelectedIcon(new ImageIcon("./img/°¡ÀÔ¹öÆ°.jpg"));
		joinButton.setForeground(new Color(255, 204, 51));
		joinButton.setFont(new Font("³ª´®°íµñ", Font.PLAIN, 12));
		joinButton.setBorderPainted(false);
//		joinButton.setContentAreaFilled(false);
		joinButton.setFocusPainted(false);

		joinButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Join_View();
				dispose();
			}
		});

		joinButton.setBounds(833, 570, 74, 58);
		getContentPane().add(joinButton);

		//
		joinButton.addActionListener(this);
		btnNewButton.addActionListener(this);

	}

	public static void main(String[] args) throws Exception {
		new Login_View();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
