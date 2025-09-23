import java.util.*;
class Solution {
    public long solution(int[] weights) {
        
        int[][] ratios = {{1,2}, {2,3}, {3,4}};
        
        long[] wCnt = new long[1001];
        long cnt = 0;
        
        for(int weight : weights) {
            wCnt[weight]++;
        }
        
        for(int w=100; w<1001; w++) {
            if(wCnt[w] == 0) continue;
            
            cnt += (wCnt[w] - 1) * wCnt[w] / 2;
            
            for(int[] ratio : ratios) {
                if(w % ratio[0] != 0) continue;
                
                int target = w / ratio[0] * ratio[1];
                
                if(target > 1000 || wCnt[target] == 0) continue;
                
                cnt += wCnt[w] * wCnt[target];
            }
        }
        
        return cnt;
    }
}