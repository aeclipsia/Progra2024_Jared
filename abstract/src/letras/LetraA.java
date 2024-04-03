package letras;

public class LetraA extends Letra{
	
	public LetraA(char car){
		super(car,'a');
	}
		
	public void dibuja(){
		System.out.println("   "+c);
		System.out.println("  "+c+" "+c);
		System.out.println(" "+c+c+c+c+c);
		System.out.println(c+"     "+c);
	}
}