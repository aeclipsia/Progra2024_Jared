package refactorizar1;

/**
 *
 * @author Rosa
 * 
 * 
 * 
 * @version 1.0
 */
public class Fecha {
    private int d; //x a d
    private int m;
    private int y; //año a y
    boolean fechaVal;

    public Fecha(int dia, int mes, int year) { //year en vez de anio
        this.d = dia;
        this.m = mes;
        this.y = year;
    }

    /**
     *  
     * @return Retorna si la fecha introducida es correcta
     */
    
    public boolean validarFecha() {
        if (!(fechaVal=validarDia())) {
			return false;
		}
        
        if (!(fechaVal=validarMes())) {
			return false;
		}
        
        return validaDiaMes();
    }

	public boolean validaDiaMes() {
		if (this.d > diasMes()) {
            return true;
        } else {
            return false;
        }
	}

	public int diasMes() {
		// determinamos la cantidad de días del mes:
        int z = 0;
        switch (this.m) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                z = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                z = 30;
                break;
            case 2:
                if ((this.y % 400 == 0) || ((this.y % 4 == 0) && (this.y % 100 != 0))) {
                    z = 29;
                } else {
                    z = 28;
                }
                break;

        }
		return z;
	}

	public boolean validarMes() {
		if (this.m < 1 || this.m > 12) {
            return true;
        }
		return false;
	}

	public boolean validarDia() {
		if (this.d < 1 || this.d > 31) {
            return true;
        }
		return false;
	}

}
