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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import AnyPlace.controller.DisposalCont;
import AnyPlace.mouseEventListener.DeliveryView_MouseEventListener;
import AnyPlace.mouseEventListener.DisposalView_MouseEventListener;
import java.awt.FlowLayout;
// ��� ���
public class PaymentManagementDisposal_View extends JPanel {
	
	JTable table;
	JScrollPane scroll; // ���̺� ���� �� ���� �־�����~ scroll
	String col_name[] = { "�ߺз�", "��ǰ�ڵ�", "��ǰ��", "����Ͻ�" };
	String data[][];// {{ "1.���ö�", "1", "�������ö�", "1", "06-11 00:00" }};
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
		// ���̺�
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
////		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // ���ϼ���
//		table.setRowSelectionAllowed(true);	// �� ���õǴ� ���� .. 
////		table.getTableHeader().setReorderingAllowed(false);
//		table.addMouseListener(new DisposalView_MouseEventListener(table));
////		table.setForeground(new Color(75, 0, 130));
////		table.setBackground(new Color(192, 192, 192));
////		table.setFont(new Font("���� ���", Font.BOLD, 12));
////		table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
//
//		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//		scroll = new JScrollPane(table);
//		scroll.setBounds(500, 220, 760, 350);
//		getContentPane().add(scroll);
	}
	PaymentManagementDisposal_View() {
		setBackground(Color.WHITE);
		
		// ���̺�
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
		table.getTableHeader().setFont(new Font("�������", Font.BOLD, 20)); // �÷� ��Ʈ 
		table.getTableHeader().setBackground(new Color(22,56,81)); 	// �÷� ����
		table.getTableHeader().setForeground(new Color(255,255,255)); // �÷� ��Ʈ��
		table.getTableHeader().setPreferredSize(new Dimension(0, 60)); // �÷� �ʺ�, ����
		table.getTableHeader().setReorderingAllowed(false); // �÷� �̵� �ȵǰ�
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // ���ϼ���
		table.setRowSelectionAllowed(true);	// �� ���õǴ� ���� .. 
		table.getTableHeader().setReorderingAllowed(false);
		setLayout(null);
		table.addMouseListener(new DisposalView_MouseEventListener(table));
//		table.setForeground(new Color(75, 0, 130));
//		table.setBackground(new Color(192, 192, 192));
//		table.setFont(new Font("���� ���", Font.BOLD, 12));
//		table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		for(int i=0; i<table.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
//			tcm.getColumn(i).set
		}
		table.setRowHeight(40);  // �� ����
		table.setFont(new Font("�������", Font.BOLD, 15)); // �� ��Ʈ
		table.setBackground(new Color(198,198,198)); // �� ����
 		table.setForeground(new Color(22,56,81)); // �� ��Ʈ��
		table.setRowSelectionAllowed(true); // �� ���õǴ� ���� ..
		table.addMouseListener(new DeliveryView_MouseEventListener(table));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scroll = new JScrollPane(table);
		scroll.setBounds(0, 0, 851, 392);
		add(scroll);
//
		// textarea
		waste_count = disposalCont.waste_count;
		total_waste_price = disposalCont.total_waste_price;
		JTextArea textArea = new JTextArea("�հ� ���� : " + waste_count + "\t\t�����ǰ �� ���� : " + total_waste_price);
		textArea.setBounds(-2, 438, 851, 91);
		textArea.setForeground(new Color(254,182,63));
		textArea.setFont(new Font("�������", Font.BOLD, 30));
		textArea.setEditable(false);
		textArea.setBackground(new Color(22, 56, 81));
		add(textArea);

		JButton btnNewButton_1 = new JButton(new ImageIcon("./img/menu_C/�����2.png"));
		btnNewButton_1.setBounds(365, 550, 121, 46);
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
		btnNewButton_1.setSelectedIcon(new ImageIcon("./img/menu_C/�����2_over.png"));
		btnNewButton_1.setPressedIcon(new ImageIcon("./img/menu_C/�����2_over.png"));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setFocusPainted(false);
		add(btnNewButton_1);
		setVisible(true);
		
		setLocation(70, 50);
		setSize(1467, 902);
	}
}