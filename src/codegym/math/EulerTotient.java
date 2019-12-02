package codegym.math;

/**
 * @author hezhigang
 * Euler Totient Function
 * https://www.geeksforgeeks.org/eulers-totient-function/
 */
public class EulerTotient {
	
	static int gcd(int a, int b) {
		if (a==0) return b;
		return gcd(b%a, a);
	}
	
	static int phi(int n) {
		int result = 1;
		for(int i=2;i<n;i++)
			if (gcd(i,n)==1) result++;
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int n=1; n<100; n++) 
			System.out.printf( "phi(%d)=%d\n", n, phi(n) );
	}

}
