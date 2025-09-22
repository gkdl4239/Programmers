import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        int[] result = new int[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
            int cur = numbers[i];
            
            while(!q.isEmpty()) {
                if(cur > q.peek()[1]) {
                    result[q.poll()[0]] = cur;
                } else break;
            }
            
            q.add(new int[]{i, cur});
        }
        
        for(int[] remain : q) {
            result[remain[0]] = -1;
        }
        
        return result;
    }
}