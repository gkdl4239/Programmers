import java.util.*;
class Solution {
    boolean solution(String s) {
        
        int cnt = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') cnt++;
            else cnt--;
            
            if(cnt < 0) {
                break;
            }
        }
        
        return cnt == 0 ? true : false;
    }
}