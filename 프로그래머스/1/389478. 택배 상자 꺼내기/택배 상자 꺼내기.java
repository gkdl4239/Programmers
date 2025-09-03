class Solution {
    public int solution(int n, int w, int num) {
        int answer = 1;
        
        int q = (num-1) / w + 1;
        
        
        while(true) {
            
            int r = num % w;
            
            if(q % 2 == 1) num += 2*w - 2 * (r-1) - 1;
            else num +=  + 1;
            
            if(num > n) break;
            
            answer++;
        }
        
         
        return answer;
    }
}