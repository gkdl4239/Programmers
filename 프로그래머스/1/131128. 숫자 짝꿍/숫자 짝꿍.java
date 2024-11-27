import java.util.Arrays;
class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        
        int[] x = new int[10];
        int[] y = new int[10];
        
        for(int i=0; i<X.length(); i++){
            x[X.charAt(i)-'0']++;
        }
        
        for(int j=0; j<Y.length(); j++){
            y[Y.charAt(j)-'0']++;
        }
        
        for(int k=9; k>=0; k--){
            for(int m=0; m<Math.min(x[k],y[k]); m++){
                answer.append(k);
            }
        }
        String strAnswer = answer.toString();
        if(strAnswer.isEmpty()) strAnswer = "-1";
        if(strAnswer.replace("0","").isEmpty()) strAnswer = "0";
        return strAnswer;
    }
}