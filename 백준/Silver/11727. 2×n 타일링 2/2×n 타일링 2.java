import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(reader.readLine());
        
        int[] dp = new int[Math.max(n+1, 3)];
        dp[1] = 1;
        dp[2] = 3;
        
        for(int i=3; i<=n; i++) {
            dp[i] = (dp[i-2]*2 + dp[i-1]) % 10007;
        }
        writer.append(Integer.toString(dp[n])).flush();
    }
}