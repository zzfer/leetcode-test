package com.zzf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 118. 杨辉三角
 * <p>
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 * <p>
 * 输入: numRows = 1
 * 输出: [[1]]
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= numRows <= 30
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YanghuiTriangle {

    public static void main(String[] args) {
        System.out.println(generateList(10));
    }

    public static List<List<Integer>> generateList(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    row.add(1);
                }else {
                    row.add( result.get(i-1).get(j-1) + result.get(i-1).get(j));
                }
            }
            result.add(row);
        }
        return result;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        int[][] set = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == numRows-1){
                    set[i][j]  = 1;
                }else {
                    set[i][j] = set[i - 1][j - 1] + set[i - 1][j];
                }
            }
        }
        result = Arrays.stream(set).map(l -> {
            return Arrays.stream(l).filter(item -> item > 0)
                    .boxed().collect(Collectors.toList());
        }).collect(Collectors.toList());
        return result;
    }
}
