package com.zzf;

/**
 * 53. 最大子数组和
 *
 *  给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

 子数组 是数组中的一个连续部分。

  

 示例 1：

 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 输出：6
 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 示例 2：

 输入：nums = [1]
 输出：1
 示例 3：

 输入：nums = [5,4,-1,7,8]
 输出：23
  

 提示：

 1 <= nums.length <= 105
 -104 <= nums[i] <= 104
  

 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/maximum-subarray
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ArrayMaxSubarraySum {

    public static void main(String[] args) {
        int[] nums = {4,-1,2,1,-5,4,3};
        int[] nums1 = {-1};
        int[] nums2 = {-2,-1};
        System.out.println(maxSubArray(nums2));
    }

    public static int maxSubArray1(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public static int maxSubArray(int[] nums) {
        int maxNum = nums[0];
        int lNum = 0;

        for(int i = 0; i< nums.length; i++){
            if(nums[i] + lNum >= nums[i]){
                lNum += nums[i];
            }else {
                lNum = nums[i];
            }
            if(maxNum < lNum){
                maxNum = lNum;
            }
        }
        return maxNum;
    }
}
