import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        int i = 0;
        Stack<Integer> timestamp = new Stack<>();
        int[] answer = new int[prices.length];
        
        timestamp.push(i);
        for(i=1; i<prices.length; i++) {
            while(!timestamp.isEmpty() && prices[timestamp.peek()] > prices[i]) {
                answer[timestamp.peek()] = i - timestamp.pop();
            }
            timestamp.push(i);
        }
        
        while(!timestamp.isEmpty()) {
            answer[timestamp.peek()] = i - timestamp.pop() - 1;
        }
        
        return answer;
        
    }
}
