import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        
        Stack<Integer> timestamp = new Stack<>();
        int[] answer = new int[prices.length];
        
        for(int i=0; i<prices.length; i++) {
            
            while(!timestamp.isEmpty() && prices[timestamp.peek()] > prices[i]) {
                answer[timestamp.peek()] = i - timestamp.pop();
            }
            timestamp.push(i);
        }
        
        while(!timestamp.isEmpty()) {
            answer[timestamp.peek()] = prices.length - 1 - timestamp.pop();
        }
        
        return answer;
    }
}