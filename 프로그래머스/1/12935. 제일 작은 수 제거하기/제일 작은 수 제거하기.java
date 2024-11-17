import java.util.List;
import java.util.ArrayList;
class Solution {
    public int[] solution(int[] arr) {
        
        List<Integer> list = new ArrayList<>();
        
        if(arr.length<2){
            int[] minus = {-1};
            return minus;
        }
        
        int min =arr[0];
        list.add(arr[0]);
        for(int i=1; i<arr.length; i++){
            list.add(arr[i]);
            if(min>arr[i]) min = arr[i];
        }
        list.remove(Integer.valueOf(min));
        
        int[] answer = new int[list.size()];
        for(int j=0; j<list.size(); j++){
            answer[j] = list.get(j);
        }
        return answer;
    }
}