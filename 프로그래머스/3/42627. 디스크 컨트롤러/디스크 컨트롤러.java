import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        
        int sum = 0;
        int curTime = 0;
        
        PriorityQueue<int[]> jobQ = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        
        PriorityQueue<int[]> waitQ = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        for(int[] job : jobs) {
            jobQ.add(job);
        }
        
        while(!jobQ.isEmpty() || !waitQ.isEmpty()) {
            
            while(!jobQ.isEmpty() && curTime >= jobQ.peek()[0]) {
                waitQ.add(jobQ.poll());
            }
            
            if(waitQ.isEmpty()) {
                curTime = jobQ.peek()[0];
                continue;
            }
            
            int[] task = waitQ.poll();
            
            curTime += task[1];
            sum += curTime - task[0];
        }
        
        return sum/jobs.length;
    }
}