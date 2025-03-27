import java.util.*;

class Solution {
    public Integer[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> gmap = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            
            if(gmap.containsKey(genres[i])) {
                gmap.put(genres[i], gmap.get(genres[i]) + plays[i]);
            }
            else {
                gmap.put(genres[i], plays[i]);
            }
        }
        
        List<String> gkeySet = new ArrayList<>(gmap.keySet());
        
        gkeySet.sort((o1, o2) -> gmap.get(o2) - gmap.get(o1));
        
        HashMap<String, HashMap<Integer, Integer>> pmap = new HashMap<String, HashMap<Integer, Integer>>();
        
        for(int j = 0; j < genres.length; j ++) {
            
            if(!pmap.containsKey(genres[j])) {
                
                pmap.put(genres[j], new HashMap());
            }
            pmap.get(genres[j]).put(j, plays[j]);
        }
        
        List<Integer> album = new ArrayList<>();
        
        for(int k = 0; k < gkeySet.size(); k++) {
            String genre = gkeySet.get(k);
            List<Integer> pkeySet = new ArrayList<>(pmap.get(genre).keySet());
            
            pkeySet.sort((o1, o2) -> pmap.get(genre).get(o2) - pmap.get(genre).get(o1));
            
            album.add(pkeySet.get(0));
            
            if (pkeySet.size() > 1) {
                album.add(pkeySet.get(1));
            }
        }
        
        Integer[] answer = album.toArray(Integer[]::new);
        return answer;
    }
}