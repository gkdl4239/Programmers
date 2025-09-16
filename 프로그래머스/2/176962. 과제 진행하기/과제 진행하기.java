import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        
        Stack<String[]> tasks = new Stack<>();
        List<String> order = new ArrayList<>();
        
        Arrays.sort(plans, Comparator.comparing(a -> a[1]));
        int cur = 0;
        
        for(String[] plan : plans) {

            String name = plan[0];
            int start = Integer.parseInt(plan[1].substring(0,2)) * 60 + 
                    Integer.parseInt(plan[1].substring(3));
            int playtime = Integer.parseInt(plan[2]);
                
            while(!tasks.isEmpty() && cur + Integer.parseInt(tasks.peek()[2]) <= start) {
                cur += Integer.parseInt(tasks.peek()[2]);
                order.add(tasks.pop()[0]);
            }
            
            if(!tasks.isEmpty()) {
                tasks.peek()[2] = String.valueOf(cur + Integer.parseInt(tasks.peek()[2]) - start);
            }
            
            tasks.push(plan);
            cur = start;
        }
        
        while(!tasks.isEmpty()) {
            order.add(tasks.pop()[0]);
        }
        
        String[] answer = new String[plans.length];
        
        for(int i=0; i<order.size(); i++) {
            answer[i] = order.get(i);
        }
        
        return answer;
    }
}