import java.util.*;
class Solution {
    public int[] solution(int[] num_list) {
        Stack<Integer> s = new Stack<>();
        int[] reverse = new int[num_list.length];
        
        for(int num : num_list) {
            s.push(num);    
        }
        
        for(int i=0; i<num_list.length; i++) {
            reverse[i] = s.pop();
        }
        
        return reverse;
    }
}