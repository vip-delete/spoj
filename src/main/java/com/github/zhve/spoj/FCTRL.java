package com.github.zhve.spoj;

/**
 * <a href="http://www.spoj.com/problems/FCTRL/">http://www.spoj.com/problems/FCTRL/</a>
 */
public class FCTRL {
    public static void main(String args[]) throws Exception {
        byte[] T = new byte[20];
        int LENT = 0;
        byte[] B = new byte[1000000];
        int LEN = 0;
        int n;
        int c;
        for (n = 0; (c = System.in.read()) != 10; n = (n * 10 + c) - '0') {
            ;
        }
        for (int j = 0; j < n; j++) {
            int k;
            for (k = 0; (c = System.in.read()) != 10; k = (k * 10 + c) - '0') {
                ;
            }
            int R;
            for (R = 0; k >= 5; R += k /= 5) {
                ;
            }
            for (; R > 9; R = k) {
                k = R / 10;
                T[LENT++] = (byte) ((R - 10 * k) + '0');
            }
            for (T[LENT++] = (byte) (R + '0'); LENT > 0; B[LEN++] = T[--LENT]) {
                ;
            }
            B[LEN++] = '\n';
        }
        System.out.write(B, 0, LEN);
    }
}
