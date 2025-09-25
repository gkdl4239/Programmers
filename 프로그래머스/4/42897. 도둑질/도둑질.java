class Solution {
    public int solution(int[] money) {
        
        int n = money.length;
        
        int[][] dp = new int[2][n];
        
        dp[0][1] = money[1];
        dp[1][0] = money[0];
        dp[1][1] = money[0];
        
        for(int i=0; i<2; i++) {
            
            for(int j=2; j<n-i; j++) {
                dp[i][j] = Math.max(money[j] + dp[i][j-2], dp[i][j-1]);
            }
        }
        
        return Math.max(dp[0][n-1], dp[1][n-2]);
    }
}