import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
    
        for(int i=0; i<discount.length-9; i++) {
            int check =0;
            Map<String,Integer> map = new HashMap<>();
            for(int j=i; j<i+10; j++) {
                if(map.containsKey(discount[j])) {
                    map.put(discount[j],map.get(discount[j])+1);
                }
                else {
                    map.put(discount[j],1);
                }
            }
            for(int k=0; k<want.length; k++) {
                if(map.containsKey(want[k])) {
                    if(map.get(want[k]) >= number[k]) check++;
                }
            }
            if(check==number.length) answer++;
        }
        
        return answer;
    }
}