import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = n + "";
        int sum = 0;
        for(int i = str.length()-1; i>=0; i--){
            sum += n/Math.pow(10,i);
            n = n%(int)Math.pow(10,i);
        }
        
        answer = sum;
        return answer;
    }
}