package com.zzf;


/**
 * 122.买卖股票的最佳时机 II
 * <p>
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * <p>
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * <p>
 * 返回 你能获得的 最大 利润 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 * 总利润为 4 + 3 = 7 。
 * 示例 2：
 * <p>
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      总利润为 4 。
 * 示例 3：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 3 * 104
 * 0 <= prices[i] <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BestTimeToBuyAndSellStocks {

    public static void main(String[] args) {
        int[] pr = {7, 1, 5, 3, 6, 4};
        int[] pre = {1,2,3,4,5};
        int[] pres = {3,1,3,1,1};
        int[] press = {7,6,4,3,1};
        System.out.println(maxProfit(pre));
        System.out.println(GreedyMaxProfit(pre));
    }

    /**
     * 贪心算法
     * @param prices
     * @return
     */
    public static int GreedyMaxProfit(int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        int result = 0;
        for(int i = 0; i< prices.length - 1 ; i++){
            if(prices[i] < prices[i + 1]){
                result += prices[i + 1] - prices[i];
            }
        }
        return result;
    }

    /**
     * 自己想的乱七八糟的思路
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int result = 0;
        int buyPrices = 0;
        boolean isbuy = true;
        for (int i = 0; i < prices.length; i++) {
            if (isbuy) {
                if(i + 1  == prices.length) {
                    return result;
                }
                if (prices[i] < prices[i + 1]) {
                    buyPrices = prices[i];
                    isbuy = false;
                }
            } else {
                if(i + 1  == prices.length){
                    if(prices[i] > buyPrices){
                        result += prices[i] - buyPrices;
                    }
                }else {
                    if (prices[i] > prices[i + 1]) {
                        result += prices[i] - buyPrices;
                        isbuy = true;
                        buyPrices = 0;
                    }
                }
            }
        }
        return result;
    }
}
