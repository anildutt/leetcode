package leetcode;

/**
 Algo - DP[i][j] = Minimum { x$ + Max{ DP[i-1 -> x], DP[x+1 -> j]}  
                    over all x ranging from i -> j;
        answer = DP[0][n-1];
        DP[i][i] = 0; //only one element => 1st guess is right => cost = 0;
        DP[i][i+1] = i; //only 2 elements => 1st guess the minimum number i, in the worst case wrong i+1 is right.
**/

class Solution {
    public int getMoneyAmount(int n) {
        int[][] DP = new int[n][n];
        
        //Dp[i,i] = 0; for i=0 -> n-1;
        //Dp[i,i+1] = i;
        for(int i=0; i<n-1; i++)
            DP[i][i+1] = i+1;
        
        for(int gap=2; gap<=n-1; gap++){
            for(int start=0; start+gap<n; start++){
                int end = start+gap;
                int globalMin = Integer.MAX_VALUE;
                for(int i=start+1; i<=end-1; i++){
                    globalMin = Math.min(i + 1 + Math.max(DP[start][i-1], DP[i+1][end]), globalMin);
                }
                DP[start][end] = globalMin;
            }
        }
        
        return DP[0][n-1];
    }
}
