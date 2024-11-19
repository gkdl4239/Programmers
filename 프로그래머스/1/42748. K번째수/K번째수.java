import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> cut = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        
        for(int i=0; i<commands.length; i++){
            for(int j=commands[i][0]-1; j<commands[i][1]; j++){
                cut.add(array[j]);
            }
            Collections.sort(cut);
            nums.add(cut.get(commands[i][2]-1));
            cut = new ArrayList<>();
        }
        
        int[] answer = nums.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}