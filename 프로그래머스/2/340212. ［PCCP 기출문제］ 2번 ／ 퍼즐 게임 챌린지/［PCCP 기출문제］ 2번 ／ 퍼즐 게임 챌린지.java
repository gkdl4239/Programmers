import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        int min = 1;
        int max = 0;
        
        for(int diff : diffs) {
            max = Math.max(max, diff);
        }
        
        int answer = max;
        
        while(min <= max) {
            
            int mid = (min + max) / 2;
            
            if(solvable(diffs, times, limit, mid)) {
                max = mid - 1;
                answer = Math.min(answer, mid);
            }
            else {
                min = mid + 1;
            }
        }
        
        return answer;
    }
    
    private boolean solvable(int[] diffs, int[] times, long limit, int level) {
        
        long l = 0;
            
        for(int i=0; i<diffs.length; i++) {
            if(level >= diffs[i]) l+= times[i];
            else {
                l += (times[i-1] + times[i]) * (diffs[i] - level) + times[i];
            }
        }
        
        return l <= limit;
    }
}