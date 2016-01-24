package com.github.zhve.spoj;

import java.util.Scanner;

/**
 * <a href="http://www.spoj.com/problems/KAMIL/">http://www.spoj.com/problems/KAMIL/</a>
 */
public class KAMIL {
    public static void main(String[] a) {
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println(1 << s.nextLine().replaceAll("[^FLDT]", "").length());
        }
    }
}
