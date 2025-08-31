import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 1;
        
        for(int num : priorities) {
            q.add(num);
        }
        
        while(!q.isEmpty()) {
        
            for(int i=0; i<priorities.length; i++) {
                if(priorities[i] == q.peek()) {
                    
                    if(i == location) {
                        return answer;
                    }
                    q.poll();
                    answer++;
                }
            }
        }
        
        return answer;
        
        
    }
}