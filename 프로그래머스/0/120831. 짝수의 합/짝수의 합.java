class Solution {
    public int solution(int n) {
        int answer = 0;
        n= n/2;
        answer = n*(n-1) + 2*n;
        return answer;
    }
}