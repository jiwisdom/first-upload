package homework;

import java.util.Random;
import java.util.Scanner;

public class HatchingEggMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		Egg egg[] = new Egg[3]; 
		HachingService hs = new HachingService();
		Hug hug = new Hug();
		Fed fed = new Fed();
		Play play = new Play();
		
		Egg Happyegg = new Egg("�����",10,"�Ų��� ���� �����ִ� ����� ��׿�");
		Egg Sadegg = new Egg("������",8,"�Ӹ����� ���� �� ���� �� ���� ����� ��׿�");
		Egg Pickyegg = new Egg("������",6,"��� �ο췯 �� �� ��� ���� ���� �� ���׿�");
		
		egg[0]=Happyegg;
		egg[1]=Sadegg;
		egg[2]=Pickyegg;
	
		System.out.println("���� ��ȭ���� ���ô�~");
		int random = rd.nextInt(3)+0;
		System.out.println(egg[random].getCharacter());
		System.out.println();
		System.out.println("���� ���� ��ȭ���� �ʾƿ�~ �˿��� ������ �ּ���");
		while(true) {									
			
			System.out.println("1.�������ֱ� 2.�����ֱ� 3.����ֱ�");
			
			String ans = sc.nextLine();
			System.out.println();
			if(ans.equals("1")) {
				
				System.out.println("������ ������ ���� �� �־��~");
				int hugEvo = egg[random].condition-hs.Evolution(hug);
				
				hs.result(hugEvo);
				if(hugEvo<=0) {
					System.out.println(egg[random].name+"���� ��ȭ�Ǿ����ϴ�");
					return;
				}
				egg[random].condition=hugEvo;
				
			}else if(ans.equals("2")) {
				
				System.out.println("�Դ� �� ���󿡼� ���� �߿�����~");
				int fedEvo = egg[random].condition-hs.Evolution(fed);		
				
				hs.result(fedEvo);
				if(fedEvo<=0) {
					System.out.println(egg[random].name+"���� ��ȭ�Ǿ����ϴ�");
					return;
				}
				egg[random].condition=fedEvo;
				
				
			}else if(ans.equals("3")) {
				
				System.out.println("���� ��� �� ģ������~");
				int playEvo = egg[random].condition-hs.Evolution(play);		
				
				hs.result(playEvo);
				if(playEvo<=0) {
					System.out.println(egg[random].name+"���� ��ȭ�Ǿ����ϴ�");
					return;
				}
				egg[random].condition=playEvo;
				
				
				
			}else if(ans.equals("0")) {
			    return;				
			}else {
				System.out.println("�ٽ� �Է����ּ���");
			}			
			
		}
		
	}

}

