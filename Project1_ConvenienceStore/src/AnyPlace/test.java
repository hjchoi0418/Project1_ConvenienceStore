package AnyPlace;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String as = sc.next();

		String asc = sc.nextLine();
		
		if(as == asc) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}

	}

}
