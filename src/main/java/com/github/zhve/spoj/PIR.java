package com.github.zhve.spoj;

/**
 * <a href="http://www.spoj.com/problems/PIR/">http://www.spoj.com/problems/PIR/</a>
 */
public class PIR {
    public static void main(String[] args) throws Exception {
        int k = 0;
        byte[] data = new byte[10000];
        System.in.read(data, 0, data.length);
        int c;
        int n;
        for (n = 0; (c = data[k++]) != '\n'; n = n * 10 + c - '0') {
            ;
        }
        int a1, a2, a3, b1, b2, b3;
        for (int i = 0; i < n; i++) {
            for (a1 = 0; (c = data[k++]) != ' '; a1 = a1 * 10 + c - '0') {
                ;
            }
            for (a2 = 0; (c = data[k++]) != ' '; a2 = a2 * 10 + c - '0') {
                ;
            }
            for (a3 = 0; (c = data[k++]) != ' '; a3 = a3 * 10 + c - '0') {
                ;
            }
            for (b1 = 0; (c = data[k++]) != ' '; b1 = b1 * 10 + c - '0') {
                ;
            }
            for (b2 = 0; (c = data[k++]) != ' '; b2 = b2 * 10 + c - '0') {
                ;
            }
            for (b3 = 0; (c = data[k++]) != '\n'; b3 = b3 * 10 + c - '0') {
                ;
            }

            int aa1 = a1 * a1;
            int aa2 = a2 * a2;
            int aa3 = a3 * a3;
            int bb1 = b1 * b1;
            int bb2 = b2 * b2;
            int bb3 = b3 * b3;

            double cosa = (double) (aa3 - aa1 + bb2) / (double) (2 * a3 * b2);
            double cosb = (double) (bb2 - bb1 + bb3) / (double) (2 * b2 * b3);
            double cosc = (double) (aa3 + bb3 - aa2) / (double) (2 * a3 * b3);
            double sqrt = 1 + 2 * cosa * cosb * cosc - cosa * cosa - cosb * cosb - cosc * cosc;

            double volume = (a3 * b2 * b3 * StrictMath.sqrt(sqrt)) / 6.0;

            long v = (long) StrictMath.floor(volume * 10000.0 + 0.5d);
            long x = v / 10000;
            long y = v % 10000;
            System.out.print(Long.toString(x));
            if (y < 10) {
                System.out.print(".000");
            } else if (y < 100) {
                System.out.print(".00");
            } else if (y < 1000) {
                System.out.print(".0");
            } else {
                System.out.print(".");
            }
            System.out.println(y);
        }
    }
}
