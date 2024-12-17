class Solution {
    public long[] solution(int n, long left, long right) {
        left += 1;
        right += 1;
        
        long[] answer = new long[(int)(right-left+1)];
        
        for(int i=0; i<answer.length; i++) {
            
            long cur = left + i;
            long quotient = (long)Math.ceil((double)cur/n);
            long rest = cur%n;
            
            if(rest == 0) {
                answer[i] = n;
                continue;
            }
            
            if(rest <= quotient) {
                answer[i] = quotient;
                continue;
            }
            
            answer[i] = rest;
            
            
        }
        
        
        
        return answer;
    }
}