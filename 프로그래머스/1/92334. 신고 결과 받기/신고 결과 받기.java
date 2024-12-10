import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];


        Set<String> reportList = new HashSet<>(Arrays.asList(report));
        Map<String,List<String>> reported = new HashMap<>();
        Map<String,Integer> num = new HashMap<>();

        for(String id : id_list){
            num.put(id,0);
        }

        Iterator<String> it = reportList.iterator();

        while(it.hasNext()){
            String[] both = it.next().split(" ");
            if(reported.containsKey(both[1])){
                reported.get(both[1]).add(both[0]);
            }
            else{
                reported.put(both[1],new ArrayList<>());
                reported.get(both[1]).add(both[0]);
            }
        }

        for(String id : id_list){
            if(!reported.containsKey(id)){
                continue;
            }
            if(reported.get(id).size()>=k){
                for(String reporter : reported.get(id)){
                    num.replace(reporter,num.get(reporter)+1);
                }
            }
        }
        
        for(int i=0; i<id_list.length; i++){
            answer[i] = num.get(id_list[i]);
        }
        return answer;
    }
}