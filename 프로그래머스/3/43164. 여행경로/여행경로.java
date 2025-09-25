import java.util.*;
class Solution {
    
    static List<List<String>> routes;
    
    private void dfs(String cur, String[][] tickets, boolean[] visited, List<String> route) {
        
        if(route.size() == tickets.length+1) routes.add(new ArrayList<>(route));
        
        for(int i=0; i<tickets.length; i++) {
            if(cur.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                route.add(tickets[i][1]);
                
                dfs(tickets[i][1], tickets, visited, route);
                
                visited[i] = false;
                route.remove(route.size()-1);
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        
        routes = new ArrayList<>();
        boolean[] visited = new boolean[tickets.length];
        
        String depart = "ICN";
        List<String> initial = new ArrayList<>();
        initial.add(depart);
        
        dfs(depart, tickets, visited, initial);
        
        Collections.sort(routes, (list1, list2) -> {
            int size = list1.size();
            
            for(int i=0; i<size; i++) {
                int comp = list1.get(i).compareTo(list2.get(i));
                if(comp != 0) return comp;
            }
            
            return 0;
        });
        
        return routes.get(0).toArray(String[]::new);
    }
}