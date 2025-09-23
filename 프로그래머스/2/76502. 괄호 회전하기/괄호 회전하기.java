import java.util.*;
class Solution {
    
    private boolean isCorrect(String s) {
        
        char[][] brackets = {{'(',')'}, {'{','}'}, {'[',']'}};
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            
            char cur = s.charAt(i);
            boolean removed = false;
            
            for(char[] bracket : brackets) {
                if(cur == bracket[1] && !stack.isEmpty() && stack.peek() == bracket[0]) {
                    stack.pop();
                    removed = true;
                }
            }
            if(!removed) stack.push(cur);
        }
        
        return stack.isEmpty();
    }
    
    public int solution(String s) {
        
        int answer = 0;
        
        for(int i=0; i<s.length(); i++) {
            if(isCorrect(s)) answer++;
            
            s = s.substring(1) + s.charAt(0);
        }
        
        return answer;
        
    }
}