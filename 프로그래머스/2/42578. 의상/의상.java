import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        
        Map<String, Integer> hs = new HashMap<>();
        int answer = 1;
        
        for(String[] item : clothes) {
            hs.put(item[1], hs.getOrDefault(item[1], 1) + 1);
        }
        
        
        for(int num : hs.values()) {
            answer *= num;
        }
        
        return answer - 1;
    }
}