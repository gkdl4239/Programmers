import java.util.*;
class Solution {
    
    private boolean[][] visited;
    
    public int[] solution(String[] maps) {
        
        visited = new boolean[maps.length][maps[0].length()];
        List<Integer> islands = new ArrayList<>();
        
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length(); j++) {
                if(maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    islands.add(bfs(maps, new int[]{i,j}));
                }
            }
        }
        
        if(islands.isEmpty()) return new int[]{-1};
        Collections.sort(islands);
        
        int[] answer = new int[islands.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = islands.get(i);
        }
        
        return answer;
    }
    
    private int bfs(String[] maps, int[] start) {
        
        int[] dx = {1,-1,0,0},
              dy = {0,0,1,-1};
        int days = 0;
        Queue<int[]> island = new LinkedList<>();
        
        island.add(start);
        visited[start[0]][start[1]] = true;
        
        while(!island.isEmpty()) {
            int[] cur = island.poll();
            int x = cur[0];
            int y = cur[1];
            
            days += Character.getNumericValue(maps[x].charAt(y));
            
            for(int i=0; i<4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                if(nx>=0 && nx<maps.length && ny>=0 && ny<maps[0].length() && maps[nx].charAt(ny) != 'X'
                  && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    island.add(new int[]{nx,ny});
                }
            }
        }
        
        return days;
    }
}