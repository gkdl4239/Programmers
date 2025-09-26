import java.util.*;
import java.io.*;

public class Main {
    
    private static void cut(int[][] paper, int x, int y, int n, int[] color) {
        
        if(n == 1) {
            color[paper[x][y]]++;
            return;
        }
        int std = paper[x][y];
        boolean isSame = true;
        
        for(int i=x; i<x+n; i++) {
            for(int j=y; j<y+n; j++) {
                if(paper[i][j] != std) {
                    isSame = false;
                    break;
                }
                if(!isSame) break;
            }
        }
        if(isSame) color[std]++;
        else {
            cut(paper, x, y, n/2, color);
            cut(paper, x, y+n/2, n/2, color);
            cut(paper, x+n/2, y, n/2, color);
            cut(paper, x+n/2, y+n/2, n/2, color);
        }
    }
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(reader.readLine());
        int[][] paper = new int[n][n];
        int[] color = new int[2];
        
        for(int i=0; i<n; i++) {
            paper[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        
        cut(paper, 0, 0, n, color);
        
        for(int answer : color) writer.append(answer + "\n");
        writer.flush();
    }
}