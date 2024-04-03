package ejemploInterface3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class Ppal {
	public static void main(String args[]){  
		//ArrayList<Student> al=new ArrayList<Student>();  
		Vector <Student> al=new Vector();
		al.add(new Student(101,"Luis",23));  
		al.add(new Student(106,"Gemma",27));  
		al.add(new Student(105,"Pedro",21));  
		  
		Collections.sort(al,new StudentPorNombre());  
		for(Student st:al){  
			System.out.println(st);
		}  
		 
	}  
}
