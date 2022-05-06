package com.zzf;


import java.util.Arrays;

/**
 * 566. 重塑矩阵
 * <p>
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
 * <p>
 * 给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 * <p>
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 * <p>
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：mat = [[1,2],[3,4]], r = 1, c = 4
 * 输出：[[1,2,3,4]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：mat = [[1,2],[3,4]], r = 2, c = 4
 * 输出：[[1,2],[3,4]]
 *  
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * -1000 <= mat[i][j] <= 1000
 * 1 <= r, c <= 300
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reshape-the-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoArrayRestructure {

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2},{3,4}};
        System.out.println(Arrays.deepToString(matrixReshapeStandard(nums, 1, 4)));
    }


    /**
     * 本人写法
     *
     * 先把元素放到一维数组里，然后再循环到新数组里
     *
     *
     * @param mat
     * @param r
     * @param c
     * @return
     */
    public static int[][] matrixReshape(int[][] mat, int r, int c) {

        int m = mat.length;
        int n = mat[0].length;
        if (n * m != r * c) {
            return mat;
        }
        int[][] result = new int[r][c];
        int[] test = new int[n * m];
        int length = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                test[length++] = mat[i][j];
            }
        }
        length = 0;
        for(int o = 0; o < r; o++) {
            for (int k = 0; k < c; k++) {
                result[o][k] = test[length++];
            }
        }
        return result;
    }

    public static int[][] matrixReshapeStandard(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }

        int[][] ans = new int[r][c];
        for (int x = 0; x < m * n; ++x) {
            ans[x / c][x % c] = nums[x / n][x % n];
        }
        return ans;
    }

}
