import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> ks = new ArrayList<>();
        
        for(int i=0; i<score.length; i++){
            if(i<k){
                ks.add(score[i]);
                
            }
            else{
                if(score[i]>ks.get(0)){
                    ks.remove(0);
                    ks.add(score[i]);
                }
            }
            Collections.sort(ks);
            answer[i] = ks.get(0);
        }
        
        return answer;
    }
}