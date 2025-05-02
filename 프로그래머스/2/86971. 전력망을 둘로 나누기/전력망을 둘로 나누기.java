import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;
    
    public int solution(int n, int[][] wires) {
        
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        int min = Integer.MAX_VALUE;
        
        for(int i = 1 ; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        for(int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            graph[a].remove((Integer)b);
            graph[b].remove((Integer)a);
            
            dfs(1);
            min = Math.min(min, Math.abs(count - (n - count)));
            
            Arrays.fill(visited, false);
            count = 0;
            graph[a].add(b);
            graph[b].add(a);
            
        }
        
        return min;
    }
    
    private void dfs(int node) {
        
        visited[node] = true;
        count++;
        
        for(int next : graph[node]) {
            if(!visited[next])
                dfs(next);
        }
    }
}