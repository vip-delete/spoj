package com.github.zhve.spoj;

/**
 * <a href="http://www.spoj.com/problems/ADDREV">http://www.spoj.com/problems/ADDREV</a>
 */
public class ADDREV {
    static byte[] T = new byte[30];
    static int LEN_T = 0;
    static byte[] IN = new byte[1 << 22];
    static int IN_INDEX = 0;
    static byte[] OUT = new byte[1 << 22];
    static int LEN_OUT = 0;
    static int R;

    public static void main(String[] args) throws Exception {
        System.in.read(IN, 0, IN.length);
        int c, n, s, e, i1, i2, l;
        byte t, m;
        boolean f;
        n = 0;
        while ((c = IN[IN_INDEX++]) != '\n') {
            n = n * 10 + c - '0';
        }
        for (int i = 0; i < n; i++) {
            l = LEN_OUT;
            f = false;
            m = 0;
            s = IN_INDEX + 1;
            while (IN[s] != ' ') {
                s++;
            }
            e = s + 2;
            while (IN[e] != '\n') {
                e++;
            }
            i1 = IN_INDEX;
            i2 = s + 1;
            while (i1 < s && i2 < e) {
                t = (byte) (IN[i1] + IN[i2] + m - '0');
                if (t >= '0' + 10) {
                    t -= 10;
                    m = 1;
                } else {
                    m = 0;
                }
                if (f) {
                    OUT[LEN_OUT++] = t;
                } else {
                    if (t != '0') {
                        OUT[LEN_OUT++] = t;
                        f = true;
                    }
                }
                i1++;
                i2++;
            }
            if (i1 == s) {
                i1 = i2;
                s = e;
            }
            while (i1 < s) {
                t = (byte) (IN[i1] + m);
                if (t >= '0' + 10) {
                    t -= 10;
                    m = 1;
                } else {
                    m = 0;
                }
                if (f) {
                    OUT[LEN_OUT++] = t;
                } else {
                    if (t != '0') {
                        OUT[LEN_OUT++] = t;
                        f = true;
                    }
                }
                i1++;
            }
            if (m == 1) {
                OUT[LEN_OUT++] = '1';
            }
            while (LEN_OUT > l && OUT[LEN_OUT - 1] == '0') {
                LEN_OUT--;
            }
            if (LEN_OUT == l) {
                OUT[LEN_OUT++] = '0';
            }
            OUT[LEN_OUT++] = '\n';
            IN_INDEX = e + 1;
        }
        System.out.write(OUT, 0, LEN_OUT);
    }
}
