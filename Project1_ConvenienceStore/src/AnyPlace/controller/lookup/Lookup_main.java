package AnyPlace.controller.lookup;

import java.util.Scanner;

public class Lookup_main {

	public static void main(String[] args) {
		Lookup_method lookup = new Lookup_method();	
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("---- ��� ��ȸ ----");
			System.out.println("��� ��ǰ ��ȸ     <1>");
			System.out.println("��� ��ǰ ��� ��ȸ <2>");
			System.out.println("��ǰ �˻�         <3>");
			System.out.println("����             <4>");
			System.out.print(">>");
			int menu = Integer.parseInt(sc.nextLine());
			if (menu == 1) {
				System.out.println("no.   ��ǰ��ȣ        ī�װ���ȣ\t  ��ǰ�̸�\t��ǰ���� \t\t �������");
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
				System.out.println("ã�� ��ǰ �˻�");
				System.out.print(">>");
				String name = sc.nextLine();
				lookup.search(name);
				System.out.println("----------------------------");	
			}
			if (menu == 4) {
				System.out.println("--- ���α׷� ���� ---");
				System.exit(0);
			}else {
				System.out.println("1~4������ ���ڸ� �Է����ּ���");
			}
		}	
	}
}
