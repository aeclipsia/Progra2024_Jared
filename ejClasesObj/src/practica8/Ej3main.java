package practica8;

public class Ej3main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Alumnos alum1=new Alumnos(4037,8,8,8);
		Alumnos alum2=new Alumnos(2034,10,10,10);
		Alumnos alum3=new Alumnos(1204,3,3,3);
		
		double avg1, avg2, avg3;
		
		avg1=alum1.media();
		avg2=alum2.media();
		avg3=alum3.media();
		
		if (avg1>=avg2) {
			if (avg1>avg3 && avg2>avg3) {
				System.out.println(avg1+","+avg2+","+avg3);
			}
			else if (avg1>avg3 && avg3>avg2) {
				System.out.println(avg1+","+avg3+","+avg2);
			}
			else if (avg3>avg1 && avg3>avg2) {
				System.out.println(avg3+","+avg1+","+avg2);
			}
		}
		else if (avg2>avg1) {
			if (avg2>avg3 && avg1>avg3) {
				System.out.println(avg2+","+avg1+","+avg3);
			}
			else if (avg2>avg3 && avg3>avg1) {
				System.out.println(avg2+","+avg3+","+avg1);
			}
			else if (avg3>avg2 && avg3>avg1) {
				System.out.println(avg3+","+avg2+","+avg1);
			}
		}
	}

}
