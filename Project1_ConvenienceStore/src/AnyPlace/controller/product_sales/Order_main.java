package AnyPlace.controller.product_sales;

import java.util.Scanner;

public class Order_main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Order_product order = new Order_product();
		
		order.Temporary_order();
		while(true) {
						
			order.detail_order();	
			System.out.println("계속 구매하시겠습니까?");
			System.out.println("1 : 구매 2 : 구매종료\n>>");
			int a = sc.nextInt();
			
			if(a == 2) {
				break;
			}
		}
		order.update_order();
	}
}