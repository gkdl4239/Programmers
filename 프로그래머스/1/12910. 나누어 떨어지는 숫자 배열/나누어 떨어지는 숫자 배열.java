import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> nums = new ArrayList<>();
        for(int n : arr){
            if(n%divisor ==0){
                nums.add(n);
            }
        }
        if(nums.size()==0) {
            nums.add(-1);
        }
        Collections.sort(nums);
        int[] answer = new int[nums.size()];
        for(int i=0;i<nums.size();i++){
            answer[i] = nums.get(i);
        }
        return answer;
        }
        
    }
