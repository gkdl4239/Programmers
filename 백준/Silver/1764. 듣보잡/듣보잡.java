import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0]+arr[1];
        Map<String, Integer> list = new HashMap<>();
        List<String> strangers = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            String name = reader.readLine();
            
            list.put(name, list.getOrDefault(name, 0) + 1);
            if(list.get(name) == 2) strangers.add(name);
        }
        
        Collections.sort(strangers);
        
        writer.append(Integer.toString(strangers.size()) + "\n");
        
        for(String name : strangers) {
            writer.append(name + "\n");
        }
        
        writer.flush();
    }
}