import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        long needed = arr[1];
        
        long[] trees = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long max = 0;
        for(long tree : trees) max = Math.max(max, tree);
        
        long low = 1, high = max, height = 0;
        
        while(low <= high) {
            
            long mid = (low + high) / 2;
            long cut = 0;
            
            for(long tree : trees) {
                cut += tree > mid ? tree-mid : 0;
            }
            
            if(cut >= needed) {
                height = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            
        }
        
        writer.append(height + "").flush();
    }
}