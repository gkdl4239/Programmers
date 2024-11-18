class Solution {
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();
        long answer=0;
        while(n>=3){
            sb.append(n%3);
            n /= 3;
        }
        sb.append(n);
        
        for(int i=sb.length()-1; i>=0; i--){
            answer += (sb.charAt(i)-'0')*Math.pow(3,sb.length()-i-1);
        }
        
        
        return answer;
    }
}