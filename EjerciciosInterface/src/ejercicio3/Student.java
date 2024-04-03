package ejercicio3;

import java.time.*;

class Student implements Comparable<Student>{  
	private int number;  
	private String name;  
	private int age; 
	private LocalDate fechaInc;

	public Student(int num,String name,int age,LocalDate fechaInc){  
		this.number=num;  
		this.name=name;  
		this.age=age;
		this.fechaInc=fechaInc;
	}  
	  
	public int compareTo(Student st){  
		if(fechaInc.equals(st.fechaInc))  
			return 0;  
		else if(fechaInc.isBefore(st.fechaInc))  
			return 1;  
		else  
			return -1;  
	}

	@Override
	public String toString() {
		return "Student [number=" + number + ", name=" + name + ", age=" + age + ", fechaInc=" + fechaInc + "]";
	}
	
}  
