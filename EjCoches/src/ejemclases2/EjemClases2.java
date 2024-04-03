/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemclases2;

import java.util.*;

public class EjemClases2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int op, c, v;
        Scanner sc = new Scanner(System.in);
        Coche miCoche1, miCoche2;
        miCoche1 = new Coche("1234AAA");
        miCoche2 = new Coche("4444ZZZ");

        do {
            System.out.println("1. Acelerar");
            System.out.println("2. Frenar");
            System.out.println("3. Salir");
            System.out.println("Anota opcion:");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Aumentar velocidad:");
                    v = sc.nextInt();

                    do {
                        System.out.println("Coche 1 ó 2?");
                        c = sc.nextInt();
                    } while (c != 1 && c != 2);

                    if (c == 1) {
                        miCoche1.acelerar(v);
                    } else {
                        miCoche2.acelerar(v);
                    }
                    break;
                case 2:
                    System.out.println("Disminuir velocidad:");
                    v = sc.nextInt();

                    do {
                        System.out.println("Coche 1 ó 2?");
                        c = sc.nextInt();
                    } while (c != 1 && c != 2);

                    if (c == 1) {
                        miCoche1.frenar(v);
                    } else {
                        miCoche2.frenar(v);
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (op != 3);

       

    }

}
