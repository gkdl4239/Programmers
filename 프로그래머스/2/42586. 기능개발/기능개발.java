import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> list = new ArrayList<>();
        int days = 0;
        int max = 0;
        int count = 0;
        for(int i=0; i<progresses.length; i++) {
            days = (100-progresses[i])%speeds[i]==0 ? (100-progresses[i])/speeds[i] : (100-progresses[i])/speeds[i]+1;
            if(i==0) {
                max = days;
                count++;
                continue;
            }
            if(max<days) {
                list.add(count);
                max = days;
                count=0;
            }
            if(max>=days) {
                count++;
            }
            if(i == progresses.length-1) list.add(count);
        }
        
        int[] answer = new int[list.size()];
        for(int j=0; j<answer.length; j++) {
            answer[j] = list.get(j);
        }
        return answer;
    }
}