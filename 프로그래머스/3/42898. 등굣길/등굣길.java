import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] dp = new int[n][m];
        boolean[][] blocked = new boolean[n][m];
        dp[0][0] = 1;
        for(int[] puddle : puddles) {
            blocked[puddle[1]-1][puddle[0]-1] = true;
        }
        
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(blocked[i][j]) {
                    dp[i][j] = 0;
                    continue;
                }
                if(i > 0) dp[i][j] = (dp[i][j] + dp[i-1][j]) % 1000000007;
                if(j > 0) dp[i][j] = (dp[i][j] + dp[i][j-1]) % 1000000007;
            }
        }
        
        return dp[n-1][m-1];
    }
}