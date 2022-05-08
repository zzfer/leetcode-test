package com.zzf;

/**
 * 383. 赎金信
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。

 如果可以，返回 true ；否则返回 false 。

 magazine 中的每个字符只能在 ransomNote 中使用一次。

  

 示例 1：

 输入：ransomNote = "a", magazine = "b"
 输出：false
 示例 2：

 输入：ransomNote = "aa", magazine = "ab"
 输出：false
 示例 3：

 输入：ransomNote = "aa", magazine = "aab"
 输出：true
  

 提示：

 1 <= ransomNote.length, magazine.length <= 105
 ransomNote 和 magazine 由小写英文字母组成

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/ransom-note
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class StringContain {

    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "ab";

        ransomNote = "fihjjjjei";
        magazine = "hjibagacbhadfaefdjaeaebgi";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    /**
     * 数组字典
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] nums = new int[26];
        int lengthr = ransomNote.length();
        int lengthm = magazine.length();
        if(lengthr > lengthm){
            return false;
        }
        for(int i = 0; i < lengthm; i++){
            if(i < lengthr){
                nums[ransomNote.charAt(i) - 'a']++;
            }
            nums[magazine.charAt(i) - 'a']--;
        }
        for(int i = 0; i < lengthr; i++){
            if(nums[ransomNote.charAt(i) - 'a'] >= 1){
                return false;
            }
        }
        return true;
    }
}
