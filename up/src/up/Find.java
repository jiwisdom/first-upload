package up;
import java.util.Scanner;

public class Find {

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);

		System.out.println("���� ���� ã�� ����");

		String str = "Oasis";

		char [] array = str.toCharArray();


		for(int i=0;i<array.length;i++) {
			if(array[i]==' ') {
				array[i]=' ';
			}else {
				array[i]='*';
			}
			System.out.print(array[i]);
		}
		System.out.println(" ");
		
		while(true) {
			System.out.println("���ĺ��� �Է��ϼ���");
			String alpha = sc.next();
		    
			for(int i=0;i<array.length;i++) {					
				if(str.contains(alpha)) {
					int n = str.indexOf(alpha);
					
					for(int a=0;a<array.length;a++) {
						if(str.toLowerCase().charAt(a)==str.charAt(n)||str.toUpperCase().charAt(a)==str.charAt(n)) {
							array[a]=str.charAt(n);		
							
						} 					
					}
										
				}else {
					System.out.println("���忡 �����ϴ�~ �ٽ� �Է����ּ���");
					break;
				}
				System.out.print(array[i]);
				
			}
			
		}


	}

}
