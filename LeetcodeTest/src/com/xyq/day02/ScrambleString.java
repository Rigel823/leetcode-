package com.xyq.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static javax.management.Query.value;

public class ScrambleString {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return value(input).toString();
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s1 = stringToString(line);
            line = in.readLine();
            String s2 = stringToString(line);

            boolean ret = new Solution().isScramble(s1, s2);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
