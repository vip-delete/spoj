package com.github.zhve.spoj;

/**
 * <a href="http://www.spoj.com/problems/ACS">http://www.spoj.com/problems/ACS</a>
 */
public class ACS {
    static byte[] T = new byte[30];
    static int LEN_T = 0;
    static byte[] IN = new byte[1000000];
    static int LEN_IN = 0;
    static int IN_INDEX = 0;
    static byte[] OUT = new byte[1000000];
    static int LEN_OUT = 0;
    static int R;

    public static void main(String[] args) throws Exception {
        LEN_IN = System.in.read(IN, 0, IN.length);
        int[] rowIndex = new int[1234];
        for (int i = 0; i < rowIndex.length; i++) {
            rowIndex[i] = i;
        }
        int[] colIndex = new int[5678];
        for (int i = 0; i < colIndex.length; i++) {
            colIndex[i] = i;
        }
        int c, x, y, z, tmp;
        while (IN_INDEX < LEN_IN) {
            c = IN[IN_INDEX];
            IN_INDEX += 2;
            switch (c) {
                case (byte) 'R':
                    x = 0;
                    while ((c = IN[IN_INDEX++]) != ' ') {
                        x = x * 10 + c - '0';
                    }
                    x--;
                    y = 0;
                    while ((c = IN[IN_INDEX++]) != '\n') {
                        y = y * 10 + c - '0';
                    }
                    y--;
                    tmp = rowIndex[x];
                    rowIndex[x] = rowIndex[y];
                    rowIndex[y] = tmp;
                    break;
                case (byte) 'C':
                    x = 0;
                    while ((c = IN[IN_INDEX++]) != ' ') {
                        x = x * 10 + c - '0';
                    }
                    x--;
                    y = 0;
                    while ((c = IN[IN_INDEX++]) != '\n') {
                        y = y * 10 + c - '0';
                    }
                    y--;
                    tmp = colIndex[x];
                    colIndex[x] = colIndex[y];
                    colIndex[y] = tmp;
                    break;
                case (byte) 'Q':
                    x = 0;
                    while ((c = IN[IN_INDEX++]) != ' ') {
                        x = x * 10 + c - '0';
                    }
                    x--;
                    y = 0;
                    while ((c = IN[IN_INDEX++]) != '\n') {
                        y = y * 10 + c - '0';
                    }
                    y--;
                    R = rowIndex[x] * 5678 + colIndex[y] + 1;
                    LEN_T = 0;
                    while (R > 9) {
                        T[LEN_T++] = (byte) (R % 10 + '0');
                        R /= 10;
                    }
                    T[LEN_T] = (byte) (R + '0');
                    while (LEN_T >= 0) {
                        OUT[LEN_OUT++] = T[LEN_T--];
                    }
                    OUT[LEN_OUT++] = '\n';
                    break;
                case (byte) 'W':
                    z = 0;
                    while ((c = IN[IN_INDEX++]) != '\n') {
                        z = z * 10 + c - '0';
                    }
                    z--;
                    y = z / 5678;
                    x = z % 5678;
                    R = y;
                    while (rowIndex[R] != y) {
                        R = rowIndex[R];
                    }
                    R++;
                    LEN_T = 0;
                    while (R > 9) {
                        T[LEN_T++] = (byte) (R % 10 + '0');
                        R /= 10;
                    }
                    T[LEN_T] = (byte) (R + '0');
                    while (LEN_T >= 0) {
                        OUT[LEN_OUT++] = T[LEN_T--];
                    }
                    OUT[LEN_OUT++] = ' ';
                    R = x;
                    while (colIndex[R] != x) {
                        R = colIndex[R];
                    }
                    R++;
                    LEN_T = 0;
                    while (R > 9) {
                        T[LEN_T++] = (byte) (R % 10 + '0');
                        R /= 10;
                    }
                    T[LEN_T] = (byte) (R + '0');
                    while (LEN_T >= 0) {
                        OUT[LEN_OUT++] = T[LEN_T--];
                    }
                    OUT[LEN_OUT++] = '\n';
                    break;
            }
        }
        System.out.write(OUT, 0, LEN_OUT);
    }
}
