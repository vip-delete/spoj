package com.github.zhve.todo;

/**
 * TODO: wrong answer
 * <a href="http://www.spoj.com/HSPLARCH/problems/HS08TEST/">http://www.spoj.com/HSPLARCH/problems/HS08TEST/</a>
 */
public class ATM {
    public static void main(String[] args) throws Exception {
        byte[] IN = new byte[128];
        int IN_INDEX = 0;
        System.in.read(IN, 0, IN.length);
        int c;
        int t = 0;
        while ((c = IN[IN_INDEX++]) != ' ') {
            t = t * 10 + c - '0';
        }
        int b = 0;
        while (IN_INDEX < IN.length && (c = IN[IN_INDEX++]) != '\n') {
            if (c != '.') {
                b = b * 10 + c - '0';
            }
        }

        int r = (t % 5) == 0 ? b - t * 100 - 50 : b;

        if (r < 0) {
            r = b;
        }

        int x = r / 100;
        int y = r % 100;

        System.out.print(x);
        System.out.print('.');

        if (y < 10) {
            System.out.print('0');
        }
        System.out.print(y);
    }
}
