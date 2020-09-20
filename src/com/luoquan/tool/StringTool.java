package com.luoquan.tool;

import java.util.Random;

/**
 * StringTool
 *
 * @author LuoQuan
 * @date 2020/9/20 9:32
 */
public final class StringTool {
    private static String ALPHABETS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String RANDOM_STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static int RANDOM_TYPE = 1;
    private static int RANDOM_ALPHABET_TYPE = 1 << 1;

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
}
