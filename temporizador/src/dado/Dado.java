package dado;

import java.util.*;

public class Dado extends TimerTask{

	static int result, count=0;
	
	public void run() {
		result=(int)(Math.random()*6)+1;
		
		System.out.println(result);
		
		if (result==6) {
			count++;
		}
	}
	
	public int getCount() {
		return count;
	}
	
}
