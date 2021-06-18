package AnyPlace.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import AnyPlace.controller.DisposalCont;
import AnyPlace.mouseEventListener.DisposalView_MouseEventListener;
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

	public PaymentManagementDisposal_View() {
		setBackground(Color.WHITE);

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
		table.getTableHeader().setFont(new Font("나눔고딕", Font.BOLD, 20)); // 컬럼 폰트 
		table.getTableHeader().setBackground(new Color(22,56,81)); 	// 컬럼 배경색
		table.getTableHeader().setForeground(new Color(255,255,255)); // 컬럼 폰트색
		table.getTableHeader().setPreferredSize(new Dimension(0, 60)); // 컬럼 너비, 높이
		table.getTableHeader().setReorderingAllowed(false); // 컬럼 이동 안되게
		
		// 셀들의 글자 가운데 정렬 
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		for(int i=0; i<table.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
//			tcm.getColumn(i).set
		}
		table.setRowHeight(40);  // 행 높이
		table.setFont(new Font("나눔고딕", Font.BOLD, 15)); // 행 폰트
		table.setBackground(new Color(198,198,198)); // 행 배경색
 		table.setForeground(new Color(22,56,81)); // 행 폰트색
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // 단일선택
		table.setRowSelectionAllowed(true);	// 셀 선택되는 색이 .. 
		table.addMouseListener(new DisposalView_MouseEventListener(table));

		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scroll = new JScrollPane(table);
		scroll.setBounds(0, 20, 851, 392);
		add(scroll);
//
		// textarea
		waste_count = disposalCont.waste_count;
		total_waste_price = disposalCont.total_waste_price;
		JTextArea textArea = new JTextArea("합계수량  "); //+ waste_count + "\t\t폐기 제품 총 원가  " + total_waste_price);
		textArea.setForeground(Color.ORANGE);
		textArea.setFont(new Font("나눔고딕", Font.BOLD, 30));
		textArea.setEditable(false);
		textArea.setBackground(new Color(22, 56, 81));
		textArea.setBounds(0, 416, 200 ,91);
		add(textArea);
		
		JTextArea textArea_1 = new JTextArea(""+waste_count);
		textArea_1.setForeground(new Color(255,255,255));
		textArea_1.setFont(new Font("나눔고딕", Font.BOLD, 30));
		textArea_1.setEditable(false);
		textArea_1.setBackground(new Color(22, 56, 81));
		textArea_1.setBounds(200, 416, 274, 91);
		add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea("합계 금액");
		textArea_2.setForeground(new Color(254, 182, 63));
		textArea_2.setFont(new Font("나눔고딕", Font.BOLD, 30));
		textArea_2.setEditable(false);
		textArea_2.setBackground(new Color(22, 56, 81));
		textArea_2.setBounds(474, 416, 206, 91);
		add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea(Integer.toString(total_waste_price));
		textArea_3.setForeground(Color.WHITE);
		textArea_3.setFont(new Font("나눔고딕", Font.BOLD, 30));
		textArea_3.setEditable(false);
		textArea_3.setBackground(new Color(22, 56, 81));
		textArea_3.setBounds(679, 416, 172, 91);
		add(textArea_3);
		
		
		JButton btnNewButton_1 = new JButton(new ImageIcon("./img/menu_C/폐기등록2.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ssss : " + Arrays.toString(mel.str_arr));
//				disposalCont.delData(mel.str_arr);
//				dispose();
//				new PaymentManagementDisposal_View();
//				setTable();
//				waste_count = disposalCont.waste_count;
//				total_waste_price = disposalCont.total_waste_price;
				
//				waste_count = mel.
				
//				System.out.println("waste : " + waste_count);
//				System.out.println("total_pri : " + total_waste_price);
				
				mel.delRecode(model);
//				mel.delData(table);
				disposalCont.delData(mel.str_arr);
				HashMap<String,String> temp_map = new HashMap<>();
				temp_map = disposalCont.getCountCost();
				
				String wcnt = "";
				String wtotal = "";
				for(String key : temp_map.keySet()) {
					wcnt = key;
					wtotal = temp_map.get(key);
				}
				System.out.println(wcnt);
				System.out.println(wtotal);

				textArea_1.setText(wcnt);
				textArea_3.setText(wtotal);
			}
		});
		btnNewButton_1.setSelectedIcon(new ImageIcon("./img/menu_C/폐기등록2_over.png"));
		btnNewButton_1.setPressedIcon(new ImageIcon("./img/menu_C/폐기등록2_over.png"));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBounds(701, 513, 150, 68);
		add(btnNewButton_1);

		setLocation(70, 50);
		setSize(1467, 902);
//		getContentPane().setLayout(null);
		setLayout(null);
		setVisible(true);

	}
}
