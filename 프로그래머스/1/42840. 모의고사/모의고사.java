import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {0,0,0};
        
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int i =0;
        
        for(int ans : answers){
            if(i==5) i=0;
            if(ans==one[i]) answer[0]+=1;
            i++;
        }
        i=0;
        
        for(int ans : answers){
            if(i==8) i=0;
            if(ans==two[i]) answer[1]+=1;
            i++;
        }
        i=0;
        
        for(int ans : answers){
            if(i==10) i=0;
            if(ans==three[i]) answer[2]+=1;
            i++;
        }
        
        int max = Arrays.stream(answer)
                        .max()
                        .orElseThrow();
        
        List<Integer> order = new ArrayList<>();
        
        for(int j=0; j<3; j++){
            if(answer[j]==max){
                order.add(j);
            }
        }
        
        int[] array = new int[order.size()];
        for(int k=0; k<order.size(); k++){
            array[k] = order.get(k)+1;
        }
        
        
        return array;
    }
}