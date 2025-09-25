import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(reader.readLine());
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=1; i<=20; i++) {
            list.add(i);    
        }
        
        for(int i=0; i<n; i++) {
            String[] arr = reader.readLine().split(" ");
            
            if(arr[0].equals("all")) set.addAll(list);
            if(arr[0].equals("empty")) set.clear();
            if(arr[0].equals("add")) set.add(Integer.parseInt(arr[1]));
            if(arr[0].equals("remove")) set.remove(Integer.parseInt(arr[1]));
            
            if(arr[0].equals("check")) {
                int check = 0;
                if(set.contains(Integer.parseInt(arr[1]))) check = 1;
                writer.append(Integer.toString(check) + "\n");
            }
            if(arr[0].equals("toggle")) {
                int num = Integer.parseInt(arr[1]);
                if(set.contains(num)) set.remove(num);
                else set.add(num);
            }
        }
        writer.flush();
    }
}