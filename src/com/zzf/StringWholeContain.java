package com.zzf;

import java.util.Arrays;

/**
 *
 * 242. 有效的字母异位词
 *
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。

  

 示例 1:

 输入: s = "anagram", t = "nagaram"
 输出: true
 示例 2:

 输入: s = "rat", t = "car"
 输出: false
  

 提示:

 1 <= s.length, t.length <= 5 * 104
 s 和 t 仅包含小写字母
  

 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/valid-anagram
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StringWholeContain {

    public static void main(String[] args) {
        String s = "aa", t = "ab";

        s = "anagram";
        t = "nagaram";

        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        int[] nums = new int[26];
        int sLength = s.length();
        int tLength = t.length();
        if(sLength != tLength){
            return false;
        }
        for(int i = 0; i < sLength ; i++){
            nums[s.charAt(i) - 'a']++;

        }
        for(int i = 0; i < sLength ; i++){
            nums[t.charAt(i) - 'a']--;
            if(nums[t.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagramSort(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        return Arrays.equals(chars, chart);
    }
}
