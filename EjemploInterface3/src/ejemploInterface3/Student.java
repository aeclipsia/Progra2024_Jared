package ejemploInterface3;

class Student{  
private int number;  
private String name;  
private int age;  

Student(int nu,String name,int age){  
this.number=nu;  
this.name=name;  
this.age=age;  
}  
  

public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


@Override
public String toString() {
	return "Student [number=" + number + ", name=" + name + ", age=" + age + "]";
}  


}  
