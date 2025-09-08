import java.util.*;
class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        Arrays.sort(wallet);
        
        answer = fold(bill, wallet);
        
        return answer;
    }
    
    private int fold(int[] bill, int[] wallet) {
        
        Arrays.sort(bill);
        
        if(bill[0] <= wallet[0] && bill[1] <= wallet[1]) return 0;
        
        bill[1] /= 2;
        
        return fold(bill, wallet) + 1;
    }
}