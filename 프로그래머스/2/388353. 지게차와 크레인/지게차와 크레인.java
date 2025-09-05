import java.util.*;
class Solution {
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    int row;
    int col;
    
    public int solution(String[] storage, String[] requests) {    
        
        int answer = storage.length * storage[0].length();
        row = storage.length;
        col = storage[0].length();
        
        for(String request : requests) {
            if(request.length() == 1) {
                answer -= bfs(storage, request);
            }
            
            if(request.length() == 2) {
                answer -= removeAll(storage, request);
            }
        }
        
        return answer;
    }
    
    private int bfs(String[] storage, String request) {
        
        int number = 0;
        Queue<int[]> erase = new LinkedList<>();
        
        for(int i=0; i<storage.length; i++) {
            for(int j=0; j<storage[0].length(); j++) {
                
                if(storage[i].charAt(j) == request.charAt(0)) {
                    
                    Queue<int[]> queue = new LinkedList<>();
                    boolean[][] visited = new boolean[row][col];
                    
                    queue.add(new int[]{i, j});
                    
                    while(!queue.isEmpty()) {
                        
                        int[] cur = queue.poll();
                        int x = cur[0];
                        int y = cur[1];
                        
                        if(x == 0 || x == row-1 || y == 0 || y == col-1) {
                            erase.add(new int[]{i, j});
                            number++;
                            break;
                        }
                        
                        for(int k=0; k<4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            
                            if(nx >=0 && nx < row && ny >=0 && ny < col && !visited[nx][ny]) {
                                if(storage[nx].charAt(ny) == '0') {
                                    queue.add(new int[]{nx, ny});
                                    visited[nx][ny] = true;
                                }
                            }
                            
                        }
                    }
                }
            }
        }
        
        while(!erase.isEmpty()) {
            int[] cur = erase.poll();
            int i = cur[0];
            int j = cur[1];
            storage[i] = storage[i].substring(0,j) + "0" + storage[i].substring(j+1);
            }
        
        return number;
    }
    
    private int removeAll(String[] storage, String request) {
        
        int number = 0;
        
        for(int i=0; i<storage.length; i++) {
            for(int j=0; j<storage[0].length(); j++) {
                
                if(storage[i].charAt(j) == request.charAt(0)) {
                    storage[i] = storage[i].substring(0,j) + "0" + storage[i].substring(j+1);
                    number++;
                }
            }
        }
        
        return number;
    }
}