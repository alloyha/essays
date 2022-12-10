/*
 * Created on 16/03/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author fktakase
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class Reta extends Funcao {
	double a, b;
	public Reta(double a, double b) {
	   this.a = a;
	   this.b = b;
	}
	public double f(double x) {
	    return a*x+b;
	  }
}

