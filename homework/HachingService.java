package homework;


class Hug extends EggEvolution{

}

class Fed extends EggEvolution {
	
}

	
class Play  extends EggEvolution{
	
}

public class HachingService extends Egg{
	
	public int Evolution(EggEvolution ee) {		
			    
		if(ee instanceof Hug) {
			
			condition=3;
		}else if(ee instanceof Fed) {
			
			condition=2;
		}else if(ee instanceof Play) {
			condition=1;
		}		
			
		return condition;
	}
	
	public void result(int n) {		
	
		if(n>0) {			
		System.out.println("���ݸ� �� ������� �ּ���");
		System.out.println();
		System.out.println("��ȭ�� ���� �ʿ��� �����"+n);	
		}
		
	}

}

