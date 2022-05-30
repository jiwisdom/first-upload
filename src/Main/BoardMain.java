package Main;

import java.util.Scanner;

import DBManager.BoardService;

public class BoardMain {

	public static void main(String[] args) throws Exception {

		BoardService bs = new BoardService();

		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("���� ������");
		bs.page(1);
	
			while (true) {

				System.out.println("1.��� 2.�� ��ȸ 3.���� 4.���� 5.������ �̵� 0.������");

				String sel = sc.nextLine();

				if (sel.equals("1")) {
					bs.insert();
				} else if (sel.equals("2")) {
					bs.find();
				} else if (sel.equals("3")) {
					bs.update();

				} else if (sel.equals("4")) {
					bs.delete();

				} else if (sel.equals("5")) {
					System.out.println("������ 1 2 >>");
					int n = sc.nextInt();
					sc.nextLine();
					bs.page(n);

				} else if (sel.equals("0")) {

					break;
				
				}
			}

		}

	

}
