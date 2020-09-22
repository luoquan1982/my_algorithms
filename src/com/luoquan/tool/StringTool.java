package com.luoquan.tool;

import com.sun.istack.internal.NotNull;

import java.util.Random;

/**
 * StringTool
 *
 * @author LuoQuan
 * @date 2020/9/20 9:32
 */
public final class StringTool {
    private static final String ALPHABETS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String RANDOM_STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static final int RANDOM_TYPE = 1;
    public static final int RANDOM_ALPHABET_TYPE = 1 << 1;

    public static String randomString(int length) {
        return randomString(length, RANDOM_TYPE);
    }

    public static String randomString(int length, String tmp) {
        return createString(length, tmp);
    }

    public static String randomAlphabetString(int length) {
        return randomString(length, RANDOM_ALPHABET_TYPE);
    }

    private static String randomString(int length, int type) {
        boolean isValid = check(length, type);
        if (!isValid) {
            return "";
        }

        String randomString = type == RANDOM_TYPE ? RANDOM_STRING : ALPHABETS;

        return createString(length, randomString);
    }

    private static String createString(int length, String tmp) {
        if (length < 0) {
            throw new IllegalArgumentException("Length can not be negative");
        } else if (length == 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        Random rd = new Random();
        int rdLength = tmp.length();
        for (int i = 0; i < length; i++) {
            builder.append(tmp.charAt(rd.nextInt(rdLength)));
        }
        return builder.toString();
    }

    private static boolean check(int len, int type) {
        if (len < 0) {
            throw new IllegalArgumentException("Length can not be negative");
        } else if (type < 0 || type > RANDOM_ALPHABET_TYPE) {
            throw new IllegalArgumentException();
        }
        return len != 0;
    }

    /**
     * Generate specify count pattern String with Given length
     *
     * @param length 指定的字符串长度
     * @param pattern 指定的模式串
     * @param repeatCount 模式串在字符中重复的次数
     * @return 指定长度，指定重复次数的模式串
     */
    public static String specifiedPatternString(int length, @NotNull String pattern, int repeatCount) {
        if (pattern.length() * repeatCount > length) {
            throw new IllegalArgumentException("pattern string length greater than given length");
        }
        // 指定重复串的长度
        int pLength = pattern.length();
        int restInsertStringLength = length - pLength * repeatCount;
        int currentStringLength;
        Random rd = new Random();
        StringBuilder result = new StringBuilder();


        while (repeatCount > 0) {
            repeatCount--;
            if (restInsertStringLength > 0) {
                currentStringLength = rd.nextInt(restInsertStringLength);

                result.append(randomAlphabetString(currentStringLength));
                result.append(pattern);

                restInsertStringLength -= currentStringLength;
            }
        }

        if (restInsertStringLength > 0) {
            result.append(randomAlphabetString(restInsertStringLength));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String ret = specifiedPatternString(20, "abc", 3);
        System.out.println(ret);
        System.out.println(ret.length());
    }
}
