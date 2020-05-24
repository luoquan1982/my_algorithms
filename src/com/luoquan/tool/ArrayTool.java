package com.luoquan.tool;

/**
 * ArrayTool
 *
 * @author LuoQuan
 * @date 2020/4/27 19:45
 */
public class ArrayTool {

    /**
     * 打印二维数组
     * @param array 待打印的二维数组
     */
    public static void printTwoDimensionalArray(int[][] array){
        for(int[] row:array){
            for (int element : row) {
                System.out.printf("%d\t",element);
            }
            System.out.println();
        }
    }
}
