package com.luoquan.dynamic.stringsearch;

import com.sun.istack.internal.NotNull;

public class Kmp {


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
            ret[subLength - 1] = getMaxMatch(pattern.substring(0, subLength));
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
            String preString = str.substring(0, subLength);
            String postString = str.substring(length - subLength, length);
            if (preString.equals(postString)) {
                return subLength;
            }
        }
        return 0;
    }

    public static int search(String txt, String pattern) {
        int length = txt.length();
        int pLength = pattern.length();
        int nextIndex = 0;
        int[] partialMatchTable = createPartialMatchTable(pattern);
        while (nextIndex <= length - pLength) {
            int currentIndex = 0;
            while (currentIndex < pLength) {
                // 如果模式串与文本串对应索引上的字符不匹配
                if (txt.charAt(nextIndex + currentIndex) != pattern.charAt(currentIndex)) {
                    // 模式串是否匹配了部分(即currentIndex大于0),如果有,则查询部分匹配表
                    if (currentIndex > 0) {
                        // 移动位数 = 已匹配的字符数 - 对应的部分匹配值
                        nextIndex += currentIndex - partialMatchTable[currentIndex];
                    } else {
                        nextIndex++;
                    }
                    break;
                } else {
                    currentIndex++;
                    if (currentIndex == pLength) {
                        return nextIndex;
                    }
                }
            }
        }
        return -1;
    }

}
