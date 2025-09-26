import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // int n = Integer.parseInt(reader.readLine());
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int nodes = arr[0], edges = arr[1];
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<=nodes; i++) graph.add(new ArrayList<>());
        
        for(int i=0; i<edges; i++) {
            int[] route = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int start = route[0];
            int end = route[1];
            
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        
        Queue<Integer> bfs = new LinkedList<>();
        boolean[] visited = new boolean[nodes+1];
        int count = 0;
        
        for(int i=1; i<=nodes; i++) {
       
            if(!visited[i]) {
                count++;
                visited[i] = true;
                bfs.add(i);
                
                while(!bfs.isEmpty()) {
                    int cur = bfs.poll();
                    
                    for(int next : graph.get(cur)) {
                        if(!visited[next]) {
                            visited[next] = true;
                            bfs.add(next);
                        }
                    }
                }
            }
        }
        writer.append(Integer.toString(count)).flush();
    }
}