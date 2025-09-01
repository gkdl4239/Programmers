import java.util.*;
class Solution {
    public List<Integer> solution(int[] answers) {
        
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[] scores = new int[3];
        
        List<Integer> winners = new ArrayList<>();
        
        for(int i=0; i<answers.length; i++) {
            if(p1[i%5] == answers[i]) scores[0]++;
            if(p2[i%8] == answers[i]) scores[1]++;
            if(p3[i%10] == answers[i]) scores[2]++;
        }
        
        int max = Math.max(scores[0], Math.max(scores[1], scores[2]));
        
        for(int j=0; j<scores.length; j++) {
            if(scores[j] == max) winners.add(j+1);
        }
        
        return winners;
    }
}