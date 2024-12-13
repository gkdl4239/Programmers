
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = (brown-4)/2;
        for(int i=1; i<sum; i++) {
            if(i*(sum-i) == yellow) {
                answer[0] = Math.max(i,sum-i)+2;
                answer[1] = Math.min(i,sum-i)+2;
                break;
            }
        }
        
        return answer;
    }
}