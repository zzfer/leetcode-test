package com.zzf;


import java.util.HashMap;

/**
 * 3. 无重复字符的最长子串
 *
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

  

 示例 1:

 输入: s = "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 示例 2:

 输入: s = "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 示例 3:

 输入: s = "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
  

 提示：

 0 <= s.length <= 5 * 104
 s 由英文字母、数字、符号和空格组成

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class StringNoRepeatSubstring {

    public static void main(String[] args) {
        String s = "abcabcbb";
        String s1 = " ";
        String s2 = "cdd";
        String s3 = "abba";
        System.out.println(lengthOfLongestSubMap(s3));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }

        int maxLength = 1;
        StringBuilder max = new StringBuilder(s.substring(0, 1));
        for(int i = 1; i < s.length(); i++){
            if(max.toString().contains(String.valueOf(s.charAt(i)))){
                maxLength = Math.max(maxLength, max.length());
                max = new StringBuilder(max.substring(max.toString().indexOf(s.charAt(i)) + 1, max.length()));

            }
            max.append(s.charAt(i));
        }
        return Math.max(maxLength, max.length());
    }

    public static int lengthOfLongestSubMap(String s) {
        if(s.length() == 0){
            return 0;
        }

        int maxLength = 0;
        int start = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey((int)s.charAt(i))){
                maxLength = Math.max(maxLength, i - start);
                start = map.get((int)s.charAt(i)) + 1;
            }
            map.put((int) s.charAt(i), i);
        }
        return Math.max(maxLength, s.length() - start);
    }
}
