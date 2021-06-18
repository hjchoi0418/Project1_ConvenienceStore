package AnyPlace.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import AnyPlace.controller.BuyProduct.Lookup_method;

public class Inventory_view extends JPanel{
	
	ImageIcon icon;
	JButton 장바구니추가, 장바구니초기화, 카드결제, 현금결제;
	JTable stock_table;
	JScrollPane scroll;
	
	private String[][] data;
	private String[] columnType = {"상품번호", "분류", "상품 이름", "상품 가격", "재고"};

	public Inventory_view() {
		
		setBorder(new EmptyBorder(20, 50, 20, 50));
		setBackground(Color.white);
		setLayout(null);
		
		
		JPanel buy_table_panel = new JPanel();
		buy_table_panel.setBackground(Color.white);
		buy_table_panel.setBounds(20, 20, 990, 510);
		add(buy_table_panel);
		
		data = Lookup_method.getproduct();
		DefaultTableModel model = new DefaultTableModel(data, columnType) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
		};
		
		stock_table = new JTable(model);
		scroll = new JScrollPane(stock_table);
		buy_table_panel.add(scroll);
		scroll.setPreferredSize(new Dimension(990, 500));
		
		stock_table.getTableHeader().setFont(new Font("나눔고딕", Font.BOLD, 20));
		stock_table.getTableHeader().setBackground(new Color(22,56,81));
		stock_table.getTableHeader().setForeground(new Color(255,255,255));
		stock_table.getTableHeader().setPreferredSize(new Dimension(0, 60));
		stock_table.getTableHeader().setReorderingAllowed(false);
		stock_table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		stock_table.setRowSelectionAllowed(true);
		stock_table.getTableHeader().setReorderingAllowed(false);
		
		stock_table.setRowHeight(40);
		stock_table.setFont(new Font("나눔고딕", Font.BOLD, 15));
		stock_table.setBackground(new Color(198,198,198));
		stock_table.setForeground(new Color(22,56,81));
		stock_table.setRowSelectionAllowed(true);

		// 가운데 정렬
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule = stock_table.getColumnModel();
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
			tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}
		// 컬럼 사이 간격 조정
		TableColumnModel columnModels = stock_table.getColumnModel();
		columnModels.getColumn(0).setPreferredWidth(40);
		columnModels.getColumn(1).setPreferredWidth(40);
		columnModels.getColumn(2).setPreferredWidth(170);
		columnModels.getColumn(3).setPreferredWidth(60);
		columnModels.getColumn(4).setPreferredWidth(1);
		
		JTextField search = new JTextField();
		search.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		search.setBounds(400, 600, 230, 50);
		add(search);
		search.setBackground(SystemColor.WHITE);
		search.setColumns(10);
		search.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String val = search.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<>(stock_table.getModel());
				stock_table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});
	}
}
