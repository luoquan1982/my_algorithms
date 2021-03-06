package com.luoquan.sparseMatrix;

import com.luoquan.tool.ArrayTool;

import java.util.*;

/**
 * SparseMatrix
 *
 * @author LuoQuan
 * @date 2020/4/25 20:19
 */
public class SparseMatrix {

    /**
     * 普通数组转稀疏矩阵
     *
     * @param twoDimensionalArray 原始二维数组
     * @return 转换后的稀疏矩阵
     */
    public static int[][] toSparseArray(int[][] twoDimensionalArray) {
        int row = twoDimensionalArray.length;
        int column = twoDimensionalArray[0].length;

        List<Map<String, Integer>> data = new LinkedList<>();

        for (int r = 0; r < twoDimensionalArray.length; r++) {
            for (int c = 0; c < twoDimensionalArray[r].length; c++) {
                if (0 != twoDimensionalArray[r][c]) {
                    Map<String, Integer> e = new HashMap<>();
                    e.put("row", r);
                    e.put("column", c);
                    e.put("value", twoDimensionalArray[r][c]);
                    data.add(e);
                }
            }
        }

        int[][] ret = new int[data.size() + 1][3];
        ret[0][0] = row;
        ret[0][1] = column;
        ret[0][2] = data.size();

        int current = 1;

        for (Map<String, Integer> e : data) {
            ret[current][0] = e.get("row");
            ret[current][1] = e.get("column");
            ret[current][2] = e.get("value");
            current++;
        }
        return ret;
    }

    /**
     * 稀疏矩阵转换回原始数组
     *
     * @param spareArray 稀疏矩阵
     * @return 转换后的原始二维数组
     */
    public static int[][] toOriginalArray(int[][] spareArray) {
        int[][] ret = new int[spareArray[0][1]][spareArray[0][1]];
        int number = spareArray[0][2];
        for (int i = 1; i <= number; i++) {
            ret[spareArray[i][0]][spareArray[i][1]] = spareArray[i][2];
        }
        return ret;
    }

    /**
     * @param row    指定生成的稀疏矩阵的行数
     * @param column 指定生成的稀疏矩阵的列数
     * @param number 指定稀疏矩阵的元素个数
     * @return 生成的稀疏矩阵
     */
    public static int[][] createTwoDimensionalArray(int row, int column, int number) {
        if (row < 0 || column < 0 || number < 0 || number > row * column) {
            throw new IllegalArgumentException("参数错误");
        }

        int capacity = row * column;
        List<Integer> positions = new LinkedList<>();

        for (int i = 0; i < capacity; i++) {
            positions.add(i);
        }
        Collections.shuffle(positions);

        int[][] ret = new int[row][column];

        Random rd = new Random();
        int position;
        for (int i = 0; i < number; i++) {
            position = positions.remove(0);
            int r = position / column;
            int c = position % column;
            ret[r][c] = rd.nextInt(100);
        }

        return ret;
    }

    public static void main(String[] args) {
        // 创建一个原始的二维数组11*11
        // 0:表示没有旗子,1:表示黑子,2:表示白子
        int[][] chessArray1 = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;
        //输出原始的二维数组
        System.out.println("原始的二维数组");
        ArrayTool.printTwoDimensionalArray(chessArray1);
        System.out.println();

        System.out.println("原始数组转换成稀疏矩阵");
        int[][] ret = toSparseArray(chessArray1);
        ArrayTool.printTwoDimensionalArray(ret);
        System.out.println();

        System.out.println("稀疏矩阵转换成原始数组");
        int[][] originArray = toOriginalArray(ret);
        ArrayTool.printTwoDimensionalArray(originArray);

        System.out.println("Create random array:");
        int[][] randomArray = createTwoDimensionalArray(10, 10, 10);
        ArrayTool.printTwoDimensionalArray(randomArray);
        System.out.println("To Spare");
        int[][] spare = toSparseArray(randomArray);
        ArrayTool.printTwoDimensionalArray(spare);
    }

}
