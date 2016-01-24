package com.github.zhve.spoj;

/**
 * <a href="http://www.spoj.com/problems/COINS/">http://www.spoj.com/problems/COINS/</a>
 */
public class COINS {
    static byte[] T = new byte[20];
    static int LENT = 0;
    static final byte[] IN = new byte[256];
    static int IN_INDEX = 0;
    static final byte[] OUT = new byte[256];
    static int OUT_INDEX = 0;

    public static void main(String[] args) throws Exception { /* for (long i = 1000000000; i <= 1000000000; i++) { System.out.println(i + "\t" + max(i)); } */
        final int MAX = System.in.read(IN, 0, IN.length);
        byte c;
        long n;
        while (IN_INDEX < MAX) {
            n = 0;
            while ((c = IN[IN_INDEX++]) != '\n') {
                n = n * 10 + c - '0';
            }
            n = max(n);
            LENT = 0;
            while (n > 9) {
                T[LENT++] = (byte) (n % 10 + '0');
                n /= 10;
            }
            T[LENT++] = (byte) (n + '0');
            while (LENT > 0) {
                OUT[OUT_INDEX++] = T[--LENT];
            }
            OUT[OUT_INDEX++] = '\n';
        }
        System.out.write(OUT, 0, OUT_INDEX);
    }

    static int[] cache = new int[1000000];

    private static long max(long n) {
        if (n >= 1000000) {
            return Math.max(n, max(n >> 1) + max(n / 3) + max(n >> 2));
        } else {
            int N = (int) n;
            int r = cache[N];
            if (r == 0) {
                r = N < 12 ? N : Math.max(N, m(N >> 1) + m(N / 3) + m(N >> 2));
                cache[N] = r;
            }
            return r;
        }
    }

    private static int m(int n) {
        int r = cache[n];
        if (r == 0) {
            r = n < 12 ? n : Math.max(n, m(n >> 1) + m(n / 3) + m(n >> 2));
            cache[n] = r;
        }
        return r;
    }
}
