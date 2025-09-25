import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int size = (int) Math.pow(2, N); // 2^N 크기
        
        findZ(size, r, c);
        System.out.println(count);
    }
    
    static void findZ(int size, int r, int c) {
        if (size == 1)
            return;
            
        int half = size / 2;
        
        
        if (r < half && c < half) {
            findZ(half, r, c);
        }
        
        else if (r < half && c >= half) {
            count += half * half;
            findZ(half, r, c - half);
        }
        
        else if (r >= half && c < half) {
            count += 2 * half * half;
            findZ(half, r - half, c);
        }
        
        else {
            count += 3 * half * half;
            findZ(half, r - half, c - half);
        }
    }
}