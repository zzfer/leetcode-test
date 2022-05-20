package com.zzf.arraylist;

/**
 *
 * 4. 寻找两个正序数组的中位数
 *
 *
 *给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

 算法的时间复杂度应该为 O(log (m+n)) 。

  

 示例 1：

 输入：nums1 = [1,3], nums2 = [2]
 输出：2.00000
 解释：合并数组 = [1,2,3] ，中位数 2
 示例 2：

 输入：nums1 = [1,2], nums2 = [3,4]
 输出：2.50000
 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
  

  

 提示：

 nums1.length == m
 nums2.length == n
 0 <= m <= 1000
 0 <= n <= 1000
 1 <= m + n <= 2000
 -106 <= nums1[i], nums2[i] <= 106

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1,3}, nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] nums = new int[length1 + length2];
        int i = 0, j = 0,k = 0;
        while (i < length1 || j < length2){
            if(i >= length1){
                nums[k++] = nums2[j++];
                continue;
            }
            if(j >= length2){
                nums[k++] = nums1[i++];
                continue;
            }

            if(nums1[i] < nums2[j]){
                nums[k++] = nums1[i++];
            }else{
                nums[k++] = nums2[j++];
            }
        }
        double result;
        if((k) % 2 == 1){
            result = (double)nums[(k) / 2];
        }else{
            result = ((double)nums[(k) / 2] + (double)nums[((k) / 2)-1] ) / 2;
        }
        return result;
    }
}
