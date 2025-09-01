import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        
        StringBuilder sb = new StringBuilder();
        String[] words = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
            words[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(words, (o1, o2) -> (Integer.parseInt(o2+o1) - Integer.parseInt(o1+o2)));
        
        for(String word : words) {
            sb.append(word);
        }
        
        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}