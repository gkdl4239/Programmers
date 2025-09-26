import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        int cases = Integer.parseInt(reader.readLine());
        for(int i=0; i<cases; i++) {
            
            int[] info = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int m = info[0], n = info[1], lettuce = info[2];
            int[][] field = new int[n][m];
            boolean[][] visited = new boolean[n][m];
            
            for(int j=0; j<lettuce; j++) {
                int[] xy = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int x = xy[0], y = xy[1];
                
                field[y][x] = 1;
            }
            
            Queue<int[]> bfs = new LinkedList<>();
            int count = 0;
            
            for(int j=0; j<n; j++) {
                for(int k=0; k<m; k++) {
                    if(field[j][k] == 1 && !visited[j][k]) {
                        count++;
                        visited[j][k] = true;
                        bfs.add(new int[]{j, k});
                        
                        while(!bfs.isEmpty()) {
                            int[] cur = bfs.poll();
                            int x = cur[1],
                                y = cur[0];
                            
                            for(int l=0; l<4; l++) {
                                int nx = x + dx[l],
                                    ny = y + dy[l];
                                
                                if(nx >= 0 && nx < m && ny >= 0 && ny < n 
                                   && field[ny][nx] == 1 && !visited[ny][nx]) {
                                    visited[ny][nx] = true;
                                    bfs.add(new int[]{ny, nx});
                                }
                            }
                        }
                    }
                }
            }
            
            writer.append(Integer.toString(count) + "\n");
        }
        
        writer.flush();
    }
}