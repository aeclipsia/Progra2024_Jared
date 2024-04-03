package ejemploInterface3;

import java.util.Comparator;

public class StudentPorNombre implements Comparator<Student>{

	@Override
	public int compare(Student arg0, Student arg1) {
		// TODO Auto-generated method stub
		return arg0.getName().compareTo(arg1.getName());
	}

}
