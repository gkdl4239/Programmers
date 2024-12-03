import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {

        List<Integer> answer = new ArrayList<>();

        int ty = Integer.parseInt(today.substring(2,4));
        int tm = Integer.parseInt(today.substring(5,7));
        int td = Integer.parseInt(today.substring(8,10));
        int tsum = 0;
        int sum = 0;

        tsum = ty*12*28 + tm*28 + td;
        for(int i=0; i<privacies.length; i++){
            int y = Integer.parseInt(privacies[i].substring(2,4));
            int m = Integer.parseInt(privacies[i].substring(5,7));
            int d = Integer.parseInt(privacies[i].substring(8,10));
            
            for(String term : terms){
                if(privacies[i].charAt(privacies[i].length()-1)==term.charAt(0)){
                    int mon = Integer.parseInt(term.substring(2));
                    sum = y*12*28 + (m+mon)*28 + d-1;
                    break;
                }
            }

            if(tsum > sum){
                answer.add(i+1);
            }


        }

        return answer;
    }
}