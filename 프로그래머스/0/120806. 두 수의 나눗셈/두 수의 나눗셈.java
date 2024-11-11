class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        double t= num1 / (double)num2;
        answer = (int)(1000*t);
        return answer;
    }
}