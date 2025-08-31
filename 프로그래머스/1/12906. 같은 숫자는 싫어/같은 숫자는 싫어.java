import java.util.*;

public class Solution {
    public ArrayList<Integer> solution(int []arr) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        int pre = arr[0];
        
        for(int i=1; i<arr.length; i++) {
            if(pre == arr[i]) {
                continue;
            }
            
            list.add(pre);
            pre = arr[i];
        }
        
        list.add(pre);
        
        return list;
    }
}