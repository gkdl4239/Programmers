import java.util.List;
import java.util.ArrayList;
class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int ori = x;
        List<Integer> nums = new ArrayList<>();
        while(x>0){
            nums.add(x%10);
            x= x/10;
        }
        
        int sum=0;
        for(int num : nums){
            sum+=num;
        }
        
        if(ori%sum!=0){
            answer = false;
        }
        return answer;
    }
}