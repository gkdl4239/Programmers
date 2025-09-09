import java.util.*;
class Solution {
        
    public int solution(int[][] triangle) {
        
        int n = triangle.length;
        int[][] dp = new int[n][n];
        
        for(int i=0; i<n; i++) {
            for(int j = 0; j<triangle[i].length; j++) {
                dp[i][j] = triangle[i][j];
            }
        }
        
        for(int i=1; i<n; i++) {
            dp[i][0] += dp[i-1][0];
            
            for(int j=1; j<triangle[i].length; j++) {
                dp[i][j] += Math.max(dp[i-1][j], dp[i-1][j-1]);
            }
        }
        
        int max = dp[n-1][0];
        
        for(int i=1; i<n; i++) {
            max = Math.max(max, dp[n-1][i]);
        }
        
        return max;
    }
}