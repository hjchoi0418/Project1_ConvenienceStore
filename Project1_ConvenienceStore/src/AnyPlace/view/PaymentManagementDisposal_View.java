package AnyPlace.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import AnyPlace.controller.DisposalCont;
import AnyPlace.mouseEventListener.DisposalView_MouseEventListener;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;

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
		table.addMouseListener(new DisposalView_MouseEventListener(table));
//		table.setForeground(new Color(75, 0, 130));
//		table.setBackground(new Color(192, 192, 192));
//		table.setFont(new Font("맑은 고딕", Font.BOLD, 12));
//		table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scroll = new JScrollPane(table);
		scroll.setBounds(500, 220, 760, 350);
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
		textArea.setBounds(500, 570, 560 ,46);
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
		btnNewButton_1.setBounds(1100, 570, 200, 46);
		add(btnNewButton_1);
//		button_1 = new JButton("저장");
//		button_1.setBackground(new Color(72, 61, 139));
//		button_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
//		button_1.setBounds(640, 469, 112, 57);
//		getContentPane().add(button_1);
		
//		btnNewButton = new JButton("유통기한 임박 상품 조회");
//		btnNewButton.setSelectedIcon(new ImageIcon(PaymentManagementDisposal_View.class
//				.getResource("/GUI/page_view/icon/\uC720\uD1B5\uAE30\uD55C\uC870\uD68C\uBC84\uD2BC.png")));
//		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
//		btnNewButton.setBackground(new Color(255, 165, 0));
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btnNewButton.setBounds(407, 469, 191, 57);
//		getContentPane().add(btnNewButton);

		setLocation(370, 50);
		setSize(1467, 902);
		setLayout(null);
		setVisible(true);
	}
}
