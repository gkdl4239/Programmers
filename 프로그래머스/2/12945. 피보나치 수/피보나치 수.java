class Solution {
    public int solution(int n) {
        int previous = 0;
        int answer = 1;
        int tmp = 0;
        for(int i=1; i<n; i++){
            tmp = answer;
            answer = (answer + previous) % 1234567;
            previous = tmp;
        }

        return answer;
    }
}