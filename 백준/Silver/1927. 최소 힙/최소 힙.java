import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        PriorityQueue<Long> queue = new PriorityQueue<>();
        int n = Integer.parseInt(reader.readLine());
        for(int i=0; i<n; i++) {
            long num = Long.parseLong(reader.readLine());
            
            if(num == 0) {
                if(queue.isEmpty()) writer.append(0 + "\n");
                else {
                    long min = queue.poll();
                    writer.append(min + "\n");
                }
            } else {
                queue.add(num);
            }
        }
        
        writer
            //.append("")		// .append(Integer.toString(1))
            .flush();
    }
}