import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0], m = arr[1], blocks = arr[2];
        int[] ground = new int[n * m];
        int idx = 0;
        int min = 257, max = -1;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                int h = Integer.parseInt(st.nextToken());
                ground[idx++] = h;
                min = Math.min(min, h);
                max = Math.max(max, h);
            }
        }
        
        int answer = 0, minTime = Integer.MAX_VALUE;
        
        for(int h=min; h<=max; h++) {
            
            int remove = 0, install = 0;
                
            for(int block : ground) {
                if(block > h) remove += block - h;
                else if(block < h) install += h - block;
            }
            
            if(install > blocks + remove) continue;
            
            int time = remove * 2 + install;
            
            if(time < minTime) {
                minTime = time;
                answer = h;
            } else if(time == minTime) answer = Math.max(answer, h);
        }
        
        writer.append(minTime + " " + answer).flush();
    }
}