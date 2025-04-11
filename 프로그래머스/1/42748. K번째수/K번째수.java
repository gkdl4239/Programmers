import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            
            int first = commands[i][0]-1;
            int last = commands[i][1];
            int[] slice = new int[last - first];
            for(int j = 0; j < last - first; j++) {
                slice[j] = array[j+first];
            }
            Arrays.sort(slice);
            answer[i] = slice[commands[i][2]-1];
        }
        
        return answer;
    }
}