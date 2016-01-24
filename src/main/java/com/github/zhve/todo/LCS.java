package com.github.zhve.todo;

/**
 * TODO: time limit exceeded
 * <a href="http://www.spoj.com/problems/LCS/">http://www.spoj.com/problems/LCS/</a>
 */
public class LCS {
    public static void main(String[] args) throws Exception
    {
        int max, min, her, tmp, i, j, b_a, a, b, c;
        byte[] IN = new byte[1 << 22];

        a = 0;
        while ((c = System.in.read()) != '\n') IN[a++] = (byte) c;

        b = a;
        while ((c = System.in.read()) != '\n') IN[b++] = (byte) c;

        max = 0;
        b_a = b - a;
        for (i = 0; i < a; i++)
        {
            tmp = 0;
            her = a - i;
            min = a < her ? a : her;
            if (min <= max) break;
            for (j = 0; j < min; j++)
                if (IN[i + j] == IN[j + a])
                    tmp++;
                else
                {
                    if (tmp > max) max = tmp;
                    tmp = 0;
                    if (min - i <= max) break;
                }
            if (tmp > max) max = tmp;
        }

        for (j = 1; j < b_a; j++)
        {
            tmp = 0;
            her = b_a - j;
            min = a < her ? a : her;
            if (min <= max) break;
            for (i = 0; i < min; i++)
                if (IN[i] == IN[j + i + a])
                    tmp++;
                else
                {
                    if (tmp > max) max = tmp;
                    tmp = 0;
                    if (min - i <= max) break;
                }
            if (tmp > max) max = tmp;
        }
        System.out.println(max);
    }
}
