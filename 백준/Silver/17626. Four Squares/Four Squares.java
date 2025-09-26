import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(reader.readLine());
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i=0; i<n; i++) {
            
            int sqrt = 1;
            while(i + sqrt*sqrt <= n) {
                dp[i+sqrt*sqrt] = Math.min(dp[i+sqrt*sqrt], dp[i] + 1);
                sqrt++;
            }
        }
        
        writer
            .append(Integer.toString(dp[n]))
            .flush();
    }
}