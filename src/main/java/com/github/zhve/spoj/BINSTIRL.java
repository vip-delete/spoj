package com.github.zhve.spoj;

/**
 * <a href="http://www.spoj.com/problems/BINSTIRL/">http://www.spoj.com/problems/BINSTIRL/</a>
 */
public class BINSTIRL {
    public static void main(String[] args) throws Exception {
        int d = 0, n, m, c;
        byte[] in = new byte[8000];
        int x = 0;
        byte[] OUT = new byte[400];
        int y = 0;
        System.in.read(in, 0, in.length);
        for (; (c = in[x++]) != '\n'; d = d * 10 + c - '0') {
            ;
        }
        for (int i = 0; i < d; i++) {
            n = 0;
            m = 0;
            for (; (c = in[x++]) != (byte) ' '; n = n * 10 + c - '0') {
                ;
            }
            for (; (c = in[x++]) != (byte) '\n'; m = m * 10 + c - '0') {
                ;
            }
            OUT[y++] = (((n - m) & ((m - 1) >> 1)) == 0) ? (byte) '1' : (byte) '0';
            OUT[y++] = '\n';
        }
        System.out.write(OUT, 0, y);
    }
}
