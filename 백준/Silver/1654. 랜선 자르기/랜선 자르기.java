import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0], needed = arr[1];
        int[] cables = new int[n];
        long maxLen = 0;
        for(int i=0; i<n; i++) {
            cables[i] = Integer.parseInt(reader.readLine());
            maxLen = Math.max(cables[i], maxLen);
        }
        long low = 1, high = maxLen, answer = 0;
        
        while(low <= high) {
            long mid = (low + high) / 2;
            if(mid == 0) mid = 1;
            long count = 0;
            
            for(int cable : cables) {
                count += cable / mid;
            }
            
            if(count < needed) {
                high = mid - 1;
            } else {
                low = mid + 1;
                answer = mid;
            }
        }
        writer.append(Long.toString(answer)).flush();
    }
}