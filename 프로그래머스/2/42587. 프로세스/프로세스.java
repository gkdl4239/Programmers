import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int order = 0;
        int count = 0;
        Integer[] reverse = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
        Arrays.sort(reverse,Collections.reverseOrder());
        
        for(Integer num : reverse) {
            while(true) {
                count %=priorities.length;
                if(priorities[count] == num) {
                    priorities[count] = 0;
                    order ++;
                    break;
                }
                count++;
            }
            if(count == location) {
                break;
            }
        }
        return order;
    }
}