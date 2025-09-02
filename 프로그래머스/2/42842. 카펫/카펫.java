
class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] answer = new int[2];
        
        for(int i=1; i<=Math.sqrt(yellow); i++) {
            if(yellow % i == 0 && brown == 2*i + 2*(yellow/i) + 4) {
                answer[0] = yellow / i + 2;
                answer[1] = i + 2;
                break;
                }
            }
        
        return answer;
        }
    }