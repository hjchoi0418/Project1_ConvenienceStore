package AnyPlace.view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;

// 폐기 등록
public class PaymentManagementDisposal_View extends JFrame {
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

	PaymentManagementDisposal_View() {
		getContentPane().setLayout(null);
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
		scroll.setBounds(191, 129, 560, 246);
		getContentPane().add(scroll);

		// textarea
		waste_count = disposalCont.waste_count;
		total_waste_price = disposalCont.total_waste_price;
		JTextArea textArea = new JTextArea("합계수량  " + waste_count + "\t\t폐기 금액 합계  " + total_waste_price);
		textArea.setForeground(Color.ORANGE);
		textArea.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		textArea.setEditable(false);
		textArea.setBackground(new Color(72, 61, 139));
		textArea.setBounds(191, 376, 560, 83);
		getContentPane().add(textArea);

		btnNewButton = new JButton("유통기한 임박 상품 조회");
		btnNewButton.setSelectedIcon(new ImageIcon(PaymentManagementDisposal_View.class
				.getResource("/GUI/page_view/icon/\uC720\uD1B5\uAE30\uD55C\uC870\uD68C\uBC84\uD2BC.png")));
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(407, 469, 191, 57);
		getContentPane().add(btnNewButton);

		button_1 = new JButton("저장");
		button_1.setBackground(new Color(72, 61, 139));
		button_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		button_1.setBounds(640, 469, 112, 57);
		getContentPane().add(button_1);

		JButton btnNewButton_1 = new JButton("폐기 등록");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ssss : " + Arrays.toString(mel.str_arr));
				disposalCont.delData(mel.str_arr);
				dispose();
				new PaymentManagementDisposal_View();
			}
		});
		btnNewButton_1.setBounds(528, 10, 97, 43);
		getContentPane().add(btnNewButton_1);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(850, 600);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new PaymentManagementDisposal_View();
	}

}
