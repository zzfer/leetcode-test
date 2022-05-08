package com.zzf;

import java.util.HashMap;

/**
 * 387. 字符串中的第一个唯一字符
 *
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。

 示例 1：

 输入: s = "leetcode"
 输出: 0
 示例 2:

 输入: s = "loveleetcode"
 输出: 2
 示例 3:

 输入: s = "aabb"
 输出: -1
  

 提示:

 1 <= s.length <= 105
 s 只包含小写字母

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class StringUniqueCharacter {

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] nums = new int[26];

        for(int i = 0; i< chars .length;i++){
            nums[chars[i] - 'a']++;
        }
        for(int i = 0; i< chars.length; i++) {
            if (nums[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
