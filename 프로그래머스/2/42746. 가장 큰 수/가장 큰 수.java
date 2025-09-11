import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        
        String[] words = new String[numbers.length];
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<numbers.length; i++) {
            words[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(words, (o1, o2) -> (Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2)));
        
        for(String word : words) {
            sb.append(word);
        }
        
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}