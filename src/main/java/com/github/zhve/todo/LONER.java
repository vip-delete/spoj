package com.github.zhve.todo;

import java.util.regex.Pattern;

/**
 * TODO: time limit exceeded, wrong answer
 * <a href="http://www.spoj.com/problems/LONER/">http://www.spoj.com/problems/LONER/</a>
 */
public class LONER {
    public static void main(String[] args) throws Exception {
        int k = 0;
        byte[] data = new byte[1 << 20];
        System.in.read(data, 0, data.length);

        int c;
        int n;
        for (n = 0; (c = data[k++]) != '\n'; n = n * 10 + c - '0') {
            ;
        }

        int len;
        Pattern p1 = Pattern.compile("11001");
        Pattern p2 = Pattern.compile("01011");
        Pattern p3 = Pattern.compile("10011");
        Pattern p4 = Pattern.compile("11010");
        Pattern p5 = Pattern.compile("000110");
        Pattern p6 = Pattern.compile("011000");
        Pattern x = Pattern.compile("(0)*(1{1})(0)*");
        for (int i = 0; i < n; i++) {
            for (len = 0; (c = data[k++]) != '\n'; len = len * 10 + c - '0') {
                ;
            }
            String str = new String(data, k, len);
            k += len + 1;

            while (true) {
                String pre = new String(str);
                str = p1.matcher(str).replaceAll("00101");
                str = p2.matcher(str).replaceAll("01100");
                //str = p3.matcher(str).replaceAll("10100");
                //str = p4.matcher(str).replaceAll("00110");
                //str = p5.matcher(str).replaceAll("000001");
                //str = p6.matcher(str).replaceAll("100000");

                if (x.matcher(str).matches()) {
                    System.out.println("yes");
                    break;
                }

                if (pre.equals(str)) {
                    System.out.println("no");
                    break;
                }
            }
        }
    }
}
