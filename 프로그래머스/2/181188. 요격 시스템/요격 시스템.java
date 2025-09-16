import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        
        Arrays.sort(targets, (o1, o2) -> (o1[1] - o2[1]));
        
        int missiles = 1;
        int start = targets[0][1];
        for(int i=1; i<targets.length; i++) {
            
            if(targets[i][0] < start) {
                continue;
            }
            
            start = targets[i][1];
            missiles++;
        }
        
        return missiles;
    }
}