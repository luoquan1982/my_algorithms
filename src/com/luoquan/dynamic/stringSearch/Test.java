package com.luoquan.dynamic.stringSearch;

import com.luoquan.tool.StringTool;
import com.sun.istack.internal.NotNull;

import java.util.Arrays;

public class Test {


    /*
     * 构建pattern字符串的部分匹配表
     * 部分匹配值"就是"前缀"和"后缀"的最长的共有元素的长度
     * 如下
     * A B C D A B D
     * 0 0 0 0 1 2 0
     */
    private static int[] createPartialMatchTable(@NotNull String pattern) {

        int length = pattern.length();
        int[] ret = new int[length];
        for (int subLength = 1; subLength <= length; subLength++) {
            ret[subLength-1] = getMaxMatch(pattern.substring(0, subLength));
        }

        return ret;
    }

    // 获取指定字符串的最大部分匹配长度
    private static int getMaxMatch(String str) {
        if (str.length() == 0) {
            return 0;
        }

        int length = str.length();
        for (int subLength = length - 1; subLength > 0; subLength--) {
            String preString = str.substring(0,subLength);
            String postString = str.substring(length-subLength,length);
            if(preString.equals(postString)){
                return subLength;
            }
        }
        return 0;
    }

    public static int search(String txt,String pattern){
        int i = 0;
        int length = txt.length();
        while(i < length-i){

        }
        return -1;
    }

    public static void main(String[] args) {
        String pattern = StringTool.randomAlphabetString(10);
        System.out.println(pattern);
        System.out.println(Arrays.toString(createPartialMatchTable(pattern)));
    }

}
