import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(reader.readLine());
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for(int i=0; i<n; i++) {
            if(i+2 <=n) dp[i+2] = (dp[i+2] + dp[i]) % 10007;
            if(i+1 <=n) dp[i+1] = (dp[i+1] + dp[i]) % 10007;
        }
        writer.append(Integer.toString(dp[n])).flush();
    }
}