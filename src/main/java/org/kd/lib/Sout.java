package org.kd.lib;

import java.io.PrintStream;

public class Sout {

    public static void print(PrintStream out, char c, int times){
        while (times > 0){
            out.print(c);
            times--;
        }
    }

    public static void println(PrintStream out, char c, int times){
        print(out, c, times);
        out.println();
    }
}
