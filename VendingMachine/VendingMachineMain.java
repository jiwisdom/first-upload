package VendingMachine;

import java.util.Scanner;

public class VendingMachineMain {

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		VendingManager v = new VendingManager();
		
		System.out.println("자판기 프로그램\n음료를 골라봅시다\n");
		
		System.out.println("물 500원 | 오렌지 주스 1000원 | 커피 700원");
		
		System.out.println("동전을 넣으세요");
		int input = sc.nextInt();
	
		v.input(input);
		
		
	}

}
