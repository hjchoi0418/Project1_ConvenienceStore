package AnyPlace.controller.lookup;

import java.util.Scanner;

public class Lookup_main {

	public static void main(String[] args) {
		Lookup_method lookup = new Lookup_method();	
		
		//��� ��ǰ (ī�װ���ȣ, ��ǰ�̸�, ����)��ȸ
		System.out.println("ī�װ���ȣ\t   ��ǰ�̸�\t\t��ǰ����");
		lookup.selectMethod();
		
		//��� ��ǰ, ��� ��ȸ
		System.out.println("----------------------------");	
		lookup.select_stock();
			
		//��ǰ�̸����� ��� ��ȸ
		System.out.println("----------------------------");	
		Scanner sc = new Scanner(System.in);
		System.out.println("ã�� ��ǰ �˻�");
		System.out.print(">>");
		String name = sc.nextLine();
		lookup.search(name);
		
		
	}
}
