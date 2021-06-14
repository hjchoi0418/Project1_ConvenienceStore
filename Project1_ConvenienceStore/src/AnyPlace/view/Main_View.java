package AnyPlace.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import AnyPlace.controller.Cash_Management;

public class Main_View extends JFrame implements Runnable, TableModelListener {

	private JFrame frame;
	private JTable table;
	private JLabel time_label;
	private Thread thread;
	private SimpleDateFormat sf;
	
	// 표 제목줄
		String[] colNames = new String[] { "권종", "수량", "금액" };
		// 표에 들어갈 데이터들 / 처음엔 빈 테이블 만들기 위해 데이터관리객체 생성
		private Object[][] data = {
				{"50,000원", 0, 0},
	        	{"10,000원", 0, 0},
	        	{"5,000원", 0, 0},
	        	{"1,000원", 0, 0},
	        	{"500원", 0, 0},
	        	{"100원", 0, 0},
	        	{"50원", 0, 0},
	        	{"10원", 0, 0},
	        };
	private String[] columnType = { "권종", "수량", "금액" };
	DefaultTableModel model = new DefaultTableModel(data, columnType) {
		Class[] columnTypes = new Class[] { String.class, Integer.class, Integer.class };

		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}

		boolean[] columnEditables = new boolean[] { false, true, false };

		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
	};
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_View window = new Main_View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main_View() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel side_panel = new JPanel();
		side_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.getContentPane().add(side_panel, BorderLayout.WEST);
		side_panel.setLayout(new GridLayout(8, 0, 0, 0));
		
		JPanel anyPlace_panel = new JPanel();
		side_panel.add(anyPlace_panel);
		anyPlace_panel.setLayout(new BorderLayout(0, 0));
		
		JLabel anyplace_label = new JLabel("Any Place");
		anyplace_label.setHorizontalAlignment(SwingConstants.CENTER);
		anyPlace_panel.add(anyplace_label);
		
		JPanel panel_1 = new JPanel();
		side_panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		side_panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		side_panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		side_panel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		side_panel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		side_panel.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new EmptyBorder(0, 5, 0, 5));
		side_panel.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("2021 all rights reserved");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblNewLabel_1);
		
		JPanel main_panel = new JPanel();
		frame.getContentPane().add(main_panel, BorderLayout.CENTER);
		main_panel.setLayout(new BorderLayout(0, 0));
		
		JPanel top_panel = new JPanel();
		top_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		main_panel.add(top_panel, BorderLayout.NORTH);
		top_panel.setLayout(new GridLayout(0, 7, 0, 0));
		
		JLabel lblPos = new JLabel("POS 현금");
		top_panel.add(lblPos);
		
		JPanel bottom_panel = new JPanel();
		bottom_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		main_panel.add(bottom_panel, BorderLayout.SOUTH);
		bottom_panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel space_panel = new JPanel();
		bottom_panel.add(space_panel);
		
		JButton print_btn = new JButton("\uBC1C\uD589");
		bottom_panel.add(print_btn);
		
		print_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Cash_Management.main(null);
			}
		});
		
		JPanel center_panel = new JPanel();
		main_panel.add(center_panel, BorderLayout.CENTER);
		center_panel.setLayout(new BorderLayout(0, 0));
		
		JPanel receipt_panel = new JPanel();
		center_panel.add(receipt_panel, BorderLayout.CENTER);
		receipt_panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JScrollPane left_scrollPane = new JScrollPane();
		receipt_panel.add(left_scrollPane);
		
		table = new JTable(model);
		table.setRowHeight(43);
		left_scrollPane.setViewportView(table);
		table.getModel().addTableModelListener(this);
		
		JScrollPane right_scrollPane = new JScrollPane();
		right_scrollPane.setViewportBorder(new EmptyBorder(5, 5, 5, 5));
		receipt_panel.add(right_scrollPane);
		
		JLabel receipt_label = new JLabel("\uC0C1\uD488\uAD8C");
		receipt_label.setHorizontalAlignment(SwingConstants.CENTER);
		right_scrollPane.setViewportView(receipt_label);
		
		JPanel user_panel = new JPanel();
		frame.getContentPane().add(user_panel, BorderLayout.NORTH);
		user_panel.setLayout(new BorderLayout(0, 0));
		
		time_label = new JLabel("user");
		time_label.setHorizontalAlignment(SwingConstants.RIGHT);
		user_panel.add(time_label);
		
		JButton logout_btn = new JButton("logout");
		user_panel.add(logout_btn, BorderLayout.EAST);
		
		// 시계
        sf = new SimpleDateFormat("yyyy년MM월dd일 a hh:mm:ss");
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		
		int row = e.getFirstRow();
        int column = e.getColumn();
		String str;

		if (column == 1) { // "수량" 컬럼
			TableModel model = (TableModel) e.getSource();
			String colName = model.getColumnName(column);
			int amount = (int) model.getValueAt(row, column);

			if (amount < 0) { // 입력한 수량 값이 0 미만인 경우 경고창을 띄운다.
				JOptionPane.showMessageDialog(this, "수량을 0 이상으로 설정해주세요.", "경고", JOptionPane.WARNING_MESSAGE);
				model.setValueAt(0, row, column);
				amount = 0;
			}
			
			switch (row) {
			case 0:
				model.setValueAt(50000 * amount, row, column + 1);
				break;
			case 1:
				model.setValueAt(10000 * amount, row, column + 1);
				break;
			case 2:
				model.setValueAt(5000 * amount, row, column + 1);
				break;
			case 3:
				model.setValueAt(1000 * amount, row, column + 1);
				break;
			case 4:
				model.setValueAt(500 * amount, row, column + 1);
				break;
			case 5:
				model.setValueAt(100 * amount, row, column + 1);
				break;
			case 6:
				model.setValueAt(50 * amount, row, column + 1);
				break;
			case 7:
				model.setValueAt(10 * amount, row, column + 1);
				break;
			}
		}
	}
	
	public void run() {
		while (true) {
			time_label.setText(sf.format(new Date()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
}
