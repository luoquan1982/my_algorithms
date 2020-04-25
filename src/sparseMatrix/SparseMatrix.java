package sparseMatrix;

/**
 * SparseMatrix
 *
 * @author LuoQuan
 * @date 2020/4/25 20:19
 */
public class SparseMatrix {
    public static void main(String[] args) {
        // 创建一个原始的二维数组11*11
        // 0:表示没有旗子,1:表示黑子,2:表示白子
        int[][] chessArray1 = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;
        //输出原始的二维数组
        System.out.println("原始的二维数组");
        printArray(chessArray1);

        //将二维数组转稀疏数组的思路
        //1.先遍历二维数组得到非零数据的个数
        int sum = 0;
        for (int[] row : chessArray1) {
            for (int item : row) {
                if (0 != item) {
                    sum++;
                }
            }
        }

        //创建对应的稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArray[0][0] = chessArray1.length;
        sparseArray[0][1] = chessArray1[0].length;
        sparseArray[0][2] = sum;

        //遍历二维数组,将非零的值存放到稀疏数组中
        int current = 1;
        for(int r=0;r<chessArray1.length;r++){
            for(int c=0;c<chessArray1[r].length;c++){
                if(0!= chessArray1[r][c]){
                    sparseArray[current][0] = r;
                    sparseArray[current][1] = c;
                    sparseArray[current][2] = chessArray1[r][c];
                    current++;
                }
            }
        }

        System.out.println();
        System.out.println("转换的稀疏数组为:");
        printArray(sparseArray);

        int[][] randomArray = new int[4][4];
        System.out.println();
        System.out.println("Random Array:");
        printArray(randomArray);
    }

    public static void printArray(int[][] array){
        for(int[] row:array){
            for(int item:row){
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }
    }
}
