package com.github.zhve.spoj;

/**
 * <a href="http://www.spoj.com/problems/ACODE">http://www.spoj.com/problems/ACODE</a>
 */
public class ACODE {
    static byte[] BUF = new byte[30];
    static int LEN_BUF = 0;
    static byte[] IN = new byte[100000];
    static int IN_INDEX = 0;
    static byte[] OUT = new byte[100000];
    static int LEN_OUT = 0;

    public static void main(String[] args) throws Exception {
        System.in.read(IN, 0, IN.length);
        long R, k, n, n1 = 0L;
        int c1, c2 = '1';
        R = 1L;
        while (true) {
            c1 = c2;
            c2 = IN[IN_INDEX++];
            if (c2 == '\n') {
                while (R > 9L) {
                    BUF[LEN_BUF++] = (byte) (R % 10L + (long) '0');
                    R /= 10L;
                }
                BUF[LEN_BUF++] = (byte) (R + (long) '0');
                while (LEN_BUF > 0) {
                    OUT[LEN_OUT++] = BUF[--LEN_BUF];
                }
                OUT[LEN_OUT++] = '\n';
                n1 = 0L;
                R = 1L;
            } else {
                n = R;
                switch (c2) {
                    case '0':
                        if (c1 != '1' && c1 != '2') {
                            System.out.write(OUT, 0, LEN_OUT);
                            return;
                        }
                        R = n1;
                        break;
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                        if (c1 != '1' && c1 != '2') {
                            break;
                        }
                        R += n1;
                        break;
                    case '7':
                    case '8':
                    case '9':
                        if (c1 != '1') {
                            break;
                        }
                        R += n1;
                }
                n1 = n;
            }
        }
    }
}
