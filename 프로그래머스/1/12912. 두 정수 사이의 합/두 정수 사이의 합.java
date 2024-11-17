class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        long sum = (long)(a + b) * (b - a + 1) / 2;
        return sum;
    }
}