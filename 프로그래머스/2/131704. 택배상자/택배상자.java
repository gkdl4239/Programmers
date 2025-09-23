import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> sub = new Stack<>();
        int k=1;
        int count=0;
        
        for(int i=0; i<order.length; i++) {
            
            int cur = order[i];
            
            while(k < cur) {
                sub.push(k);
                k++;
            }
            
            if(cur==k) {
                k++;
                count++;
            } else if(!sub.isEmpty() && cur==sub.peek()) {
                sub.pop();
                count++;
            } else {
                break;
            }
        }
        
        return count;
    }
}