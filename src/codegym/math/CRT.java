package codegym.math;

import java.math.BigInteger;

/**
 * 孙子定理
 * 一元线性同余方程组
 * 有物不知其数，三三数之剩二，五五数之剩三，七七数之剩二。问物几何？
 */
public class CRT {
    public static void main(String[] args) {
        final int m1 = 3, m2 = 5, m3 = 7;
        System.out.printf("modulars are = %d,%d,%d\n", m1, m2, m3);
        final int M = m1 * m2 * m3;
        System.out.printf("product of modular is = %d\n", M);
        final int r1 = 2, r2 = 3, r3 = 2;
        System.out.printf("remaiders are = %d,%d,%d\n", r1, r2, r3);
        final int M1 = M / m1;
        final int M2 = M / m2;
        final int M3 = M / m3;
        System.out.printf("congruence linear coefficients are = %d,%d,%d\n", M1, M2, M3);
        final int i1 = BigInteger.valueOf(M1).modInverse(BigInteger.valueOf(m1)).intValue();
        final int i2 = BigInteger.valueOf(M2).modInverse(BigInteger.valueOf(m2)).intValue();
        final int i3 = BigInteger.valueOf(M3).modInverse(BigInteger.valueOf(m3)).intValue();
        System.out.printf("modular multiplicative inverses are = %d,%d,%d\n", i1, i2, i3);
        final int S = r1 * M1 * i1 + r2 * M2 * i2 + r3 * M3 * i3;
        System.out.printf("the sum is = %d*%d*%d+%d*%d*%d+%d*%d*%d = %d\n", r1, M1, i1, r2, M2, i2, r3, M3, i3, S);
        final int x = S % M;
        System.out.printf("the simultaneous solution is = %d", x);
    }
}
