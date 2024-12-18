import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String,Integer> map = new HashMap<>();
        for(String[] cloth : clothes) {
            if(map.containsKey(cloth[1])) {
                map.replace(cloth[1],map.get(cloth[1])+1);
            }
            else {
                map.put(cloth[1],1);
            }
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        for(int i=0; i<list.size(); i++) {
            answer *= (list.get(i)+1);
        }
        return answer-1;
    }
}