package com.github.zhve.spoj;

/**
 * <a href="http://www.spoj.com/problems/ONP/">http://www.spoj.com/problems/ONP/</a>
 */
public class ONP {
    static byte[] B = new byte[400];
    static int LEN = 0;

    static void readline() throws Exception
    {
        LEN = 0;
        int c;
        while (true)
        {
            c = System.in.read();
            if (c == -1) ;
            else if (c == '\n')
                return;
            else
                B[LEN++] = (byte) c;
        }
    }

    static int readInteger() throws Exception
    {
        int r = 0;
        int c;
        while (true)
        {
            c = System.in.read();
            if (c == -1) ;
            else if (c == '\n')
                return r;
            else
                r = r * 10 + c - '0';
        }
    }

    public static void main(String[] args) throws Exception
    {
        int n = readInteger();
        byte[] stack = new byte[400];
        int lastIndex;
        int i, j, k;
        byte c;
        boolean needNext;
        for (i = 0; i < n; i++)
        {
            k = 0;
            lastIndex = -1;
            readline();
            for (j = 0; j < LEN; j++)
            {
                c = B[j];
                switch (c)
                {
                    case '(':
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                    case '^':
                        stack[++lastIndex] = c;
                        break;
                    case 'q':
                    case 'w':
                    case 'e':
                    case 'r':
                    case 't':
                    case 'y':
                    case 'u':
                    case 'i':
                    case 'o':
                    case 'p':
                    case 'a':
                    case 's':
                    case 'd':
                    case 'f':
                    case 'g':
                    case 'h':
                    case 'j':
                    case 'k':
                    case 'l':
                    case 'z':
                    case 'x':
                    case 'c':
                    case 'v':
                    case 'b':
                    case 'n':
                    case 'm':
                        B[k++] = c;
                        break;
                    case ')':
                        needNext = true;
                        while (needNext)
                        {
                            c = stack[lastIndex];
                            switch (c)
                            {
                                case '(':
                                    lastIndex--;
                                    needNext = false;
                                    break;
                                case '+':
                                case '-':
                                case '*':
                                case '/':
                                case '^':
                                    B[k++] = c;
                                    lastIndex--;
                                    break;
                                default:
                                    needNext = false;
                            }
                        }
                }
            }
            while (lastIndex >= 0)
            {
                c = stack[lastIndex--];
                if (c != '(')
                    B[k++] = c;
            }
            B[k++] = '\n';
            System.out.write(B, 0, k);
        }
    }
}
