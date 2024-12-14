class Solution {
    public long solution(int n) {
        long answer = 1;
        
        int first = 0;
        int second = 1;
        int tmp = 0;
        for(int i=1; i<n; i++) {
            
            answer = (answer+second)%1234567;
            tmp = second;
            second = (first+second)%1234567;
            first = tmp;
            
        }
        
        return answer;
    }
}