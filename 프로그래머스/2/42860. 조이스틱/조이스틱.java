class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int length = name.length();
        
        int[] alpha =  new int[name.length()];
        
        for(int i = 0; i < length; i++) {
            char cur = name.charAt(i);
            
            answer += Math.min(cur - 'A', 'Z' - cur + 1);
        }
        
        int move = length - 1;
        
        for(int j = 0; j < length; j++) {
            
            int next = j+1;
            
            while(next < length && name.charAt(next) == 'A') {
                next++;
            }
            
            int moveRAndL = j * 2 + (length - next);
            int moveLAndR = (length - next) * 2 + j;
            
            move = Math.min(move, Math.min(moveRAndL, moveLAndR));
        }
        answer += move;
        return answer;
    }
}