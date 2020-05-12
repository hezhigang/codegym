/**
 * the extended Euclidean algorithm is an extension to the Euclidean algorithm
 * The extended Euclidean algorithm is particularly useful when a and b are coprime. 
 */
package codegym.math;

/**
 * @author hezhigang
 * https://introcs.cs.princeton.edu/java/99crypto/ExtendedEuclid.java
 */
public class ExtendedEuclid {

	// return array [d, a, b] such that d = gcd(p, q), ap + bq = d
	static int[] gcd(int p, int q) {
		if (q == 0)
			return new int[] { p, 1, 0 };

		int[] vals = gcd(q, p % q);
		int d = vals[0];
		int a = vals[2];
		int b = vals[1] - (p / q) * vals[2];
		return new int[] { d, a, b };
	}

	/**
	 * Pate Williams' implementation of Menezes' algorithm
	 * https://www.di-mgt.com.au/euclidean.html
	 * @param a
	 * @param b
	 * @return
	 */
	static int[] extended_euclid(int a, int b) {
		int q, r, x1, x2, y1, y2;
		int x, y, d;
		if (b == 0)
			return new int[] { a, 1, 0 };
		x2 = 1;
		x1 = 0;
		y2 = 0;
		y1 = 1;
		while (b > 0) {
			q = a / b;
			r = a - q * b;
			x = x2 - q * x1;
			y = y2 - q * y1;
			a = b;
			b = r;
			x2 = x1;
			x1 = x;
			y2 = y1;
			y1 = y;
		}
		d = a;
		x = x2;
		y = y2;
		return new int[] { d, x, y };
	}

	public static void main(String[] args) {
//		int p = 3;
//		int q = 11;
		int p = 4864, q = 3458;
		int vals[] = gcd(p, q);
		System.out.println("gcd(" + p + ", " + q + ") = " + vals[0]);
		System.out.println(vals[1] + "*" + p + " + " + vals[2] + "*" + q + " = " + vals[0]);

		int vals2[] = extended_euclid(p, q);
		System.out.println("gcd(" + p + ", " + q + ") = " + vals2[0]);
		System.out.println(vals2[1] + "*" + p + " + " + vals2[2] + "*" + q + " = " + vals2[0]);
	}

}
