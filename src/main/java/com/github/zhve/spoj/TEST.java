package com.github.zhve.spoj;

/**
 * <a href="http://www.spoj.com/problems/TEST/">http://www.spoj.com/problems/TEST/</a>
 */
public class TEST {
    public static void main(String[] args) throws Exception {
        int c;
        byte[] b = new byte[100];
        int k = 0;
        byte state = 0;
        while (true) {
            c = System.in.read();
            switch (c) {
                case -1:
                    break;
                case '2':
                    switch (state) {
                        case 0:
                            b[k++] = (byte) c;
                            break;
                        case 1:
                            System.out.write(b, 0, k - 2);
                            return;
                    }
                    break;
                case '4':
                    state = 1;
                    b[k++] = (byte) c;
                    break;
                default:
                    state = 0;
                    b[k++] = (byte) c;
            }
        }
    }
}
