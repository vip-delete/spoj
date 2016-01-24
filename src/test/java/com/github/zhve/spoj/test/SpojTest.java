package com.github.zhve.spoj.test;

import com.github.zhve.spoj.*;
import com.github.zhve.todo.AGGRCOW;
import com.github.zhve.todo.ATM;
import com.github.zhve.todo.SOLVING;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class SpojTest {
    @Test
    public void ACODE() throws Exception {
        run(ACODE.class);
    }

    @Test
    public void ACS() throws Exception {
        run(ACS.class);
    }

    @Test
    public void ADDREV() throws Exception {
        run(ADDREV.class);
    }

    @Test
    public void AGGRCOW() throws Exception {
        run(AGGRCOW.class);
    }

    @Test
    public void ATM() throws Exception {
        run(ATM.class);
    }

    @Test
    public void BINSTIRL() throws Exception {
        run(BINSTIRL.class);
    }

    @Test
    public void COINS() throws Exception {
        run(COINS.class);
    }

    @Test
    public void FCTRL() throws Exception {
        run(FCTRL.class);
    }

    @Test
    public void FCTRL2() throws Exception {
        run(FCTRL2.class);
    }

    @Test
    public void JAVAC() throws Exception {
        run(JAVAC.class);
    }

    @Test
    public void KAMIL() throws Exception {
        run(KAMIL.class);
    }

    @Test
    public void MAYA() throws Exception {
        run(MAYA.class);
    }

    @Test
    public void MMASS() throws Exception {
        run(MMASS.class);
    }

    @Test
    public void ONP() throws Exception {
        run(ONP.class);
    }

    @Test
    public void PALIN() throws Exception {
        run(PALIN.class);
    }

    @Test
    public void PIR() throws Exception {
        run(PIR.class);
    }

    @Test
    public void PRIC() throws Exception {
        run(PRIC.class);
    }

    @Test
    public void PRIME1() throws Exception {
        run(PRIME1.class);
    }

    @Test
    public void SAMER08F() throws Exception {
        run(SAMER08F.class);
    }

    @Test
    public void SOLVING() throws Exception {
        run(SOLVING.class);
    }

    @Test
    public void STPAR() throws Exception {
        run(STPAR.class);
    }

    @Test
    public void TEST() throws Exception {
        run(TEST.class);
    }

    public void run(Class clazz) throws Exception {
        String name = clazz.getSimpleName();
        ClassLoader cl = getClass().getClassLoader();
        int i = 0;
        byte[] resource;
        while ((resource = getClasspathResource("/" + name + "." + i + ".in")) != null) {
            System.setIn(new ByteArrayInputStream(resource));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(out, false, "UTF-8");
            System.setOut(ps);
            clazz.getDeclaredMethod("main", String[].class).invoke(null, new String[1]);
            out.close();
            Scanner result = new Scanner(new ByteArrayInputStream(out.toByteArray()));
            Scanner excepted = new Scanner(cl.getResourceAsStream(name + "." + i + ".out"));

            while (excepted.hasNext()) {
                if (!result.hasNext()) {
                    throw new AssertionError("Test(" + i + "): Result EOF found, but excepted '" + excepted.nextLine() + "'");
                }
                String exceptedLine = excepted.nextLine();
                String resultLine = result.nextLine();
                if (!exceptedLine.equals(resultLine)) {
                    throw new AssertionError("Test(" + i + "): Excepted '" + exceptedLine + "', but found '" + resultLine + "'");
                }
            }

            if (result.hasNext()) {
                throw new AssertionError("Test(" + i + "): Result has unexpected line '" + result.nextLine() + "'");
            }

            i++;
        }

        if (i == 0) {
            throw new AssertionError("Test(" + i + "): No tests found");
        }
    }

    private byte[] getClasspathResource(String name) throws Exception {
        InputStream is = getClass().getResourceAsStream(name);
        if (is == null) {
            return null;
        }
        Scanner scanner = new Scanner(is, "UTF-8");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        while (scanner.hasNext()) {
            out.write(scanner.nextLine().getBytes("UTF-8"));
            out.write('\n');
        }
        return out.toByteArray();
    }
}
