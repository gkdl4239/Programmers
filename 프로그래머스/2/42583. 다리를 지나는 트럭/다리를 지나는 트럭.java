import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> bridge = new LinkedList<>();
        int i = 0;
        int cur_weights = 0;
        int answer = 0;
        
        do {
            if(bridge.size() == bridge_length) {
                cur_weights -= bridge.poll();
            }
            
            if(i < truck_weights.length && cur_weights + truck_weights[i] <= weight) {
                cur_weights += truck_weights[i];
                bridge.add(truck_weights[i++]);
            } 
            else {
                bridge.add(0);    
            }
            
            answer++;
        } while(cur_weights != 0);
        
        return answer;
    }
}