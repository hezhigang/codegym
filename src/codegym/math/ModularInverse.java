package codegym.math;

import java.math.BigInteger;

public class ModularInverse {
    public static void main(String[] args) {
        System.out.println(BigInteger.valueOf(35).modInverse(BigInteger.valueOf(3)));
        System.out.println(BigInteger.valueOf(21).modInverse(BigInteger.valueOf(5)));
        System.out.println(BigInteger.valueOf(15).modInverse(BigInteger.valueOf(7)));
        System.out.println(BigInteger.valueOf(42).modInverse(BigInteger.valueOf(2017)));
//        int m = 12, n = 18;
        int m = 42, n = 2017;
        EEResult re = extendedEuclid(m, n);
        System.out.printf("%d*%d+%d*%d=%d", re.a, m, re.b, n, re.d);
    }

    public static EEResult extendedEuclid(int m, int n) {
        EEResult re = new EEResult();
        if (m==0) {
            re.d = n;
            re.a = 0;
            re.b = 1;
            return re;
        }
        re = extendedEuclid(n%m, m);
        int d = re.d;
        int a = re.b - (n/m)*re.a;
        int b = re.a;
        re.d = d;
        re.a = a;
        re.b = b;
        return re;
    }

    static class EEResult {
        int d;
        int a;
        int b;
    }
}
