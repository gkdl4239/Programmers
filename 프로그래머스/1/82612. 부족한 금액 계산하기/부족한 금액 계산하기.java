class Solution {
    public long solution(long price, int money, long count) {
        long answer = -1;
        long sum = 0;
        sum = (count*(count+1)/2*price);
        if(money >= sum) {
            return 0;
        }else return sum-money;
        
    }
}