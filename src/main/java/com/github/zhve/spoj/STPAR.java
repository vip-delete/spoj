package com.github.zhve.spoj;

/**
 * <a href="http://www.spoj.com/problems/STPAR/">http://www.spoj.com/problems/STPAR/</a>
 */
public class STPAR {
    public static void main(String[] args) throws Exception {
        for (int i = nextInt(); i > 0; i = nextInt()) {
            // read data
            int[] input = new int[1000];
            for (int j = 0; j < i; j++) {
                input[j] = nextInt();
            }
            int inputIndex = 0;

            // init stack
            int[] stack = new int[1000];
            int stackIndex = -1;

            // true if number in stack
            boolean[] inStack = new boolean[1001];

            // expected number
            int needInt = 1;

            while (true) {
                int num1 = inputIndex < i ? input[inputIndex] : -1;
                int num2 = stackIndex >= 0 ? stack[stackIndex] : -1;

                if (num1 == needInt) {
                    inputIndex++;
                    needInt++;
                } else if (num2 == needInt) {
                    stackIndex--;
                    needInt++;
                } else if (num1 > 0) {
                    if (inStack[needInt]) {
                        System.out.println("no");
                        break;
                    }
                    stack[++stackIndex] = num1;
                    inputIndex++;
                    inStack[num1] = true;
                } else {
                    System.out.println(stackIndex == -1 ? "yes" : "no");
                    break;
                }
            }
        }
    }

    static int nextInt() throws Exception {
        int r = 0;
        int c;
        while (true) {
            c = System.in.read();
            if (c == ' ' || c == '\n' || c == -1) {
                return r;
            }
            r = r * 10 + c - '0';
        }
    }
}
