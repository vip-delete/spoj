package com.github.zhve.spoj;

/**
 * <a href="http://www.spoj.com/problems/JAVAC/">http://www.spoj.com/problems/JAVAC/</a>
 */
public class JAVAC {
    public static void main(String[] args) throws Exception {
        byte[] in = new byte[1 << 20];
        int len = System.in.read(in, 0, 1 << 20);

        System.out.println(toggle(new String(in, 0, len)));
    }

    public static String toggle(String input) {
        char[] chars = input.toCharArray();
        byte[] IN = new byte[chars.length];
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c <= 0 || c >= 128) {
                throw new IllegalArgumentException("For char code: " + c + "=" + (int) c + ", allowed 0 < c < 128");
            }
            IN[i] = (byte) c;
        }
        int IN_INDEX = 0;
        byte[] OUT = new byte[1 << 20];//invinit
        int OUT_INDEX = 0;
        int inputSize = IN.length;
        byte prev = '\n';
        byte next;
        int begin = 0;
        int status = 0;//0 - unknown. 1 - java, 2 - c++
        while (IN_INDEX < inputSize) {
            next = IN[IN_INDEX++];
            switch (next) {
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    switch (prev) {
                        case 'a':
                        case 'b':
                        case 'c':
                        case 'd':
                        case 'e':
                        case 'f':
                        case 'g':
                        case 'h':
                        case 'i':
                        case 'j':
                        case 'k':
                        case 'l':
                        case 'm':
                        case 'n':
                        case 'o':
                        case 'p':
                        case 'q':
                        case 'r':
                        case 's':
                        case 't':
                        case 'u':
                        case 'v':
                        case 'w':
                        case 'x':
                        case 'y':
                        case 'z':
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                        case 'G':
                        case 'H':
                        case 'I':
                        case 'J':
                        case 'K':
                        case 'L':
                        case 'M':
                        case 'N':
                        case 'O':
                        case 'P':
                        case 'Q':
                        case 'R':
                        case 'S':
                        case 'T':
                        case 'U':
                        case 'V':
                        case 'W':
                        case 'X':
                        case 'Y':
                        case 'Z':
                        case '\n':
                            OUT[OUT_INDEX++] = next;
                            break;
                        case '_':
                            switch (status) {
                                case 0:
                                    status = 2;
                                    OUT[OUT_INDEX++] = (byte) (next - ('a' - 'A'));
                                    break;
                                case 1:
                                    OUT_INDEX = begin;
                                    OUT[OUT_INDEX++] = 'E';
                                    OUT[OUT_INDEX++] = 'r';
                                    OUT[OUT_INDEX++] = 'r';
                                    OUT[OUT_INDEX++] = 'o';
                                    OUT[OUT_INDEX++] = 'r';
                                    OUT[OUT_INDEX++] = '!';
                                    OUT[OUT_INDEX++] = '\n';
                                    while (IN[IN_INDEX++] != '\n') {
                                        ;
                                    }
                                    next = '\n';
                                    begin = OUT_INDEX;
                                    status = 0;
                                    break;
                                case 2:
                                    OUT[OUT_INDEX++] = (byte) (next - ('a' - 'A'));
                                    break;
                            }
                            break;
                    }
                    break;
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                    switch (prev) {
                        case 'a':
                        case 'b':
                        case 'c':
                        case 'd':
                        case 'e':
                        case 'f':
                        case 'g':
                        case 'h':
                        case 'i':
                        case 'j':
                        case 'k':
                        case 'l':
                        case 'm':
                        case 'n':
                        case 'o':
                        case 'p':
                        case 'q':
                        case 'r':
                        case 's':
                        case 't':
                        case 'u':
                        case 'v':
                        case 'w':
                        case 'x':
                        case 'y':
                        case 'z':
                            switch (status) {
                                case 0:
                                    status = 1;
                                case 1:
                                    OUT[OUT_INDEX++] = '_';
                                    OUT[OUT_INDEX++] = (byte) (next + ('a' - 'A'));
                                    break;
                                case 2:
                                    OUT_INDEX = begin;
                                    OUT[OUT_INDEX++] = 'E';
                                    OUT[OUT_INDEX++] = 'r';
                                    OUT[OUT_INDEX++] = 'r';
                                    OUT[OUT_INDEX++] = 'o';
                                    OUT[OUT_INDEX++] = 'r';
                                    OUT[OUT_INDEX++] = '!';
                                    OUT[OUT_INDEX++] = '\n';
                                    while (IN[IN_INDEX++] != '\n') {
                                        ;
                                    }
                                    next = '\n';
                                    begin = OUT_INDEX;
                                    status = 0;
                                    break;
                            }
                            break;
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                        case 'G':
                        case 'H':
                        case 'I':
                        case 'J':
                        case 'K':
                        case 'L':
                        case 'M':
                        case 'N':
                        case 'O':
                        case 'P':
                        case 'Q':
                        case 'R':
                        case 'S':
                        case 'T':
                        case 'U':
                        case 'V':
                        case 'W':
                        case 'X':
                        case 'Y':
                        case 'Z':
                            OUT[OUT_INDEX++] = '_';
                            OUT[OUT_INDEX++] = (byte) (next + ('a' - 'A'));
                            break;
                        case '_':
                        case '\n':
                            OUT_INDEX = begin;
                            OUT[OUT_INDEX++] = 'E';
                            OUT[OUT_INDEX++] = 'r';
                            OUT[OUT_INDEX++] = 'r';
                            OUT[OUT_INDEX++] = 'o';
                            OUT[OUT_INDEX++] = 'r';
                            OUT[OUT_INDEX++] = '!';
                            OUT[OUT_INDEX++] = '\n';
                            while (IN_INDEX < inputSize && IN[IN_INDEX++] != '\n') {
                                ;
                            }
                            next = '\n';
                            begin = OUT_INDEX;
                            status = 0;
                            break;
                    }
                    break;
                case '_':
                    switch (prev) {
                        case 'a':
                        case 'b':
                        case 'c':
                        case 'd':
                        case 'e':
                        case 'f':
                        case 'g':
                        case 'h':
                        case 'i':
                        case 'j':
                        case 'k':
                        case 'l':
                        case 'm':
                        case 'n':
                        case 'o':
                        case 'p':
                        case 'q':
                        case 'r':
                        case 's':
                        case 't':
                        case 'u':
                        case 'v':
                        case 'w':
                        case 'x':
                        case 'y':
                        case 'z':
                            switch (status) {
                                case 0:
                                    status = 2;
                                    break;
                                case 1:
                                    OUT_INDEX = begin;
                                    OUT[OUT_INDEX++] = 'E';
                                    OUT[OUT_INDEX++] = 'r';
                                    OUT[OUT_INDEX++] = 'r';
                                    OUT[OUT_INDEX++] = 'o';
                                    OUT[OUT_INDEX++] = 'r';
                                    OUT[OUT_INDEX++] = '!';
                                    OUT[OUT_INDEX++] = '\n';
                                    while (IN[IN_INDEX++] != '\n') {
                                        ;
                                    }
                                    next = '\n';
                                    begin = OUT_INDEX;
                                    status = 0;
                                    break;
                                case 2:
                                    break;
                            }
                            break;
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                        case 'G':
                        case 'H':
                        case 'I':
                        case 'J':
                        case 'K':
                        case 'L':
                        case 'M':
                        case 'N':
                        case 'O':
                        case 'P':
                        case 'Q':
                        case 'R':
                        case 'S':
                        case 'T':
                        case 'U':
                        case 'V':
                        case 'W':
                        case 'X':
                        case 'Y':
                        case 'Z':
                        case '_':
                        case '\n':
                            OUT_INDEX = begin;
                            OUT[OUT_INDEX++] = 'E';
                            OUT[OUT_INDEX++] = 'r';
                            OUT[OUT_INDEX++] = 'r';
                            OUT[OUT_INDEX++] = 'o';
                            OUT[OUT_INDEX++] = 'r';
                            OUT[OUT_INDEX++] = '!';
                            OUT[OUT_INDEX++] = '\n';
                            while (IN[IN_INDEX++] != '\n') {
                                ;
                            }
                            next = '\n';
                            begin = OUT_INDEX;
                            status = 0;
                            break;
                    }
                    break;
                case '\n':
                    switch (prev) {
                        case 'a':
                        case 'b':
                        case 'c':
                        case 'd':
                        case 'e':
                        case 'f':
                        case 'g':
                        case 'h':
                        case 'i':
                        case 'j':
                        case 'k':
                        case 'l':
                        case 'm':
                        case 'n':
                        case 'o':
                        case 'p':
                        case 'q':
                        case 'r':
                        case 's':
                        case 't':
                        case 'u':
                        case 'v':
                        case 'w':
                        case 'x':
                        case 'y':
                        case 'z':
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                        case 'G':
                        case 'H':
                        case 'I':
                        case 'J':
                        case 'K':
                        case 'L':
                        case 'M':
                        case 'N':
                        case 'O':
                        case 'P':
                        case 'Q':
                        case 'R':
                        case 'S':
                        case 'T':
                        case 'U':
                        case 'V':
                        case 'W':
                        case 'X':
                        case 'Y':
                        case 'Z':
                            status = 0;
                            OUT[OUT_INDEX++] = '\n';
                            begin = OUT_INDEX;
                            break;
                        case '_':
                            OUT_INDEX = begin;
                            OUT[OUT_INDEX++] = 'E';
                            OUT[OUT_INDEX++] = 'r';
                            OUT[OUT_INDEX++] = 'r';
                            OUT[OUT_INDEX++] = 'o';
                            OUT[OUT_INDEX++] = 'r';
                            OUT[OUT_INDEX++] = '!';
                            OUT[OUT_INDEX++] = '\n';
                            next = '\n';
                            begin = OUT_INDEX;
                            status = 0;
                            break;
                    }
                    break;
                default:
                    OUT_INDEX = begin;
                    OUT[OUT_INDEX++] = 'E';
                    OUT[OUT_INDEX++] = 'r';
                    OUT[OUT_INDEX++] = 'r';
                    OUT[OUT_INDEX++] = 'o';
                    OUT[OUT_INDEX++] = 'r';
                    OUT[OUT_INDEX++] = '!';
                    OUT[OUT_INDEX++] = '\n';
                    while (IN[IN_INDEX++] != '\n') {
                        ;
                    }
                    next = '\n';
                    begin = OUT_INDEX;
                    status = 0;
                    break;
            }
            prev = next;
        }
        return new String(OUT, 0, OUT_INDEX);
    }
}
