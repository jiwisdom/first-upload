package VendingMachine;

import java.util.Scanner;

public class VendingMachineMain {

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		VendingManager v = new VendingManager();
		
		System.out.println("���Ǳ� ���α׷�\n���Ḧ ��󺾽ô�\n");
		
		System.out.println("�� 500�� | ������ �ֽ� 1000�� | Ŀ�� 700��");
		
		System.out.println("������ ��������");
		int input = sc.nextInt();
	
		v.input(input);
		
		
	}

}
