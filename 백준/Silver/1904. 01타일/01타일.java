import java.util.*;

class Main {
    static int[] dp = new int[1000000];
    
    static int tile(int n) {
        
        if(dp[n] == 0) {
            dp[n] = (tile(n-1) + tile(n-2)) % 15746;
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        
        dp[0] = 1;
        dp[1] = 2;
        
        System.out.print(tile(n-1));
    }
}