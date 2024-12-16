import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int[] total = new int[elements.length*2];
        Set<Integer> set = new HashSet<>();
        
        for(int m=0; m<elements.length; m++) {
            total[m] = elements[m];
        }
        for(int m=elements.length; m<elements.length*2; m++) {
            total[m] = elements[m-elements.length];
        }
        
        for(int i=0; i<elements.length; i++) {
            for(int j=0; j<elements.length; j++) {
            int sum = 0;
                for(int k=0; k<i+1; k++) {
                    sum += total[j+k];
                }
            set.add(sum);
            }
        }
        
        return set.size();
    }
}