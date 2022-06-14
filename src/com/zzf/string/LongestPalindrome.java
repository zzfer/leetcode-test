package com.zzf.string;

/**
 * 5. 最长回文子串
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。

  

 示例 1：

 输入：s = "babad"
 输出："bab"
 解释："aba" 同样是符合题意的答案。
 示例 2：

 输入：s = "cbbd"
 输出："bb"
  

 提示：

 1 <= s.length <= 1000
 s 仅由数字和英文字母组成

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/longest-palindromic-substring
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ababas"));
    }

    /**
     * 中心扩散法
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        int len = 1;
        int maxStart = 0;
        for(int i = 0; i < s.length(); i++){
            left = i-1;
            right = i+1;
            while(left >= 0 && s.charAt(left) == s.charAt(i)){
                left--;
                len++;
            }
            while(right < s.length() && s.charAt(right) == s.charAt(i)){
                right++;
                len++;
            }
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
                len+=2;
            }
            if(len > max){
                max = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart+1, maxStart + max + 1);
    }
}
