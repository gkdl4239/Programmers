import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        int w = maps.length;
        int h = maps[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{0, 0, 1});
        
        while(!queue.isEmpty()) {
            
            int[] cur = queue.poll();
            
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];
            
            if(x == w-1 && y == h-1) return count;
            
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < w && ny >= 0 && ny < h && maps[nx][ny] == 1) {
                    maps[nx][ny] = 0;
                    queue.add(new int[]{nx, ny, count + 1});
                }
            }
        }
        
        return -1;
    }
}