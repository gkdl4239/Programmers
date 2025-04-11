import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        PriorityQueue<Integer> rq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String operation : operations) {
            String[] op = operation.split(" ");
            
            if(op[0].equals("I")) {
                q.add(Integer.parseInt(op[1]));
                rq.add(Integer.parseInt(op[1]));
            }
            else if (op[0].equals("D") && !q.isEmpty()) {
                if(op[1].equals("1")) {
                    int max = rq.poll();
                    q.remove(max);
                }
                else if(op[1].equals("-1")) {
                    int min = q.poll();
                    rq.remove(min);
                }
            }
        }
        
        int max = rq.isEmpty() ? 0 : rq.poll();
        int min = q.isEmpty() ? 0 : q.poll();
        return new int[]{max,min};
    }
}