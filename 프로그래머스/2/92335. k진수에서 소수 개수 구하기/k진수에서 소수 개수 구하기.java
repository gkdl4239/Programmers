class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while(n>=k) {
            sb.insert(0,n%k);
            n /= k;
        }
        sb.insert(0,n);
        
        String[] nums = sb.toString().split("0"); 
        
        for(String strNum : nums) {
            
            if(strNum.equals("") || strNum.equals("1")) continue;
            long num = Long.parseLong(strNum);
            
            if(isPrime(num)) answer++;
        }
        return answer;
    }
    
    public boolean isPrime(long num) {
        if(num==1) return false;
        for(int i=2; i<=Math.sqrt(num); i++) {
                if(num%i==0) {
                    return false;
                }
        }
        return true;
    }
}