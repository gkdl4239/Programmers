import java.util.Arrays;
import java.util.Collections;
class Solution {
    public String solution(String s) {
        char[] chars = s.toCharArray();
        Character[] Chars = new Character[chars.length];
        
        for(int i=0;i<chars.length;i++){
            Chars[i] = chars[i];
        }
        
        Arrays.sort(Chars,Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(Character i:Chars){
            sb.append(i);
        }
        return sb.toString();
    }
}