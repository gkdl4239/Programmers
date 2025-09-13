import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        Arrays.sort(people);
        
        int max = people.length-1;
        int min = 0;
        
        while(max > min) {
            if(people[max] + people[min] <= limit) {
                min++;
            }
            max--;
        }
        
        return people.length - min;
    }
}