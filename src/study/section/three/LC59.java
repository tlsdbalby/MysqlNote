package study.section.three;
/*
* P45 3.5
* 59. 螺旋矩阵 II
* 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
* */
public class LC59 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            method1(i);
            System.out.println("========================================");
        }
    }

    /*
    * 没啥算法可言，更多的是代码细节，其实原理不难，找出打印规律，按序打印即可
    *   思路：将目标拆解成一个矩形圈一个矩形圈的形式，每一圈按照一个规律赋值，从外至内，每圈的规模缩小，起点变化
    *       每圈的左上角为起点，其下标：(0,0) (1,1) (2,2) (i,i)...
    *       规模从两点来描述  一个是总的元素数量 2n+2*(n-2)
    *                      一个是矩阵圈的边长，从正常来说应该是n，但是由于转折处元素会重复计数，所以边长为n-1，头闭尾开
    *                      规模缩减步长为2 即n = n - 2
    *       赋值规律，以n为例 num = 0
    *           从最外圈开始，规模n，所以此圈共2n+2*(n-2)个元素，从(x=0,y=0)开始，
    *               赋值顺序上边：n-1（边长）次 x,y++ num++；右边：n-1次 x++,y num++；下边：n-1次 x,y-- num++；左边：n-1次 x--,y num++：
    * */
    public static void method1(int n){
        int[][] matrix = new int[n][n];
        int scale = n;
        int start = 0;
        int num = 1;
        while (scale > 0){
            if (scale == 1){
                matrix[start][start] = num;
                break;
            }
            else{
                int len = scale - 1;
                int x = start;
                int y = start;
                for (int i = 0 ; i < len; i++) {
                    matrix[x][y++] = num++;
                }
                for (int i = 0 ; i < len; i++) {
                    matrix[x++][y] = num++;
                }
                for (int i = 0 ; i < len; i++) {
                    matrix[x][y--] = num++;
                }
                for (int i = 0 ; i < len; i++) {
                    matrix[x--][y] = num++;
                }
                start++;
                scale -= 2;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
