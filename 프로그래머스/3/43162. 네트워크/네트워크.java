import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        
        boolean[] visited = new boolean[n+1];
        int networks = 0;
        
        for(int i=0; i<n; i++) {
            
            if(visited[i+1]) continue;
            
            Queue<Integer> bfs = new LinkedList<>();
            bfs.add(i);
            
            while(!bfs.isEmpty()) {
                int cur = bfs.poll();
                
                for(int j=0; j<n; j++) {
                    if(!visited[j+1] && computers[cur][j] == 1 && i != j) {
                        bfs.add(j);
                        visited[j+1] = true;
                    }
                }
            }
            
            networks++;
        }
        
        return networks;
    }
}