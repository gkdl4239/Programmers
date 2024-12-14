import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int tan : tangerine) {
            if(map.containsKey(tan)) {
                map.replace(tan,map.get(tan)+1);
                continue;
            }
            map.put(tan,1);
        }
        
        List<Integer> nums = new ArrayList<>(map.values());
        nums.sort(Comparator.reverseOrder());
        
        for(int i =0; i<nums.size(); i++) {
            answer++;
            sum += nums.get(i);
            if(sum>=k) break;
        }
        return answer;
    }
}