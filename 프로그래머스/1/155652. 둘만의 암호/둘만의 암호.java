import java.util.Set;
import java.util.HashSet;
class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        
        Set<Character> skipset = new HashSet<>();
        
        for(char c : skip.toCharArray()){
            skipset.add(c);
        }
        
        for(int i=0; i<s.length(); i++){
            char current = s.charAt(i);
            int move = 0;
            
            
            while(move<index){
                current++;
                if(current>'z'){
                    current = 'a';
                }
                
                if(!skipset.contains(current)){
                    move++;
                }
            }
            sb.append(current);
        }
        
        
        return sb.toString();
    }
}