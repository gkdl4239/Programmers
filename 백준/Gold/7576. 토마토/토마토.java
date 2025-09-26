import java.util.*;
import java.io.*;

public class Main {
    
    static int[] dx = {-1, 1, 0, 0},
                 dy = {0, 0, -1, 1};
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[][] box = new int[N][M]; 
        int unripe = 0;
        Queue<int[]> bfs = new LinkedList<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int status = Integer.parseInt(st.nextToken());
                box[i][j] = status;
                
                if(status == 0) unripe++;
                if(status == 1) bfs.add(new int[]{i, j});
            }
        }
        
        int count = -1;
            
        while(!bfs.isEmpty()) {
            
            int size = bfs.size();
            
            for(int i=0; i<size; i++) {
                
                int[] cur = bfs.poll();
                int x = cur[0],
                    y = cur[1];
                
                for(int j=0; j<4; j++) {
                    int nx = x + dx[j],
                        ny = y + dy[j];
                    
                    if(nx >=0 && nx < N && ny >=0 && ny < M && box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        unripe--;
                        bfs.add(new int[]{nx, ny});
                    }
                }
            }
            count++;
        }
        count = unripe > 0 ? -1 : count;
        System.out.print(count);
    }
}