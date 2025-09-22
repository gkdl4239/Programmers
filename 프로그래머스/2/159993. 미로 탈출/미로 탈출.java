import java.util.*;
class Solution {
    
    private int bfs(String[] maps, int[] start, int[] end) {
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        visited[start[0]][start[1]] = true;
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{start[0], start[1], 0});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0],
                y = cur[1],
                count = cur[2];
            
            if(x==end[0] && y==end[1]) return count;
            
            for(int i=0; i<4; i++) {
                int nx = x+dx[i],
                    ny = y+dy[i];
                
                if(nx>=0 && nx<maps.length && ny>=0 && ny<maps[0].length() && !visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, count+1});
                    }
                }
            }
        return -1;
        }
                          
    public int solution(String[] maps) {
        
        int[] start = new int[2],
              lever = new int[2],
              end = new int[2];
        int answer = 0;
        
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length(); j++) {
                if(maps[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
                if(maps[i].charAt(j) == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                }
                if(maps[i].charAt(j) == 'E') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        
        int toLever = bfs(maps, start, lever);
        int toEnd = bfs(maps, lever, end);
        
        if(toLever == -1 || toEnd == -1) return -1;
        return toLever + toEnd;
    }
}