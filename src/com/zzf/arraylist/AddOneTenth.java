package com.zzf.arraylist;

import java.util.Arrays;

/**
 * 66. 加一
 *
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。

 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

 你可以假设除了整数 0 之外，这个整数不会以零开头。

  

 示例 1：

 输入：digits = [1,2,3]
 输出：[1,2,4]
 解释：输入数组表示数字 123。
 示例 2：

 输入：digits = [4,3,2,1]
 输出：[4,3,2,2]
 解释：输入数组表示数字 4321。
 示例 3：

 输入：digits = [0]
 输出：[1]
  

 提示：

 1 <= digits.length <= 100
 0 <= digits[i] <= 9

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/plus-one
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class AddOneTenth {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4};
        int[] nums1 = new int[]{9};
        System.out.println(Arrays.toString(plusOne(nums1)));
    }

    /**
     * 判断数组中元素是否是9，如果是 则要进一位。
     * 如果是首位是0，则要新创建一个length+1的元素，这种情况只有首位为1，其他位数必为0 。100...
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int length = digits.length - 1;

        for(int i = length; i >= 0; i--){
            if(digits[i] == 9){
                digits[i] = 0;
                if(i == 0){
                    int[] result = new int[digits.length+1];
                    for(int j = 1; j < result.length; j++){
                        result[j] = 0;
                    }
                    result[i] = 1;
                    return result;
                }
            }else{
                digits[i] = digits[i] + 1;
                return digits;
            }
        }
        return digits;
    }
}
