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
	
	static int phi_gcd(int n) {
		int result = 1;
		for(int i=2;i<n;i++)
			if (gcd(i,n)==1) result++;
		return result;
	}
	
	/**
	 * Euler’s product formula
	 * @param n
	 * @return
	 */
	static int phi_float(int n) {
		float result = n;
		for (int p = 2; p * p <= n; ++p) {
			if (n % p == 0) {
				while (n % p == 0)
					n /= p;
				result *= (1.0 - (1.0 / (float) p));
			}
		}
		if (n > 1)
			result *= (1.0 - (1.0 / (float) n));

		return (int) result;
	}
	
	/**
	 * Euler’s product formula
	 * @param n
	 * @return
	 */
	static int phi(int n) {
		int result = n;
		for (int p = 2; p * p <= n; ++p) {
			if (n % p == 0) {
				while (n % p == 0)
					n /= p;
				result -= result / p;
			}
		}
		if (n > 1)
			result -= result / n;
		return result;
	}
	
	/**
	 * Computes and prints totient of all numbers 
	 * smaller than or equal to n. 
	 * @param n
	 */
	static void computeTotient(int n) {
		long phi[] = new long[n + 1];
		for (int i = 1; i <= n; i++)
			phi[i] = i;
		for (int p = 2; p <= n; p++) {
			if (phi[p] == p) {
				phi[p] = p - 1;
				for (int i = 2 * p; i <= n; i += p) {
					phi[i] = (phi[i] / p) * (p - 1);
				}
			}
		}
		for (int i = 1; i <= n; i++)
			System.out.println("ϕ(" + i + ")=" + phi[i]);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.printf("%d*%d=%d", phi(8), phi(9), phi(72));
		System.out.println();
		System.out.printf("%d*%d=%d", phi(5), phi(12), phi(60));
		System.out.println();
		computeTotient(20);
//		for(int n=1; n<100; n++) 
//			System.out.printf( "phi(%d)=%d\n", n, phi(n) );
	}

}
