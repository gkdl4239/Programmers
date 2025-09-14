class Solution {
    
    int N, min;
    boolean[][] maps;
    boolean[] visited;
    
    
    private int dfs(int n) {
        
        int child = 1;
        visited[n] = true;
        
        for(int i=1; i<=N; i++) {
            if(!visited[i] && maps[n][i]) child += dfs(i);
        }
        
        min = Math.min(min, Math.abs(child - (N - child)));
        
        return child;
    }
    
    public int solution(int n, int[][] wires) {
        
        N = n;
        min = n;
        visited = new boolean[n+1];
        maps = new boolean[n+1][n+1];
        
        for(int[] wire : wires) {
            
            int a = wire[0];
            int b = wire[1];
            
            maps[a][b] = true;
            maps[b][a] = true;
        }
        
        dfs(1);
        
        return min;
    }
}