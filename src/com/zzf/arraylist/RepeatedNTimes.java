package com.zzf.arraylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * 961. 在长度 2N 的数组中找出重复 N 次的元素
 * <p>
 * 给你一个整数数组 nums ，该数组具有以下属性：
 * <p>
 * nums.length == 2 * n.
 * nums 包含 n + 1 个 不同的 元素
 * nums 中恰有一个元素重复 n 次
 * 找出并返回重复了 n 次的那个元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [2,1,2,5,3,2]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：nums = [5,1,5,2,5,3,5,4]
 * 输出：5
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 5000
 * nums.length == 2 * n
 * 0 <= nums[i] <= 104
 * nums 由 n + 1 个 不同的 元素组成，且其中一个元素恰好重复 n 次
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/n-repeated-element-in-size-2n-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RepeatedNTimes {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3};
        int[] nums1 = {2, 1, 2, 5, 3, 2};
        int[] nums2 = {5, 1, 5, 2, 5, 3, 5, 4};

        System.out.println(repeatedNTimes(nums));
    }


    /**
     * 哈希表
     *
     * @param nums
     * @return
     */
    public static int repeatedNTimes(int[] nums) {
        int length = nums.length;
        HashMap map = new HashMap();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(nums[i])) {
                return nums[i];
            } else {
                map.put(nums[i], 1);
            }
        }
        return 0;
    }

    /**
     * 数学
     * <p>
     * 我们可以考虑重复的元素 xx 在数组 \textit{nums}nums 中出现的位置。
     * <p>
     * 如果相邻的 xx 之间至少都隔了 22 个位置，那么数组的总长度至少为：
     * <p>
     * n + 2(n - 1) = 3n - 2
     * n+2(n−1)=3n−2
     * <p>
     * 当 n > 2n>2 时，3n-2 > 2n3n−2>2n，不存在满足要求的数组。因此一定存在两个相邻的 xx，它们的位置是连续的，或者只隔了 11 个位置。
     * <p>
     * 当 n = 2n=2 时，数组的长度最多为 2n = 42n=4，因此最多只能隔 22 个位置。
     * <p>
     * 这样一来，我们只需要遍历所有间隔 22 个位置及以内的下标对，判断对应的元素是否相等即可。
     * <p>
     * 时间复杂度：O(n)O(n)。我们最多对数组进行三次遍历（除了 n=2n=2 之外，最多两次遍历）。
     * 空间复杂度：O(1)O(1)。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/solution/zai-chang-du-2n-de-shu-zu-zhong-zhao-chu-w88a/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int repeatedNTimes2(int[] nums) {
        int n = nums.length;
        for (int gap = 1; gap <= 3; ++gap) {
            for (int i = 0; i + gap < n; ++i) {
                if (nums[i] == nums[i + gap]) {
                    return nums[i];
                }
            }
        }
        // 不可能的情况
        return -1;
    }

    /**
     * 随机选择
     *
     思路与算法

     我们可以每次随机选择两个不同的下标，判断它们对应的元素是否相等即可。如果相等，那么返回任意一个作为答案。

     时间复杂度：期望 O(1)O(1)。选择两个相同元素的概率为 1/4。 因此期望 4 次结束循环。

     空间复杂度：O(1)O(1)。

     * @param nums
     * @return
     */
    public int repeatedNTimesRandom(int[] nums) {
        int n = nums.length;
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        while (true) {
            int x = random.nextInt(n), y = random.nextInt(n);
            if (x != y && nums[x] == nums[y]) {
                return nums[x];
            }
        }
    }

}
