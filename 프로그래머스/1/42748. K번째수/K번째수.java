import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        List<Integer> order = new ArrayList<>();
        
        for(int i=0; i<commands.length; i++) {
            for(int j = commands[i][0]-1; j<commands[i][1]; j++) {
                order.add(array[j]);
            }
            
            Collections.sort(order);
            answer[i] = order.get(commands[i][2]-1);
            order.clear();
        }
        
        return answer;
    }
}