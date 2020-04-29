package tool;

/**
 * ArrayTool
 *
 * @author LuoQuan
 * @date 2020/4/27 19:45
 */
public class ArrayTool {

    public static void printTwoDimensionalArray(int[][] array){
        for(int[] row:array){
            for(int element:row){
                System.out.printf("%d\t",element);
            }
            System.out.println();
        }
    }
}
