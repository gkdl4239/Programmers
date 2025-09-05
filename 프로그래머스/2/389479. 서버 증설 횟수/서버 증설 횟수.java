import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        
        Queue<Integer> server = new LinkedList<>();
        int answer = 0;
        
        for(int t=0; t<players.length; t++) {
            
            while(!server.isEmpty() && server.peek() <= t) {
                server.poll();
            }
            
            int limit = m * (server.size()+1) - 1;
            
            if(players[t] > limit) {
                int needed = (int)Math.ceil((players[t] - limit) / (float)m);
                answer += needed;
                
                for(int i=0; i<needed; i++) {
                    server.add(t + k);
                }
            }
            
            
        }
        
        return answer;
    }
 }