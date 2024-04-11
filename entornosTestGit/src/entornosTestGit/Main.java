package entornosTestGit;

import java.util.*;

public class Main {

	static Scanner sc=new Scanner(System.in);
	static LinkedList<Integer> num=new LinkedList<Integer>();
	static int op;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		do {
			System.out.println("Anota un número");
			op=sc.nextInt();
			num.add(op);
		} while (num.size()<10);
		
		for (Integer i : num) {
			System.out.print(i+"\t");
		}
		
	}

}
