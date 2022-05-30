package VendingMachine;

import java.util.Scanner;

public class VendingManager {

	Scanner sc = new Scanner(System.in);
	int flag = 0;

	public void input(int n) {

		if (n >= 1000) {
			System.out.println("모든 음료 선택 가능");
			String sel = sc.nextLine();

			if (sel.equals("물")) {
				buyW(n);
			} else if (sel.equals("오렌지 주스")) {
				buyO(n);
			} else if (sel.equals("커피")) {
				buyC(n);
			}

		} else if (n >= 700 && n < 1000) {
			System.out.println("물, 커피 선택 가능");
			String sel = sc.nextLine();

			if (sel.equals("물")) {
				buyW(n);

			} else if (sel.equals("커피")) {
				buyC(n);
			}

		} else if (n >= 500 && n < 700) {
			System.out.println("물 선택 가능");
			String sel = sc.nextLine();
			buyC(n);

		} else if (n < 500) {
			System.out.println("돈 더 넣어라..");

		}

	}

	public void buyW(int n) {
		System.out.println("시원한 물 나왔습니다");
		int change = n - 500;

		while (change >= 500) {

			System.out.println("현재 남은 금액" + change + " 음료 추가 구입>>y/n");
			String sel = sc.nextLine();

			if (sel.equals("y")) {
				input(change);
				change -= 500;

			} else if (sel.equals("n")) {

				System.out.println("거스름돈 :" + change);
				flag = 1;
				break;
			}

			if (flag == 1) {
				break;
			}
		}

		if (change < 500) {
			System.out.println("거스름돈 :" + change);

		}

	}

	public void buyO(int n) {

		System.out.println("싱그러운 오렌지 주스 나왔습니다");
		int change = n - 1000;

		while (change >= 500) {

			System.out.println("현재 남은 금액" + change + " 음료 추가 구입>>y/n");
			String sel = sc.nextLine();

			if (sel.equals("y")) {
				input(change);
				change -= 1000;

			} else if (sel.equals("n")) {

				System.out.println("거스름돈 :" + change);
				flag = 1;
				break;
			}

			if (flag == 1) {
				break;
			}
		}

		if (change < 500) {
			System.out.println("거스름돈 :" + change);

		}

	}

	public void buyC(int n) {

		System.out.println("따뜻한 커피 나왔습니다");
		int change = n - 700;

		while (change >= 500) {

			System.out.println("현재 남은 금액" + change + " 음료 추가 구입>>y/n");
			String sel = sc.nextLine();

			if (sel.equals("y")) {
				input(change);
				change -= 700;

			} else if (sel.equals("n")) {

				System.out.println("거스름돈 :" + change);
				flag = 1;
				break;
			}

			if (flag == 1) {
				break;
			}
		}

		if (change < 500) {
			System.out.println("거스름돈 :" + change);

		}

	}
}
