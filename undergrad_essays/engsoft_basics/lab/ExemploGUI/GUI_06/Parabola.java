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



public class Parabola extends Funcao {
	double a, b, c;
	public Parabola(double a, double b, double c) {
	   this.a = a;
	   this.b = b;
	   this.c = c;
	}
	public double f(double x) {
	    return a*x*x+b*x+c;
	  }
}

