package AnyPlace.controller.product_sales;

import java.util.Scanner;

public class Order_main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Order_product order = new Order_product();
		
		order.Temporary_order();
		while(true) {
						
			order.detail_order();	
			System.out.println("��� �����Ͻðڽ��ϱ�?");
			System.out.println("1 : ���� 2 : ��������\n>>");
			int a = sc.nextInt();
			
			if(a == 2) {
				break;
			}
		}
		order.update_order();
	}
}