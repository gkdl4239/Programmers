import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        
        int count = sizes.length;
        int[] w = new int[count];
        int[] h = new int[count];
        
        for(int i=0; i<count; i++) {
            Arrays.sort(sizes[i]);
            w[i] = sizes[i][0];
            h[i] = sizes[i][1];
        }
        
        Arrays.sort(w);
        Arrays.sort(h);
        
        return w[count-1] * h[count-1];
    }
}