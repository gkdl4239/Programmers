import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(reader.readLine());
        for(int i=0; i<n; i++) {
            
            int num = Integer.parseInt(reader.readLine());
            int[] dp = new int[num+1];
            dp[0] = 1;
            
            for(int j=0; j<num; j++) {
                if(j + 3 <= num) dp[j+3] += dp[j];
                if(j + 2 <= num) dp[j+2] += dp[j];
                if(j + 1 <= num) dp[j+1] += dp[j];
            }
            
            writer.append(Integer.toString(dp[num]) + "\n");
        }
        
        writer.flush();
    }
}