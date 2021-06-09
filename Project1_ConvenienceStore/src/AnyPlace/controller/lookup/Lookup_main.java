package AnyPlace.controller.lookup;

import java.util.Scanner;

public class Lookup_main {

	public static void main(String[] args) {
		Lookup_method lookup = new Lookup_method();	
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("---- 재고 조회 ----");
			System.out.println("모든 상품 조회     <1>");
			System.out.println("모든 상품 재고 조회 <2>");
			System.out.println("상품 검색         <3>");
			System.out.println("종료             <4>");
			System.out.print(">>");
			int menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				System.out.println("no.   제품번호        카테고리번호\t  상품이름\t상품가격 \t\t 유통기한");
				lookup.selectMethod();
				System.out.println("----------------------------");	
			}
			if (menu == 2) {
				System.out.println("----------------------------");	
				lookup.select_stock();
				System.out.println("----------------------------");	
			}
			if (menu == 3) {
				System.out.println("----------------------------");	
				System.out.println("찾을 상품 검색");
				System.out.print(">>");
				String name = sc.nextLine();
				lookup.search(name);
				System.out.println("----------------------------");	
			}
			if (menu == 4) {
				System.out.println("--- 프로그램 종료 ---");
				System.exit(0);
			}else {
				System.out.println("1~4까지의 숫자를 입력해주세요");
			}
		}	
	}
}
