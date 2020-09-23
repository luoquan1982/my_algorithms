package com.luoquan.dynamic.stringSearch;

import com.luoquan.tool.StringTool;
import com.sun.istack.internal.NotNull;

public class Kmp {

    private final int[][] dp;
    private final String pattern;

    public Kmp(String pattern) {
        this.pattern = pattern;
        //S:有限状态机，匹配到第几个字符了
        int S = pattern.length();
        //dp[状态][字符] = 下个状态
        this.dp = new int[S][256];
        //只有遇到 pat[0] 这个字符才能使状态从 0 转移到 1，遇到其它字符的话还是停留在状态 0
        dp[0][pattern.charAt(0)] = 1;
        // 影子状态X初始为0
        int shadow = 0;
        // 当前状态 j从1开始
        for (int j = 1; j < S; j++) {
            for(int c = 0; c < 256; c++) {
                dp[j][c] = dp[shadow][c];
            }
            dp[j][pattern.charAt(j)] = j + 1;
            // 更新影子状态
            shadow = dp[shadow][pattern.charAt(j)];
        }
    }

    public int search(String txt) {
        int S = pattern.length();
        int N = txt.length();
        // pat 的初始态为 0
        int j = 0;
        for (int i = 0; i < N; i++) {
            // 计算 pat 的下一个状态
            j = dp[j][txt.charAt(i)];
            // 到达终止态，返回结果
            if (j == S) {
                return i - S + 1;
            }
        }
        // 没到达终止态，匹配失败
        return -1;
    }

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

    private static long testSearch(int method, int count) {
        long start = System.currentTimeMillis();
        if (method == 1) {
            for (int i = 0; i < count; i++) {
                String pattern = StringTool.randomAlphabetString(20);
                String txt = StringTool.specifiedPatternString(100000, pattern, 1);
                violenceSearch(txt, pattern);
            }
        } else {
            for (int i = 0; i < count; i++) {
                String pattern = StringTool.randomAlphabetString(20);
                String txt = StringTool.specifiedPatternString(100000, pattern, 1);
                Kmp kmp = new Kmp(pattern);
                kmp.search(txt);
            }
        }
        return System.currentTimeMillis() - start;
    }

    public static void main(String[] args) {
        long violenceTime = testSearch(1, 1000);
        long kmpTime = testSearch(2, 1000);
        System.out.println("violence time:" + violenceTime);
        System.out.println("kmp time:" + kmpTime);
    }
}
