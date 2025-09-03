import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        // 상하좌우 이동을 위한 배열
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        // 방문 여부와 거리를 저장하는 배열
        boolean[][] visited = new boolean[n][m];
        
        // BFS를 위한 큐
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1}); // x, y, 거리
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];
            
            // 도착점에 도달했을 때
            if(x == n-1 && y == m-1) {
                return count;
            }
            
            // 상하좌우 탐색
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 유효한 좌표이고, 벽이 아니며, 방문하지 않은 경우
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, count+1});
                }
            }
        }
        
        // 도착점에 도달할 수 없는 경우
        return -1;
    }
}