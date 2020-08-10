package com.github.zhve.spoj;

import java.util.Scanner;

/**
 * <a href="http://www.spoj.com/problems/PRLCM/">http://www.spoj.com/problems/PRLCM/</a>
 */
public class PRLCM {
    private static final long MODULO = 998244353;
    private static final long INV_2 = modInverse(2);

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
            max = Math.max(max, a[i]);
        }

        int a_max = max + 1;
        int[] count = new int[a_max];
        for (int i = 0; i < n; ++i) {
            count[a[i]]++;
        }

        long[] t = new long[a_max];
        for (int g = 1; g < a_max; ++g) {
            long prefix_sum = 0;

            for (int gmult = g; gmult < a_max; gmult += g) {
                t[g] = SUM(t[g], MULT(MULT(prefix_sum, count[gmult]), gmult));
                t[g] = SUM(t[g], MULT(MULT(MULT(MULT(gmult, gmult), count[gmult]), (count[gmult] - 1)), INV_2));
                prefix_sum = SUM(prefix_sum, MULT(count[gmult], gmult));
            }
        }

        long answer = 0;
        for (int g = a_max - 1; g > 0; --g) {
            for (int gmult = 2 * g; gmult < a_max; gmult += g) {
                t[g] = SUB(t[g], t[gmult]);
            }
            if (t[g] != 0) {
                long gInv = modInverse(g);
                //new BigInteger(Long.toString(g)).modInverse(new BigInteger(Integer.toString(998244353))).longValue();
                answer = SUM(answer, MULT(t[g], gInv));
            }
        }

        if (answer < 0) {
            answer += MODULO;
        }

        System.out.println(answer);
    }

    private static long modInverse(long a) {
        long b = MODULO;
        long s = 0;
        long old_s = 1;
        long t = 1;
        long old_t = 0;
        long r = b;
        long old_r = a;

        while (r != 0) {
            long quotient = old_r / r;
            long temp = r;
            r = old_r - quotient * r;
            old_r = temp;
            temp = s;
            s = old_s - quotient * s;
            old_s = temp;
            temp = t;
            t = old_t - quotient * t;
            old_t = temp;
        }
        //long gcd = old_r;
        long x = old_s;
        //long y = old_t;
        if (x < 0) {
            x += b;
        }

        return x;
    }

    private static long MULT(long a, long b) {
        return (a * b) % MODULO;
    }

    private static long SUM(long a, long b) {
        return (a + b) % MODULO;
    }

    private static long SUB(long a, long b) {
        long r = (a - b) % MODULO;
        if (r < 0) {
            r += MODULO;
        }
        return r;
    }
}
