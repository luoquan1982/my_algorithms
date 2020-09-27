package com.luoquan.sort.simple;

import com.luoquan.tool.NumberTool;

import java.util.Arrays;

/**
 * Insert
 *
 * @author LuoQuan
 * @date 2020/9/27 21:34
 */
public class InsertSort {
    public static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int index = i - 1;
            while (index >= 0 && array[index] > current) {
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = current;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] originArray = NumberTool.randomIntArray(5, 0, 100);
        System.out.println("Origin Array:" + Arrays.toString(originArray));
        int[] sortedArray = sort(originArray);
        System.out.println("Sorted array:" + Arrays.toString(sortedArray));
    }
}
