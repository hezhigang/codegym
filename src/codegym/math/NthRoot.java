/**
 * the principal nth root of a positive real number 
 */
package codegym.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author hezhigang
 * 
 */
public class NthRoot {
	
	/**
	 * Nth root
	 * @param n
	 * @param A
	 * @return
	 */
	public static double nthroot(int n, double A) {
		double r = nthroot(n, A, .001);
		return BigDecimal.valueOf(r).setScale(3, RoundingMode.HALF_DOWN).doubleValue();
	}
	/**
	 * Newton's method
	 * https://rosettacode.org/wiki/Nth_root#Javas
	 * @param n
	 * @param A
	 * @param p
	 * @return
	 */
	public static double nthroot(int n, double A, double p) {
		if(A < 0) {
			System.err.println("A < 0");// we handle only real positive numbers
			return -1;
		} else if(A == 0) {
			return 0;
		}
		double x_prev = A;
		double x = A / n;  // starting "guessed" value...
		while(Math.abs(x - x_prev) > p) {
			x_prev = x;
			x = ((n - 1.0) * x + A / Math.pow(x, n - 1.0)) / n;
		}
		return x;
	}
	
	/**
	 * strategy of binary search
	 * @param x
	 * @param n
	 * @return
	 */
	public static double root(double x, int n) {
		double lower = 0;
		double upper = x;
		double r = 0;
		double temp = 0;
		while (upper - lower >= 0.001) {
			r = (upper + lower) / 2;
			temp = Math.pow(r, n);
			if (temp > x) {
				upper = r;
			} else {
				lower = r;
			}
		}

		return BigDecimal.valueOf(r).setScale(3, RoundingMode.HALF_DOWN).doubleValue();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//	    double x = 9;
//	    int n = 2;
	    double x = 7;
	    int n = 3;
	    double exp = 1.0/n;
	    double r = Math.pow(x, exp);
	    System.out.println("nth root by Math.pow as below:");
	    System.out.printf("%dth root of %f=%f\n", n, x, r);
	    System.out.println("---------------------------------");
	    System.out.println("nth root by strategy of binary search as below:");
	    System.out.printf("%dth root of %f=%f\n", n, x, root(x,n));
	    System.out.println("---------------------------------");
	    System.out.println("nth root by Newton's method as below:");
	    System.out.printf("%dth root of %f=%f\n", n, x, nthroot(n,x));
	}

}
