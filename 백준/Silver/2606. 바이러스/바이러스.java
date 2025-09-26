import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int node = Integer.parseInt(reader.readLine());
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=node; i++) graph.add(new ArrayList<>());
        
        int edge = Integer.parseInt(reader.readLine());
        for(int i=0; i<edge; i++) {
            int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int first = arr[0], second = arr[1];
            graph.get(first).add(second);
            graph.get(second).add(first);
        }
        
        boolean[] visited = new boolean[node+1];
        visited[1] = true;
        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(1);
        int count=0;
        
        while(!bfs.isEmpty()) {
            int cur = bfs.poll();
            for(int next : graph.get(cur)) {
                if(!visited[next]) {
                    visited[next] = true;
                    count++;
                    bfs.add(next);
                }
            }
        }
        
        writer
            .append("").append(Integer.toString(count))
            .flush();
    }
}