package com.github.zhve.todo;

import java.util.Arrays;

/**
 * TODO: runtime error
 * <a href="http://www.spoj.com/problems/AGGRCOW">http://www.spoj.com/problems/AGGRCOW</a>
 */
public class AGGRCOW {
    private static final long[] STALLS = new long[200000];
    private static int N, C;

    public static void main(String[] args) throws Exception
    {
        byte[] IN = new byte[1 << 21];
        int IN_INDEX = 0;
        System.in.read(IN, 0, IN.length);
        int c;
        int t = 0;
        while ((c = IN[IN_INDEX++]) != '\n') t = t * 10 + c - '0';
        long S;
        for (int i = 0; i < t; i++)
        {
            N = 0;
            C = 0;
            while ((c = IN[IN_INDEX++]) != ' ') N = N * 10 + c - '0';
            while ((c = IN[IN_INDEX++]) != '\n') C = C * 10 + c - '0';

            for (int j = 0; j < N; j++)
            {
                S = 0;
                while ((c = IN[IN_INDEX++]) != '\n') S = S * 10L + c - '0';
                STALLS[j] = S;
            }

            Arrays.sort(STALLS, 0, N);

            long MIN = 1;
            long MAX = STALLS[N - 1] / C;
            long MID;

            while (MIN < MAX)
            {
                MID = (MAX + MIN) >> 1;
                if (isAllowed(MID))
                    MIN = MID + 1;
                else
                    MAX = MID - 1;
            }

            System.out.println(MAX);
        }
    }

    private static boolean isAllowed(long n)
    {
        int prevCowIndex = 0;
        int cows = 1;
        while (cows < C)
        {
            int cowIndex = prevCowIndex + 1;
            while (cowIndex < N && (STALLS[cowIndex] - STALLS[prevCowIndex] < n)) cowIndex++;
            if (cowIndex == N) return false;
            prevCowIndex = cowIndex;
            cows++;
        }
        return true;
    }
}
