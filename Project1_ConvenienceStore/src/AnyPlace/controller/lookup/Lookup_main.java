package AnyPlace.controller.lookup;

import java.util.Scanner;

public class Lookup_main {

	public static void main(String[] args) {
		Lookup_method lookup = new Lookup_method();	
		
		//모든 상품 (카테고리번호, 상품이름, 가격)조회
		System.out.println("카테고리번호\t   상품이름\t\t상품가격");
		lookup.selectMethod();
		
		//모든 상품, 재고 조회
		System.out.println("----------------------------");	
		lookup.select_stock();
			
		//상품이름으로 재고 조회
		System.out.println("----------------------------");	
		Scanner sc = new Scanner(System.in);
		System.out.println("찾을 상품 검색");
		System.out.print(">>");
		String name = sc.nextLine();
		lookup.search(name);
		
		
	}
}
