import java.util.*;

class Solution {
    
    int count;
    int answer;
    
    public int solution(String word) {
        
        dfs(new StringBuilder(), word);
        
        return answer;
    }
    
    boolean dfs(StringBuilder sb, String word) {
        
        if(sb.toString().equals(word)) {
            return true;
        }
        
        if(sb.length() >= 5) {
            return false;
        }
        
        for(char c : "AEIOU".toCharArray()) {
            
            sb.append(c);
            count++;
            
            if(dfs(sb,word)) {
                answer = count;
                return true;
            }
            
            sb.deleteCharAt(sb.length()-1);
        }
        
        return false;
    }
}