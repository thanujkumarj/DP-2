// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes

// we observed overlapping sub problems , so we can use dp here. we use 2D dp, with index and amount as important parameters.
// at any time, dp[i][j] is the no. of possible combinations with amount=j and coins available are from index 0 to i-1;



class Solution {
    public int change(int amount, int[] coins) {
        if(coins==null || coins.length==0){
            return 0;
        }
        int dp[][] = new int [coins.length + 1][amount + 1];
        for(int i =0;i<coins.length + 1;i++)
        {
            dp[i][0] = 1;
        }
        for(int i=1;i<coins.length + 1;i++)
        {
            for(int j=1;j<amount + 1;j++)
            {
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}