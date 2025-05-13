import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        String answer = "";
        Stack<Character> max = new Stack<>();
        
        for(int i = 0 ; i < number.length(); i++) {
            
            char cur = number.charAt(i);
            
            while(!max.isEmpty() && max.peek() < cur && k-- > 0) {
                max.pop();
            }
            
            max.push(cur);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!max.isEmpty()) {
            sb.append(max.pop());
        }
        
        answer = sb.reverse().toString();
        
        if(k > 0) {
            answer = answer.substring(0, answer.length() - k);
        }
        
        return answer;
    }
}