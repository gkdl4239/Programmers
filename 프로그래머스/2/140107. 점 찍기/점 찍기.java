class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        long D = d;
        for(long i=0; i<=d; i+=k) {
            int dots = (int)Math.sqrt(D*D - i*i) / k;
            answer += dots;
        }
        
        answer += d/k+1;
        
        return answer;
    }
}