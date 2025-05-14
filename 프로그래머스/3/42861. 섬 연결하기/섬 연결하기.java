import java.util.*;
class Solution {
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        
        for(int[] edge : costs) {
            
            int a = edge[0], b = edge[1], cost = edge[2];
            
            if(find(parent, a) != find(parent, b)) {
                union(parent, a, b);
                answer += cost;
            }
        }
        
        return answer;
    }
    
    private int find(int[] parent, int x) {
        
        if(parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        
        return parent[x];
    }
    
    private void union(int[] parent, int a, int b) {
        
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        
        if(rootA != rootB)
            parent[rootB] = rootA;
    }
}