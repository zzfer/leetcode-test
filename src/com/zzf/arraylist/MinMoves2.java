package com.zzf.arraylist;

import java.util.Arrays;

/**
 * 462. 最少移动次数使数组元素相等 II
 *
 *给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。

 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。

  

 示例 1：

 输入：nums = [1,2,3]
 输出：2
 解释：
 只需要两步操作（每步操作指南使一个元素加 1 或减 1）：
 [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 示例 2：

 输入：nums = [1,10,2,9]
 输出：16
  

 提示：

 n == nums.length
 1 <= nums.length <= 105
 -109 <= nums[i] <= 109
 通过次数29,990提交次数48,578

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class MinMoves2 {

    public static void main(String[] args) {
        int[] nums = {1,0,0,8,6,5};
        int[] nums1 = {1,10,2,9};
        System.out.println(minMoves2(nums1));
    }

    /**
     * 查询中位数，就是目标数
     * @param nums
     * @return
     */
    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int num = 0;
        int length = nums.length;
        if(length % 2 == 1){
            num = nums[length / 2] ;
        }else {
            num =  (nums[length / 2] + nums[length / 2 - 1]) / 2;
        }

        int result = 0;
        for(int i = 0; i < length; i++){
            if(nums[i] > num){
                result += (nums[i] - num);
            }else{
                result += (num - nums[i]);
            }
        }
        return result;
    }
}
