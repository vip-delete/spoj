package com.github.zhve.todo;

/**
 * TODO: time limit exceeded
 * <a href="http://www.spoj.com/problems/SOLVING/">http://www.spoj.com/problems/SOLVING/</a>
 */
public class SOLVING {
    static java.util.Scanner s = new java.util.Scanner(System.in);
    static int[][] t = new int[100][100];       //table
    static int[][] r = new int[100][100];       //duplicate result table
    static int m;                               //table size (m*m)
    static int x;                               //hole x coordinate
    static int y;                               //hole y cordinate
    static int c;                               //temp cell value
    static byte[] stack = new byte[40];        //deep search stack
    static byte next;                           //next step
    static byte prev;                           //prev step
    static int ptr;                             //stack current size
    static int unSynhronized = 0;

    public static void main(String[] args) throws Exception {
        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            init();

            //go deep search
            while (ptr >= 0 && unSynhronized > 0) {
                if (!goForvard()) {
                    if (ptr == 0) {
                        continue;
                    }
                    next = stack[--ptr];
                }
            }

            if (unSynhronized == 0) {
                stack[ptr++] = '\n';
                System.out.write(stack, 0, ptr);
            } else {
                throw new Exception("Can't solved!");
            }
        }
    }

    static void init() {
        ptr = 0;
        m = s.nextInt();
        unSynhronized = 0;
        int counter = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                c = s.nextInt();
                if (c == 0) {
                    y = i;
                    x = j;
                } else {
                    if (c != counter) {
                        unSynhronized++;
                    }
                }
                t[i][j] = c;
                r[i][j] = counter++;
            }
        }
        m--;
    }

    static boolean goForvard() {
        if (ptr == stack.length) {
            return false;
        }

        int dx = 0;
        int dy = 0;
        if (prev != 'D' && next != 'U' && next != 'R' && next != 'D' && next != 'L' && y > 0) {
            dy = -1;
            prev = 'U';
        } else if (prev != 'L' && next != 'R' && next != 'D' && next != 'L' && x < m) {
            dx = 1;
            prev = 'R';
        } else if (prev != 'U' && next != 'D' && next != 'L' && y < m) {
            dy = 1;
            prev = 'D';
        } else if (prev != 'R' && next != 'L' && x > 0) {
            dx = -1;
            prev = 'L';
        } else {
            return false;
        }

        stack[ptr++] = prev;

        int rdst = r[y + dy][x + dx];
        int rsrc = r[y][x];

        c = t[y + dy][x + dx];

        if (c == rsrc) {
            unSynhronized--;
        } else if (c == rdst) {
            unSynhronized++;
        }

        t[y][x] = c;

        x += dx;
        y += dy;

        t[x][y] = 0;

        return true;
    }
}
