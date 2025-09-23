import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<enemy.length; i++) {
            
            queue.add(enemy[i]);
            n -= enemy[i];
            
            while(n<0 && k>0) {
                n += queue.poll();
                k--;
            }
            
            if(n<0) return i;
        }
        
        return enemy.length;
    }
}