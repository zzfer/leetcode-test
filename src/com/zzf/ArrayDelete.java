package com.zzf;


import java.util.Arrays;

/**
 * 27. 移除元素
 * <p>
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 *  
 * <p>
 * 说明:
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * <p>
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 * <p>
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ArrayDelete {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int[] nums1 = {3, 2, 2, 3};
        int[] nums2 = {1};
        System.out.println(removeElement(nums, 2));
        System.out.println(removeElement(nums1, 3));
        System.out.println(removeElement(nums2, 1));
//        System.out.println(delElement(nums, 2));
//        System.out.println(delElement(nums1, 3));
//        System.out.println(delElement(nums2, 1));

    }

    /**
     * 双指针
     * @param nums
     * @param val
     * @return
     */
    public static int delElement(int[] nums, int val){
        if(nums.length == 0){
            return 0;
        }
        int i = 0;
        int j = nums.length-1;
        while (i <= j){
            if(nums[i] == val){
                nums[i] = nums[j--];
            }else {
                i++;
            }
        }
        return i;
    }

    /**
     * 自己写的 双指针 且判断
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }
        int j = nums.length - 1;

        for (int i = 0; i <= j; i++) {
            if (nums[i] == val) {
                while (nums[j] == val) {
                    if(j <= i){
                        break;
                    }
                    nums[j--] = 0;
                }
                nums[i] = nums[j];
                nums[j--] = 0;
            }
        }
        return ++j;
    }
}
