import java.util.Map;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};

        Map<String,Integer> values = new HashMap<>();
        
        for(int i=0; i<players.length; i++){
            values.put(players[i],i);
        }
        
        String tmp = "";
        for(String calling : callings){
            int index = values.get(calling);
            
            tmp = players[index];
            players[index] = players[index-1];
            players[index-1] = tmp;
            
            values.replace(players[index],index);
            values.replace(players[index-1],index-1);
        
        }
        return players;
    }
}
    