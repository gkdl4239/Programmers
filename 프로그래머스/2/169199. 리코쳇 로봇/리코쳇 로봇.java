import java.util.*;
class Solution {
    public int solution(String[] board) {
        
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        
        boolean visited[][] = new boolean[board.length][board[0].length()];
        Queue<int[]> bfs = new LinkedList<>();
        int answer = -1;
        
        int[] start = new int[3];
        int[] end = new int[2];
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length(); j++) {
                if(board[i].charAt(j) == 'R') {
                    start[0] = i;
                    start[1] = j;
                }
                
                if(board[i].charAt(j) == 'G') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        
        bfs.add(start);
        visited[start[0]][start[1]] = true;
        
        while(!bfs.isEmpty()) {
            
            int[] cur = bfs.poll();
            int x = cur[0],
                y = cur[1],
                count = cur[2];
            
            if(x == end[0] && y == end[1]) {
                answer = count;
                break;
            }
            
            for(int i=0; i<4; i++) {
                int nx = x;
                int ny = y;
                
                while(nx + dx[i] >= 0 && nx + dx[i] < board.length && ny + dy[i]>= 0 
                      && ny + dy[i] < board[0].length() && board[nx+dx[i]].charAt(ny+dy[i]) != 'D') {
                    
                    nx += dx[i];
                    ny += dy[i];
                }
                
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    bfs.add(new int[]{nx, ny, count + 1});
                }
            }
        }
        
        return answer;
    }
}