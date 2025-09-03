class Solution {
    
    int N, min;
    boolean[][] map;
    boolean[] visited;
    
    private int dfs(int n) {
        
        visited[n] = true;
        int sum = 1;
        
        for(int i=1; i<= N; i++) {
            if(visited[i] == false && map[n][i]) {
                sum += dfs(i);
            }
        }
        min = Math.min(min, Math.abs(sum - (N - sum)));
        return sum;
    }
    
    
    public int solution(int n, int[][] wires) {
        
        N = n;
        min = n;
        map = new boolean[n+1][n+1];
        visited = new boolean[n+1];
        
        for(int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            map[a][b] = true;
            map[b][a] = true;
        }
        
        dfs(1);
        
        return min;
    }
}