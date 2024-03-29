package com.zzf.SceneQuestion;

/**
 *  70. 爬楼梯
 *
 *假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

  

 示例 1：

 输入：n = 2
 输出：2
 解释：有两种方法可以爬到楼顶。
 1. 1 阶 + 1 阶
 2. 2 阶
 示例 2：

 输入：n = 3
 输出：3
 解释：有三种方法可以爬到楼顶。
 1. 1 阶 + 1 阶 + 1 阶
 2. 1 阶 + 2 阶
 3. 2 阶 + 1 阶
  

 提示：

 1 <= n <= 45

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/climbing-stairs
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    /**
     * f(n) = f(n-1) + f(n-2)
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int a = 0, b = 0, c = 1;
        for(int i = 1; i <= n; i++){
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }
}
