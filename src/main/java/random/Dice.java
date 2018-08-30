package random;

public class Dice {

	protected String name;
	protected int num;
	
	public Dice(String name, int num) {
		super();
		this.name = name;
		this.num = num;
	}
	
	public Dice() {
		super();
		this.name = name;
		this.num = num;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
}
