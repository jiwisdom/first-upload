package VendingMachine;

import java.util.Scanner;

public class VendingManager {

	Scanner sc = new Scanner(System.in);
	int flag = 0;

	public void input(int n) {

		if (n >= 1000) {
			System.out.println("��� ���� ���� ����");
			String sel = sc.nextLine();

			if (sel.equals("��")) {
				buyW(n);
			} else if (sel.equals("������ �ֽ�")) {
				buyO(n);
			} else if (sel.equals("Ŀ��")) {
				buyC(n);
			}

		} else if (n >= 700 && n < 1000) {
			System.out.println("��, Ŀ�� ���� ����");
			String sel = sc.nextLine();

			if (sel.equals("��")) {
				buyW(n);

			} else if (sel.equals("Ŀ��")) {
				buyC(n);
			}

		} else if (n >= 500 && n < 700) {
			System.out.println("�� ���� ����");
			String sel = sc.nextLine();
			buyC(n);

		} else if (n < 500) {
			System.out.println("�� �� �־��..");

		}

	}

	public void buyW(int n) {
		System.out.println("�ÿ��� �� ���Խ��ϴ�");
		int change = n - 500;

		while (change >= 500) {

			System.out.println("���� ���� �ݾ�" + change + " ���� �߰� ����>>y/n");
			String sel = sc.nextLine();

			if (sel.equals("y")) {
				input(change);
				change -= 500;

			} else if (sel.equals("n")) {

				System.out.println("�Ž����� :" + change);
				flag = 1;
				break;
			}

			if (flag == 1) {
				break;
			}
		}

		if (change < 500) {
			System.out.println("�Ž����� :" + change);

		}

	}

	public void buyO(int n) {

		System.out.println("�̱׷��� ������ �ֽ� ���Խ��ϴ�");
		int change = n - 1000;

		while (change >= 500) {

			System.out.println("���� ���� �ݾ�" + change + " ���� �߰� ����>>y/n");
			String sel = sc.nextLine();

			if (sel.equals("y")) {
				input(change);
				change -= 1000;

			} else if (sel.equals("n")) {

				System.out.println("�Ž����� :" + change);
				flag = 1;
				break;
			}

			if (flag == 1) {
				break;
			}
		}

		if (change < 500) {
			System.out.println("�Ž����� :" + change);

		}

	}

	public void buyC(int n) {

		System.out.println("������ Ŀ�� ���Խ��ϴ�");
		int change = n - 700;

		while (change >= 500) {

			System.out.println("���� ���� �ݾ�" + change + " ���� �߰� ����>>y/n");
			String sel = sc.nextLine();

			if (sel.equals("y")) {
				input(change);
				change -= 700;

			} else if (sel.equals("n")) {

				System.out.println("�Ž����� :" + change);
				flag = 1;
				break;
			}

			if (flag == 1) {
				break;
			}
		}

		if (change < 500) {
			System.out.println("�Ž����� :" + change);

		}

	}
}
