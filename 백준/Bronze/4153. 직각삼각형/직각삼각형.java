import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while(true) {
            
            int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            Arrays.sort(arr);
            
            int a = arr[0],
                b = arr[1],
                c = arr[2];
            
            if(c==0) break;
            
            String answer = "";
            
            if(a*a + b*b == c*c) answer = "right";
            else answer = "wrong";
            writer
            .append(answer + "\n")		// .append(Integer.toString(1))
            .flush();    
        }
        
    }
}