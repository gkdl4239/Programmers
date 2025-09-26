import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(reader.readLine());
        
        for(int i=0; i<n; i++) {
            int total = Integer.parseInt(reader.readLine());
            Map<String, Integer> closet = new HashMap<>();
          
            for(int j=0; j<total; j++) {
                String type = reader.readLine().split(" ")[1];
                closet.put(type, closet.getOrDefault(type, 0) + 1);
            }
            
            int cases = 1;
            for(int clothes : closet.values()) cases *= clothes+1;
            cases--;
            
            writer.append(Integer.toString(cases) + "\n");
        }
        
        writer.flush();
    }
}