import java.util.stream.IntStream;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        int[] order = IntStream.of(score).boxed().sorted((a,b)->b-a).mapToInt(Integer::intValue).toArray();
        
        for(int i=0; i<score.length/m; i++){
            answer += m*order[m*i+m-1];
        }
        return answer;
    }
}