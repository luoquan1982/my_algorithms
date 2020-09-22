package com.luoquan.dynamic;

import com.luoquan.tool.StringTool;
import com.sun.istack.internal.NotNull;

import java.util.Random;

public class Kmp {
    // violence search,only for reference
    public static int violenceSearch(@NotNull String txt, @NotNull String pattern) {
        int tLen = txt.length();
        int pLen = pattern.length();
        if (tLen < pLen) {
            return -1;
        }
        for (int i = 0; i < tLen - pLen; i++) {
            int j;
            for (j = 0; j < pLen; j++) {
                if (txt.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == pLen) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String pattern = StringTool.randomAlphabetString(10);
        String txt = StringTool.specifiedPatternString(10000,pattern,1);
        int ret = violenceSearch(txt,pattern);

        System.out.println(txt);
        System.out.println(pattern + "\n");
        System.out.println(ret);
    }
}
