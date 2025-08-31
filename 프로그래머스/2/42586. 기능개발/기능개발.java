import java.util.*;
class Solution {
    public Stack<Integer> solution(int[] progresses, int[] speeds) {
        
        Stack<Integer> stack = new Stack<>();
        int deploy = 0;
        int pre = 0;
        
        for(int i=0; i<progresses.length; i++) {
            deploy = (int)Math.ceil((100 - progresses[i]) / (float)speeds[i]);
            
            if(stack.size() == 0 || pre < deploy) {
                stack.push(1);
            }
            else{
                stack.push(stack.pop()+1);
            }
            pre = Math.max(pre, deploy);
        }
        
        return stack;
    }
}