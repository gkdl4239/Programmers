import java.util.*;
import java.io.*;

public class Main {
    
    private static StringBuilder dfs(boolean[] visited, List<List<Integer>> graph, int cur, StringBuilder sb) {
        
        visited[cur] = true;
        
        if(sb.length() == 0) {
            sb.append(cur);
        } else {
            sb.append(" " + cur);
        }
        for(int next : graph.get(cur)) {
            if(!visited[next]) {
                visited[next] = true;
                dfs(visited, graph, next, sb);
            }
        }
        
        return sb;
    }
    
    private static StringBuilder bfs(boolean[] visited, List<List<Integer>> graph, int init) {
        
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(init);
        visited[init] = true;
        sb.append(init);
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            
            for(int next : graph.get(cur)) {
                if(!visited[next]) {
                    visited[next] = true;
                    sb.append(" "+next);
                    queue.add(next);
                }
            }
        }
        
        return sb;
    }
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int node = arr[0], edges = arr[1], init = arr[2];
        boolean[] visited = new boolean[node+1];
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=node; i++) graph.add(new ArrayList<>());
        
        for(int i=0; i<edges; i++) {
            int[] route = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(route[0]).add(route[1]);
            graph.get(route[1]).add(route[0]);
        }
        
        for(List<Integer> edge : graph) Collections.sort(edge);
        
        String dfsResult = dfs(visited, graph, init, new StringBuilder()).toString();
        writer.append(dfsResult + "\n");
        
        Arrays.fill(visited, false);
        String bfsResult = bfs(visited, graph, init).toString();
        writer.append(bfsResult).flush();
    }
}