import java.util.LinkedHashSet;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] numbers) {
        
        LinkedHashSet<Integer> hs = new LinkedHashSet<>();
        
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                hs.add(numbers[i]+numbers[j]);
            }
        }
        Integer[] array = hs.toArray(new Integer[0]);
        Arrays.sort(array);
        int[] answer = new int[array.length];
        for(int k=0; k<array.length; k++){
            answer[k] = array[k];
        }
        return answer;
    }
}