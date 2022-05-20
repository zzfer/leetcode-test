package com.zzf.arraylist;

import java.util.Arrays;

/**
 * 436. 寻找右区间
 *
 * 给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。

 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。

 返回一个由每个区间 i 的 右侧区间 的最小起始位置组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。

  
 示例 1：

 输入：intervals = [[1,2]]
 输出：[-1]
 解释：集合中只有一个区间，所以输出-1。
 示例 2：

 输入：intervals = [[3,4],[2,3],[1,2]]
 输出：[-1,0,1]
 解释：对于 [3,4] ，没有满足条件的“右侧”区间。
 对于 [2,3] ，区间[3,4]具有最小的“右”起点;
 对于 [1,2] ，区间[2,3]具有最小的“右”起点。
 示例 3：

 输入：intervals = [[1,4],[2,3],[3,4]]
 输出：[-1,2,-1]
 解释：对于区间 [1,4] 和 [3,4] ，没有满足条件的“右侧”区间。
 对于 [2,3] ，区间 [3,4] 有最小的“右”起点。
  

 提示：

 1 <= intervals.length <= 2 * 104
 intervals[i].length == 2
 -106 <= starti <= endi <= 106
 每个间隔的起点都 不相同

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/find-right-interval
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class FindRightInterval {

    public static void main(String[] args) {
        int[][] nums = {{3,4},{2,3},{1,2}};
        System.out.println(Arrays.toString(findRightInterval(nums)));
    }

    public static int[] findRightInterval(int[][] intervals) {
        int length = intervals.length;
        if(length <= 1){
            return new int[]{-1};
        }

        int[][] start = new int[length][2];
        int[][] end = new int[length][2];

        for(int i = 0; i < length; i++){
            start[i][0] = intervals[i][0];
            start[i][1] = i;
            end[i][0] = intervals[i][1];
            end[i][1] = i;
        }
        Arrays.sort(start, ((o1, o2) -> o1[0] - o2[0]));
        Arrays.sort(end, ((o1, o2) -> o1[0] - o2[0]));

        int[] result = new int[length];
        for(int i = 0; i < length; i++){
            int j = 0;
            while (j < length){
                if(end[i][0] <= start[j][0]){
                    result[end[i][1]] = start[j][1];
                    break;
                }
                j++;
            }
            if(j >= length){
                result[end[i][1]] = -1;
            }
        }
        return result;
    }
}
