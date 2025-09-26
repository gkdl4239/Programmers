import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(reader.readLine());
        long[] arr = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        Map<Long, Long> map = new HashMap<>();
        
        long order = 0;
        
        for(int i=0; i<n; i++) {
            if(!map.containsKey(sorted[i])) {
                map.put(sorted[i], order++);
            }
        }
        
        for(int i=0; i<n; i++) {
            if(i==0) {
                writer.append("" + map.get(arr[i]));
                continue;
            }
            writer.append(" " + map.get(arr[i]) );
        }
        
        writer.flush();
    }
}