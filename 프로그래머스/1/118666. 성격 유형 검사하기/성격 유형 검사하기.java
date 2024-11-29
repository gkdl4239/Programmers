import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        HashMap<Character,Integer> score = new HashMap<>();
        
        List<Character> keys = Arrays.asList('R','T','C','F','J','M','A','N');
        for(Character key : keys){
            score.put(key,0);
        }
        for(int i=0; i<choices.length; i++){
            char one = survey[i].charAt(0);
            char two = survey[i].charAt(1);
            if(choices[i] >=4){
                score.put(two,score.get(two)+choices[i]%4);
            }
            
            if(choices[i] <4){
                score.put(one,score.get(one)+4-choices[i]);
            }
        }
        
        answer += score.get('R') >= score.get('T') ? "R" : "T";
        answer += score.get('C') >= score.get('F') ? "C" : "F";
        answer += score.get('J') >= score.get('M') ? "J" : "M";
        answer += score.get('A') >= score.get('N') ? "A" : "N";
        return answer;
    }
}