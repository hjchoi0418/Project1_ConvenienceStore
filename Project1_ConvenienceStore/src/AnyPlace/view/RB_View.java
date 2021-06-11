package AnyPlace.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class RB_View {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RB_View window = new RB_View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RB_View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel side_panel = new JPanel();
		side_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.getContentPane().add(side_panel, BorderLayout.WEST);
		side_panel.setLayout(new GridLayout(8, 0, 0, 0));
		
		JPanel panel = new JPanel();
		side_panel.add(panel);
		
		JPanel panel_1 = new JPanel();
		side_panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		side_panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		side_panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		side_panel.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		side_panel.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		side_panel.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		side_panel.add(panel_7);
		
		JPanel main_panel = new JPanel();
		frame.getContentPane().add(main_panel, BorderLayout.CENTER);
		main_panel.setLayout(new BorderLayout(0, 0));
		
		JPanel top_panel = new JPanel();
		top_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		main_panel.add(top_panel, BorderLayout.NORTH);
		top_panel.setLayout(new GridLayout(0, 7, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("\uB9E4\uCD9C\uAD6C\uBD84");
		top_panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uAC70\uB798\uAE30\uAC04");
		top_panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uACB0\uC81C\uC218\uB2E8");
		top_panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uD310\uB9E4\uAE08\uC561");
		top_panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\uC0C1\uD488\uCF54\uB4DC");
		top_panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\uC601\uC218\uC99D\uBC88\uD638");
		top_panel.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("\uC870\uD68C");
		top_panel.add(btnNewButton);
		
		JPanel bottom_panel = new JPanel();
		bottom_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		main_panel.add(bottom_panel, BorderLayout.SOUTH);
		bottom_panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton print_btn = new JButton("\uC601\uC218\uC99D\uBC1C\uD589");
		bottom_panel.add(print_btn);
		
		JButton immediate_return_btn = new JButton("\uC989\uC2DC\uBC18\uD488");
		bottom_panel.add(immediate_return_btn);
		
		JButton resale_btn = new JButton("\uBC18\uD488\uC7AC\uD310\uB9E4");
		bottom_panel.add(resale_btn);
		
		JPanel center_panel = new JPanel();
		main_panel.add(center_panel, BorderLayout.CENTER);
		center_panel.setLayout(new BorderLayout(0, 0));
		
		JPanel checkbox_panel = new JPanel();
		center_panel.add(checkbox_panel, BorderLayout.SOUTH);
		
		JPanel receipt_panel = new JPanel();
		center_panel.add(receipt_panel, BorderLayout.CENTER);
		receipt_panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JScrollPane left_scrollPane = new JScrollPane();
		receipt_panel.add(left_scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\uC77C\uC790", "\uC601\uC218\uC99D", "\uC2DC\uAC04", "\uAE08\uC561", "\uAC70\uB798\uAD6C\uBD84"
			}
		));
		left_scrollPane.setViewportView(table);
		
		JScrollPane right_scrollPane = new JScrollPane();
		right_scrollPane.setViewportBorder(new EmptyBorder(5, 5, 5, 5));
		receipt_panel.add(right_scrollPane);
		
		JLabel lblNewLabel = new JLabel("\uC601\uC218\uC99D \uB0B4\uC6A9");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		right_scrollPane.setViewportView(lblNewLabel);
	}

}
