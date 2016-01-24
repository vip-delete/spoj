package com.github.zhve.spoj;

/**
 * <a href="http://www.spoj.com/problems/MAYA/">http://www.spoj.com/problems/MAYA/</a>
 */
public class MAYA {
    public static void main(String[] args) throws Exception {
        int d, c;
        byte[] in = new byte[8000];
        int len = 0;
        long[] coff = new long[]{1L, 20L, 360L, 7200L, 144000L, 2880000L, 57600000L};
        System.in.read(in);
        do {
            d = 0;
            for (; (c = in[len++]) != '\n'; d = d * 10 + c - '0') {
                ;
            }
            if (d == 0) {
                return;
            }
            long n = 0L;
            for (int i = 0; i < d; i++) {
                int points = 0;
                int dashes = 0;
                if (in[len] == 'S') {
                    len++;
                    len++;
                } else {
                    while ((c = in[len++]) != '\n') {
                        switch (c) {
                            case '.':
                                points++;
                                break;
                            case '-':
                                dashes++;
                                break;
                        }
                    }
                }
                n += (points + dashes * 5) * coff[d - 1 - i];
            }
            System.out.println(Long.toString(n));
            len++;
        } while (true);
    }
}
