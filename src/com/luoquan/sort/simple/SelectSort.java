package com.luoquan.sort.simple;

import com.luoquan.tool.NumberTool;

import java.util.Arrays;

/**
 * Select
 *
 * @author LuoQuan
 * @date 2020/9/27 20:53
 */
public class SelectSort {
    public static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int currentIndex = 0;
            for (int j = 1; j <= array.length - i; j++) {
                if (array[j] > array[currentIndex]) {
                    currentIndex = j;
                }
            }

            int tmp = array[currentIndex];
            array[currentIndex] = array[array.length - i];
            array[array.length - i] = tmp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] originArray = NumberTool.randomIntArray(100, 0, 1000);
        System.out.println("Origin Array:" + Arrays.toString(originArray));
        int[] sortedArray = sort(originArray);
        System.out.println("Sorted Array:" + Arrays.toString(sortedArray));
    }
}
