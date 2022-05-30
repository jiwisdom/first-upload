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
		
		Egg Happyegg = new Egg("기쁨이",10,"매끈한 알이 웃고있는 기분이 드네요");
		Egg Sadegg = new Egg("슬픔이",8,"속마음을 말할 수 있을 것 같은 기분이 드네요");
		Egg Pickyegg = new Egg("버럭이",6,"어디 싸우러 갈 때 들고 가면 딱일 것 같네요");
		
		egg[0]=Happyegg;
		egg[1]=Sadegg;
		egg[2]=Pickyegg;
	
		System.out.println("알을 부화시켜 봅시다~");
		int random = rd.nextInt(3)+0;
		System.out.println(egg[random].getCharacter());
		System.out.println();
		System.out.println("알은 쉽게 부화되지 않아요~ 알에게 관심을 주세요");
		while(true) {									
			
			System.out.println("1.포옹해주기 2.먹이주기 3.놀아주기");
			
			String ans = sc.nextLine();
			System.out.println();
			if(ans.equals("1")) {
				
				System.out.println("포옹은 감정을 나눌 수 있어요~");
				int hugEvo = egg[random].condition-hs.Evolution(hug);
				
				hs.result(hugEvo);
				if(hugEvo<=0) {
					System.out.println(egg[random].name+"알이 부화되었습니다");
					return;
				}
				egg[random].condition=hugEvo;
				
			}else if(ans.equals("2")) {
				
				System.out.println("먹는 게 세상에서 가장 중요하죠~");
				int fedEvo = egg[random].condition-hs.Evolution(fed);		
				
				hs.result(fedEvo);
				if(fedEvo<=0) {
					System.out.println(egg[random].name+"알이 부화되었습니다");
					return;
				}
				egg[random].condition=fedEvo;
				
				
			}else if(ans.equals("3")) {
				
				System.out.println("같이 놀면 더 친해져요~");
				int playEvo = egg[random].condition-hs.Evolution(play);		
				
				hs.result(playEvo);
				if(playEvo<=0) {
					System.out.println(egg[random].name+"알이 부화되었습니다");
					return;
				}
				egg[random].condition=playEvo;
				
				
				
			}else if(ans.equals("0")) {
			    return;				
			}else {
				System.out.println("다시 입력해주세요");
			}			
			
		}
		
	}

}

