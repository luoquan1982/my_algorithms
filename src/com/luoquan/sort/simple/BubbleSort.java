package com.luoquan.sort.simple;

import com.luoquan.tool.NumberTool;

import java.util.Arrays;

/**
 * Bubble
 *
 * @author LuoQuan
 * @date 2020/9/27 20:09
 */
public class BubbleSort {
    public static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int[] originArray = NumberTool.randomIntArray(100, 0, 1000);
        System.out.println("Origin Array:" + Arrays.toString(originArray));
        int[] sortedArray = sort(originArray);
        System.out.println("Sorted array:" + Arrays.toString(sortedArray));
    }
}
