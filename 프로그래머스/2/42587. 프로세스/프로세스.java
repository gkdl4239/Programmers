import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        
        int answer = 0;
        int l = location;
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i : priorities) {
            q.add(i);
        }
        
        Arrays.sort(priorities);
        
        int size = priorities.length - 1;
        
        while(!q.isEmpty()) {
            
            int j = q.poll();
            
            if(j == priorities[size - answer]) {
                
                l--;
                answer++;
                if(l<0) {
                    break;
                }
            }
            else {
                q.add(j);
                l--;
                if(l<0) {
                    l = q.size() - 1;
                }
            }
        }
        
        return answer;
    }
}