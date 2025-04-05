import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int day = 0;
        for(int i = 0; i < speeds.length; i++) {
            
            day = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
            
            if(!q.isEmpty() && q.peek() < day) {
                list.add(q.size());
                q.clear();
            }
            q.add(day);
        }
        
        list.add(q.size());
        
        int[] answer = new int[list.size()];
        
        int index = 0;
        for(int num : list) {
            answer[index++] = num;
        }
        
        return answer;
    }
}