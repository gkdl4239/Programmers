class Solution {
    public int solution(int n, int[][] results) {
        
        int[][] graph = new int[n+1][n+1];
        int answer = 0;
        
        for(int[] result : results) {
            int winner = result[0],
                loser = result[1];
            
            graph[winner][loser] = 1;
        }
        
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }
        
        for(int i=1; i<=n; i++) {
            
            int count = 0;
            
            for(int j=1; j<=n; j++) {
                if(graph[i][j] == 1 || graph[j][i] == 1) {
                    count++;
                }
            }
            
            if(count == n-1) {
                answer++;
            }
        }
        
        return answer;
    }
}