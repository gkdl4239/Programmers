import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Map<String, Integer> hash = new HashMap<>();
        
        for(int i = 0; i < completion.length; i++) {
            hash.put(participant[i], hash.getOrDefault(participant[i], 0) + 1);
            hash.put(completion[i], hash.getOrDefault(completion[i], 0) - 1);
        }
        hash.put(participant[participant.length-1], hash.getOrDefault(participant[participant.length-1], 0) + 1);
        
        Set<String> keySet = hash.keySet();
        
        String answer = "";
        
        for(String key : keySet) {
            if(hash.get(key) == 1) {
                answer = key;
                break;
            }    
        }
        
        return answer;
        
    }
}