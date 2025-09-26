import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0], m = arr[1];

        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int[] sum = new int[n+1];
        for(int i=0; i<n; i++) sum[i+1] = sum[i] + nums[i]; 
            
        for(int i=0; i<m; i++) {
            
            int[] order = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int s = order[0], e = order[1];
            
            int intervalSum = sum[e] - sum[s-1];
            
            writer.append(Integer.toString(intervalSum) + "\n");
        }
        
        writer.flush();
    }
}