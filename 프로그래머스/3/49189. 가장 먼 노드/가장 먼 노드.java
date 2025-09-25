import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        boolean[] visited = new boolean[n+1];
        Queue<int[]> bfs = new LinkedList<>();
        
        bfs.add(new int[]{1,0});
        visited[1] = true;
        
        int max = 0;
        int count = 0;
        
        while(!bfs.isEmpty()) {
            
            int[] cur = bfs.poll();
            int node = cur[0];
            int dist = cur[1];
            
            if(dist > max) {
                max = dist;
                count = 1;
            } else if (dist == max) {
                count++;
            }
            
            for(int next : graph.get(node)) {
                
                if(!visited[next]) {
                    visited[next] = true;
                    bfs.add(new int[]{next, dist+1});
                }
            }
        }
        
        return count;
    }
}