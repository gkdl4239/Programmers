import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> hash = new HashMap<>();
        String answer = "";
        
        for(String player : participant) hash.put(player, hash.getOrDefault(player, 0) + 1);
        for(String player : completion) hash.put(player, hash.getOrDefault(player, 0) - 1);
        
        for(String key : hash.keySet()) {
            if(hash.get(key) == 1) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}