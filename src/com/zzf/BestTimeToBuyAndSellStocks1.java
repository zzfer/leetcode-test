package com.zzf;


/**
 * 121. 买卖股票的最佳时机
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。

 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。

 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

  

 示例 1：

 输入：[7,1,5,3,6,4]
 输出：5
 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 示例 2：

 输入：prices = [7,6,4,3,1]
 输出：0
 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
  

 提示：

 1 <= prices.length <= 105
 0 <= prices[i] <= 104

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class BestTimeToBuyAndSellStocks1 {

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        int[] nums1 = {2,4,1};
        System.out.println(maxProfit(nums1));
    }

    /**
     * 一次循环查询
     *
     * 类似于滑动窗口的思路
     *
     * 找到最小的买入值 和 买入值后的最大卖出值
     *
     * 如果有更小值，根据目前的最大卖出值和之前的最小买入值计算出最大价值
     * 将卖出值初始为0，再次往后循环
     *
     * 简单的说就是找到当前最小值 能获取的最大利益。如果有更小的值，保留目前的最大利益后再重新找新的最大利益
     *
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int result = 0;
        int buyPrices = prices[0];
        int sellPrices = 0;
        for(int i = 1; i < prices.length ; i++){
            if(prices[i] < buyPrices){
                result = Math.max(sellPrices - buyPrices , result);
                buyPrices = prices[i];
                sellPrices = 0;
            }else if(prices[i] > sellPrices){
                sellPrices = prices[i];
            }
        }
        result = Math.max(sellPrices - buyPrices , result);
        return result;
    }
}
