package com.zzf;

/**
 * 14 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String[] strs2 = {"dog","racecar","car"};
        String[] strs3 = {"a"};
        String[] strs4 = {"flower","flower","flower","flower"};
        String[] strs5 = {"c","acc","ccc"};
        System.out.println(longestCommonPrefix(strs));

        String s = "c";
        String r = "acc";
        String d = "ccc";
//        System.out.println(s.indexOf(d));
//        System.out.println(longestCommonPrefix(strs4));
    }


    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }

        String result = strs[0];

        for (int j = 1; j < strs.length; ) {
            if(result.length() == 0){
                return "";
            }
            if (strs[j].indexOf(result) == 0) {
                j++;
                continue;
            } else {
                result = result.substring(0,result.length() - 1);
            }
        }

        return result;
    }
}
