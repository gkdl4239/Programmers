import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(reader.readLine());
        int[] steps = new int[n];
        for(int i=0; i<n; i++) {
            steps[i] = Integer.parseInt(reader.readLine());
        }
        
        int[] dp = new int[n];
        
        for(int i=0; i<n; i++) {
            if(i==0) dp[i] = steps[i];
            else if(i==1) dp[i] = steps[0]+steps[1];
            else if(i==2) dp[i] = steps[2] + Math.max(steps[0], steps[1]);
            else {
                dp[i] = Math.max(dp[i-2] + steps[i], dp[i-3] + steps[i-1] + steps[i]);
            }
            
        }
        
        writer
            .append("").append(Integer.toString(dp[n-1]))
            .flush();
    }
}