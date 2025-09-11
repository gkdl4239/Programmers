import java.util.*;
class Solution {
    boolean solution(String s) {
        
        Stack<Character> stack = new Stack<>();
        boolean answer = true;
        
        for(int i=0; i<s.length(); i++) {
            
            
            if(!stack.isEmpty() && stack.peek() == '(' && s.charAt(i) == ')') {
                stack.pop();
                continue;
            }
            
            stack.push(s.charAt(i));
        }
        
        return stack.isEmpty();
    }
}