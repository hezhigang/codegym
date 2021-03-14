/*
author: hezhigang
date: 3/14/21
time: 4:59 PM
*/
package codegym.math;

public class Pi {

    /**
     * Leibniz formula for π
     * @return
     */
    public static double pi_Leibniz() {
        double pi = 0.0d;
        for (int i = 1; i < 10000000; i++) {
            pi += (i & 1) == 1 ? 4.0d / (2 * i - 1) : -4.0d / (2 * i - 1);
        }
        return pi;
    }

    /**
     * Basel problem
     * @return
     */
    public static double pi_Basel() {
        double pi = 0.0d;
        for (int i = 1; i < 10000; i++) {
            pi += 1.0d / (i * i);
        }
        pi = pi * 6.0d;
        pi = Math.sqrt(pi);
        return pi;
    }

    public static void main(String[] args) {
        double pi = pi_Leibniz();
        double pi_2 = pi_Basel();
        System.out.printf("π=%f, π=%f", pi, pi_2);
    }
}
