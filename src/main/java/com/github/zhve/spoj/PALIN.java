package com.github.zhve.spoj;

/**
 * <a href="http://www.spoj.com/problems/PALIN/">http://www.spoj.com/problems/PALIN/</a>
 */
public class PALIN {
    public static void main(String[] args) throws Exception
    {
        final java.io.BufferedReader r = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        final int n = Integer.parseInt(r.readLine());
        byte[] b = new byte[1000000];
        int len;
        char[] chars;
        int i, j, k;
        String s;
        for (i = 0; i < n; i++)
        {
            s = r.readLine();
            len = s.length();
            j = 0;
            chars = s.toCharArray();
            for (char c : chars)
                b[j++] = (byte) c;

            //comparing...
            j = len >> 1;
            k = len - j - 1;
            while (j < len && b[k] == b[j])
            {
                j++;
                k--;
            }
            if (j == len || b[k] < b[j])
            {
                //polinom found... or left < right
                //left += 1
                j = (len >> 1) + ((len & 1) - 1);
                while (j >= 0 && b[j] == '9') j--;
                if (j == -1)
                {
                    //all is 9...
                    b[0] = '1';
                    for (j = 1; j < len; j++) b[j] = '0';
                    b[len] = '1';
                    len++;
                }
                else
                {
                    //we can to plus 1
                    b[j]++;
                    for (k = len >> 1; k > j; k--) b[k] = '0';
                    for (k = len >> 1; k < len; k++) b[k] = b[len - k - 1];
                }
            }
            else
            {
                //left > right!
                for (j = len >> 1, k = len - j - 1; j < len; j++, k--) b[j] = b[k];
            }
            b[len] = '\n';
            System.out.write(b, 0, len + 1);
        }
    }
}
