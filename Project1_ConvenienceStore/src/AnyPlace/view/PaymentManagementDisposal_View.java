package AnyPlace.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import AnyPlace.controller.DisposalCont;
import AnyPlace.mouseEventListener.DisposalView_MouseEventListener;
import java.awt.FlowLayout;
// 폐기 등록
public class PaymentManagementDisposal_View extends JPanel {
	
	JTable table;
	JScrollPane scroll; // 테이블 위에 열 라벨을 넣어주자~ scroll
	String col_name[] = { "중분류", "상품코드", "상품명", "폐기일시" };
	String data[][];// {{ "1.도시락", "1", "알찬도시락", "1", "06-11 00:00" }};
	DisposalCont disposalCont = new DisposalCont();
	
	int waste_count;
	int total_waste_price;
	private JButton button;
	private JButton btnNewButton;
	private JButton button_1;

	int row;
	DisposalView_MouseEventListener mel = new DisposalView_MouseEventListener(table);
	ImageIcon icon;

	public Dimension getPreferredSize() {
		Dimension largeBtnSz = new Dimension(super.getPreferredSize().width + 30, super.getPreferredSize().height + 30);
		return largeBtnSz;
	}

	public void setTable() {
		// 테이블
//		data = null;
//		data = disposalCont.getData();
//		
//		DefaultTableModel model;
//		model = null;
//		model = new DefaultTableModel(data,col_name) {
//			@Override
//			public boolean isCellEditable(int row, int column) {
//				if(column >= 0) {
//					return false;
//				}else {
//					return true;
//				}
//			}
//		};
//		for(int i=0; i<data.length; i++) {
//			System.out.print("data : " + data[i][1]);
//			System.out.println();
//		}
//		table = null;
//		table = new JTable(model);
////		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // 단일선택
//		table.setRowSelectionAllowed(true);	// 셀 선택되는 색이 .. 
////		table.getTableHeader().setReorderingAllowed(false);
//		table.addMouseListener(new DisposalView_MouseEventListener(table));
////		table.setForeground(new Color(75, 0, 130));
////		table.setBackground(new Color(192, 192, 192));
////		table.setFont(new Font("맑은 고딕", Font.BOLD, 12));
////		table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
//
//		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//		scroll = new JScrollPane(table);
//		scroll.setBounds(500, 220, 760, 350);
//		getContentPane().add(scroll);
	}
	PaymentManagementDisposal_View() {
		
		// 테이블
		data = disposalCont.getData();
		DefaultTableModel model = new DefaultTableModel(data,col_name) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column >= 0) {
					return false;
				}else {
					return true;
				}
			}
		};
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // 단일선택
		table.setRowSelectionAllowed(true);	// 셀 선택되는 색이 .. 
		table.getTableHeader().setReorderingAllowed(false);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		table.addMouseListener(new DisposalView_MouseEventListener(table));
//		table.setForeground(new Color(75, 0, 130));
//		table.setBackground(new Color(192, 192, 192));
//		table.setFont(new Font("맑은 고딕", Font.BOLD, 12));
//		table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scroll = new JScrollPane(table);
		add(scroll);
//
		// textarea
		waste_count = disposalCont.waste_count;
		total_waste_price = disposalCont.total_waste_price;
		JTextArea textArea = new JTextArea("합계수량  " + waste_count + "\t\t폐기 제품 총 원가  " + total_waste_price);
		textArea.setForeground(Color.ORANGE);
		textArea.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		textArea.setEditable(false);
		textArea.setBackground(new Color(72, 61, 139));
		add(textArea);

		JButton btnNewButton_1 = new JButton(new ImageIcon("./img/menu_C/폐기등록2.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ssss : " + Arrays.toString(mel.str_arr));
//				disposalCont.delData(mel.str_arr);
//				dispose();
//				new PaymentManagementDisposal_View();
//				setTable();
				mel.delRecode(model);
			}
		});
		btnNewButton_1.setSelectedIcon(new ImageIcon("./img/menu_C/폐기등록2_over.png"));
		btnNewButton_1.setPressedIcon(new ImageIcon("./img/menu_C/폐기등록2_over.png"));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setFocusPainted(false);
		add(btnNewButton_1);
		setVisible(true);
	}
}
