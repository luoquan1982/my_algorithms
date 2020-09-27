package com.luoquan.tool;

import java.util.Arrays;
import java.util.Random;

/**
 * NumberTool
 *
 * @author LuoQuan
 * @date 2020/9/27 20:25
 */
public class NumberTool {
    public static int[] randomIntArray(long size, int leftBound, int rightBound) {
        Random rd = new Random();
        return rd.ints(size, leftBound, rightBound + 1).toArray();
    }
}
