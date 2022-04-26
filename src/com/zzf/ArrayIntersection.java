package com.zzf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 350
 * <p>
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *  
 * <p>
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ArrayIntersection {

    public static void main(String[] args) {

        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        int[] nums3 = new int[]{4,9,5};
        int[] nums4 = new int[]{9,4,9,8,4};
        System.out.println(Arrays.toString(intersect(nums3, nums4)));
//        System.out.println(intersectList(nums1, nums2));
    }

    public static List<Integer> intersectList(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (map.get(num) > 0) {
                result.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        return result;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int[] result = new int[nums1.length];
        int count = 0;
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result[count++] = num;
                map.put(num, map.get(num) - 1);
            }
        }
        return Arrays.copyOfRange(result, 0, count);
    }

    public static int[] intersectTwe(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0 ,j = 0;

        while (i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                nums1[i]
            }
        }
    }
}
