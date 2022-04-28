package com.zzf;

import java.util.Arrays;

/**
 * 189.轮转数组
 * <p>
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *  
 * <p>
 * 进阶：
 * <p>
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotationArray {


    public static void main(String[] args) {
        int[] nums = {1, 2};
        int k = 3;
//        rotate(nums, k);
        rotate(nums, k);
    }

    /**
     * 翻转数组
     * @param nums
     * @param start
     * @param end
     */
    public static void reverse(int[] nums, int start, int end) {
        if (nums.length > start && nums.length > end && start < end) {
            int temp = 0;
            for (int i = start; i < end; i++) {
                temp = nums[i];
                nums[i] = nums[end];
                nums[end] = temp;
                end--;
            }
        }
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }
}
