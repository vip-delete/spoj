package com.github.zhve.spoj;

/**
 * <a href="http://www.spoj.com/problems/MMASS/">http://www.spoj.com/problems/MMASS/</a>
 */
public class MMASS {
    public static void main(String[] args) throws Exception {
        int[] stack = new int[512];
        int len = 0;
        int current = 0;
        while (true) {
            switch (System.in.read()) {
                case '(':
                    stack[++len] = 0;
                    current = 0;
                    break;
                case ')':
                    current = stack[len--];
                    stack[len] += current;
                    break;
                case '2':
                    stack[len] += current;
                    break;
                case '3':
                    stack[len] += current << 1;
                    break;
                case '4':
                    stack[len] += current * 3;
                    break;
                case '5':
                    stack[len] += current << 2;
                    break;
                case '6':
                    stack[len] += current * 5;
                    break;
                case '7':
                    stack[len] += current * 6;
                    break;
                case '8':
                    stack[len] += current * 7;
                    break;
                case '9':
                    stack[len] += current << 3;
                    break;
                case 'O':
                    stack[len] += current = 16;
                    break;
                case 'C':
                    stack[len] += current = 12;
                    break;
                case 'H':
                    stack[len] += current = 1;
                    break;
                case '\n':
                    System.out.println(stack[len]);
                    return;
            }
        }
    }
}
