import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int max = Integer.MAX_VALUE;
        int[] dp = new int[y+1];
        Arrays.fill(dp, max);
        dp[x] = 0;
        
        for(int i=x; i<dp.length; i++) {
            if(dp[i] == max) continue;
            if(i*2 <= y) dp[i*2] = Math.min(dp[i]+1, dp[i*2]);
            if(i*3 <= y) dp[i*3] = Math.min(dp[i]+1, dp[i*3]);
            if(i+n <= y) dp[i+n] = Math.min(dp[i]+1, dp[i+n]);
        }
        return dp[y] == max ? -1 : dp[y];
    }
}