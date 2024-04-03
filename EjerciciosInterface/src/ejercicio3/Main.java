package ejercicio3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class Main {
	public static void main(String args[]){  
		//ArrayList<Student> al=new ArrayList<Student>();  
		Vector <Student> al=new Vector();
		al.add(new Student(101,"Luis",23,LocalDate.of(2024, 04, 01)));  
		al.add(new Student(106,"Gemma",27,LocalDate.of(2020, 03, 02)));  
		al.add(new Student(105,"Pedro",21,LocalDate.of(2023, 05, 06)));  
		  
		Collections.sort(al);  
		for(Student st:al){  
			System.out.println(st);
		}  
		 
	}  
}
