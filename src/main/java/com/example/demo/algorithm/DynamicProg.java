package com.example.demo.algorithm;

public class DynamicProg {
    public static void main(String[] args) {
        DynamicProg t = new DynamicProg();
        int i = t.maxSubarraySumCircular(new int[]{-2, -3, -1});
    }

    /**
     * 动态规划 球斐波那契
     * @param n
     * @return
     */
    public int fib(int n) {
        if(n<=1){
            return n;
        }
        int t = 0;
        int p = 0;
        int result = 1;
        for (int i = 1; i < n; i++) {
            p = t;
            t = result;
            result = t+p;
        }
        return result;
    }

    /**
     * 三数斐波那契
     *
     *
     * @param n
     * @return
     */
    public int tribonacci(int n) {
        if(n==0){
            return 0;
        }else if(n<=2){
            return 1;
        }
        int t1 = 0;
        int t2 = 1;
        int pop = 0;
        int p = 1;
        int result = 1;
        for (int i = 2; i < n; i++) {
            p = t2;
            pop = t1;
            t2 = result;
            t1 = p;
            result = t2+p+pop;
        }
        return result;
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int biggerPath = nums[0];
        for (int i = 1; i < nums.length; i++) {
            biggerPath = nums[i]>biggerPath+nums[i]? nums[i]:biggerPath+nums[i];
            max = max>biggerPath? max:biggerPath;
        }
        return max;
    }

    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int i1 = 1;
        int i2 = 2;
        int temp =0;
        for (int i = 2; i < n; i++) {
            temp = i1 + i2;
            i1 = i2;
            i2 = temp;
        }
        return i2;
    }

    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==2){
            return Math.min(cost[0],cost[1]);
        }else if(cost.length<2){
            return 0;
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i-2],dp[i-1]) + cost[i];
        }
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }

    public int rob(int[] nums) {
        int arraySize = nums.length;
        if(arraySize==0){
            return 0;
        }else if (arraySize==1){
            return nums[0];
        }else if (arraySize<=2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp = new int[arraySize];
        int[] dp2 = new int[arraySize];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1],nums[2]);
        for (int i = 2; i < arraySize-1; i++) {
            dp[i] = Math.max(dp[i-1],(dp[i-2]+nums[i]));
            dp2[i] = Math.max(dp2[i-1],(dp2[i-2]+nums[i+1]));
        }
        return Math.max(dp[arraySize-2],dp2[arraySize-2]);
    }

    /**
     * 可以简化为打家劫舍问题
     * 题干中、nums中的元素小于10^4 大于 1
     * @param nums
     * @return
     */
    public int deleteAndEarn(int[] nums) {
        int[] temp = new int[10001];
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]] += nums[i];
        }
        int[] dp = new int[temp.length];
        dp[1] = temp[1];
        //没有剪枝
        for (int i = 2; i < temp.length; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+ temp[i]);
        }
        return dp[temp.length-1];
    }

    public boolean canJump(int[] nums) {
        if(nums[0]==0&&nums.length!=1){
            return false;
        }else if(nums[0]==0){
            return true;
        }
        for (int i = nums.length-2; i > 0; i--) {
            if(nums[i]==0){
                for (int z = 1; z <= i; z++) {
                    if(nums[i-z]-z >0){
                        break;
                    }
                    if(z==i&&nums[0]-z<=0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int jump(int[] nums) {
        int count = 0;
        //最远位置
        int temp = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            temp = Math.max(temp,i+nums[i]);
            if(i==end){
                end = temp;
                count++;
            }
        }
        return count;
    }

    public int maxSubarraySumCircular(int[] nums) {
        int dp = nums[0];
        int max = dp;
        int min = 0;
        int sum = dp;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            //dp大于0 则记录到路径中
            dp = nums[i] + Math.max(dp,0);
            max = Math.max(dp,max);
        }
        //重置dp路径
        dp = nums[0];
        //取最小段
        for (int i = 1; i < nums.length-1; i++) {
            dp = nums[i] + Math.min(dp,0);
            min = Math.min(dp,min);
        }
        return Math.max(max,sum-min);
    }

    public int maxProduct(int[] nums) {
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //分别对应 [i-1]的状态
            int preMax = max;
            int preMin = min;
            max = Math.max(nums[i]*preMax,Math.max(nums[i]*preMin,nums[i]));
            min = Math.min(nums[i]*preMin,Math.min(nums[i]*preMax,nums[i]));
            result = Math.max(result,max);
        }
        return result;
    }

    public int getMaxLen(int[] nums){
        int maxLen = 0;
        int positiveLen = 0;
        int negativeLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                positiveLen ++;
                if(negativeLen>0){
                    negativeLen++;
                }
            }else if(nums[i]<0){
                if(positiveLen>0&&negativeLen>0){
                    //+ - 相乘 原本的正集合变为负集合的长度。
                    int newNegative = positiveLen + 1;
                    //- - 相乘 原本负集合变为正集合长度
                    positiveLen = negativeLen + 1;
                    negativeLen = newNegative;
                }else if(positiveLen==0 && negativeLen==0){
                    //初始状态 给负集合的长度计数；
                    negativeLen = 1;
                }else if(positiveLen>0 && negativeLen==0){
                    //只有正数集合计数的情况 正数集合变为负数集合的计数
                    negativeLen = positiveLen+1;
                    positiveLen = 0;
                }else if(positiveLen==0 && negativeLen>0){
                    //只有负数集合计数  负数集合变为正数集合的计数
                    positiveLen = negativeLen + 1;
                    negativeLen = 1;
                }
            }else if(nums[i]==0){
                positiveLen = 0;
                negativeLen = 0;
            }
            //只要求结果为正数的大小
            maxLen = Math.max(maxLen,positiveLen);
        }
        return maxLen;
    }

    /**
     * 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
     *
     * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
     *
     * 返回一对观光景点能取得的最高分。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-sightseeing-pair
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * dp关系 f(i,j+1) = f(i,j) - values[j+1]+values[j]-1(上文得分公式)
     * @param values
     * @return
     */
    public int maxScoreSightseeingPair(int[] values) {
        int value = values[0] + 0;
        int result = 0;
        for (int i = 1; i < values.length; ++i) {
            result = Math.max(result,value + values[i]-i);
            value = Math.max(value,values[i]+i);
        }
        return result;
    }

    public int maxProfit(int[] prices) {
        if(prices.length<=1){
            return 0;
        }
        int buy = prices[0];
        int sold = 0;
        for (int i = 1; i < prices.length; i++) {
            sold = Math.max(sold,prices[i]-buy);
            buy = Math.min(buy,prices[i]);
        }
        return sold;
    }

    public int maxProfit2(int[] prices) {
        if(prices.length<=1){
            return 0;
        }
        int maxGain = 0;
        for (int i = 1; i < prices.length; i++) {
            maxGain = Math.max(maxGain,maxGain+(prices[i]-prices[i-1]));
        }
        return maxGain;
    }

    public int maxProfit3(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; ++i) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]-prices[i]);
            dp[i][1] = dp[i-1][0]+prices[i];
            dp[i][2] = Math.max(dp[i-1][1],dp[i-1][2]);
        }
        return Math.max(dp[prices.length-1][2],dp[prices.length-1][1]);
    }
}
