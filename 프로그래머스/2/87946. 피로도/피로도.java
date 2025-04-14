class Solution {
    
    private int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        boolean[] visited = new boolean[dungeons.length];
        
        dfs(k, 0, dungeons, visited);
        
        return max;
    }
    
    private void dfs(int k, int cnt, int[][] dungeons, boolean[] visited) {
        
        max = Math.max(max, cnt);
        
        for(int i = 0; i < dungeons.length; i++) {
            
            if(visited[i]) continue;
            
            if(k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], cnt + 1, dungeons, visited);
                visited[i] = false;
            }
        }
    }
}