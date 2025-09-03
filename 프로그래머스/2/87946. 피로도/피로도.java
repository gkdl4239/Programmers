class Solution {
    
    private int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        int cnt = 0;
        dfs(dungeons, new boolean[dungeons.length], k, cnt);
        return max;
    }
    
    private void dfs(int[][] dungeons, boolean[] visited, int k, int cnt) {
        
        max = Math.max(max, cnt);
        
        for(int i=0; i<dungeons.length; i++) {
            
            if(visited[i]) continue;
            
            if(k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(dungeons, visited, k - dungeons[i][1], cnt+1);
                visited[i] = false;
            }
        }
    }
}