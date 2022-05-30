package homework;


public class Egg {
	public String name;
	public int condition;
	
	public void setCharacter(String character) {
		this.character = character;
	}
	
	public String getCharacter() {
		return character;
	}

	private String character;
	

	public Egg() {}
	
	public Egg(String name,int condition,String character) {
		this.name=name;
		this.condition=condition;
		this.character=character;
	}
	
	public void setCondition(int condition) {
		this.condition = condition;
	}
	
	public int getCondition() {
		return condition;
	}

	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		
		return name;
	}

	
	

} 

		
	


