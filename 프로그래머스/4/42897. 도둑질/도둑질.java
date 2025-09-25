class Solution {
    public int solution(int[] money) {
        
        int n = money.length;
        
        int[][] dp = new int[2][n];
        
        for(int i=0; i<2; i++) {
            dp[i][1-i] = money[1-i];
            
            for(int j=2; j<n-i; j++) {
                dp[i][j] = Math.max(money[j] + dp[i][j-2], dp[i][j-1]);
            }
        }
        
        return Math.max(dp[0][n-1], dp[1][n-2]);
    }
}