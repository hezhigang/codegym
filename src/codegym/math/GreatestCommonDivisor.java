package codegym.math;

import java.math.BigInteger;

/**
 * @author hezhigang
 * Greatest common divisor
 */
public class GreatestCommonDivisor {

	/**
	 * Built-in
	 * @param a
	 * @param b
	 * @return
	 */
	public static long gcd(long a, long b) {
		return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).longValue();
	}
	
	/**
	 * Recursive
	 * @param a
	 * @param b
	 * @return
	 */
	public static long gcd_recursive(long a, long b) {
		if (a == 0)
			return b;
		if (b == 0)
			return a;
		if (a > b)
			return gcd(b, a % b);
		return gcd(a, b % a);
	}
	
	/**
	 * substract instead mod
	 * @param a
	 * @param b
	 * @return
	 */
	public static long gcd_recursive_nonmod(long a, long b) {
		if (a < b)
			return gcd_recursive_nonmod(b, a);
		if (b == 0)
			return a;
		else
			return gcd_recursive_nonmod(a - b, b);
	}
	
	/**
	 * bit operation
	 * @param a
	 * @param b
	 * @return
	 */
	public static long gcd_recursive_bitop(long a, long b) {
		if (a < b)
			return gcd_recursive_bitop(b, a);
		if (b == 0)
			return a;
		else {
			if ((a & 1) == 0) {
				if ((b & 1) == 0)
					return (gcd_recursive_bitop(a >> 1, b >> 1) << 1);
				else
					return gcd_recursive_bitop(a >> 1, b);
			} else {
				if ((b & 1) == 0)
					return gcd_recursive_bitop(a, b >> 1);
				else
					return gcd_recursive_bitop(b, a - b);
			}
		}
	}

	public static void main(String[] args) {
		long a = 54, b = 24;
		System.out.printf("gcd(%d,%d)=%d, %d, %d, %d", a, b, gcd(a, b), gcd_recursive(a, b), gcd_recursive_nonmod(a, b),
				gcd_recursive_bitop(a, b));
		System.out.println();
	}

}
