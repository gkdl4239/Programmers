import java.util.HashMap;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(String key : keymap){
            for(int i=0; i<key.length(); i++){
                char ch = key.charAt(i);
                
                if(map.containsKey(ch)){
                    if(i+1<map.get(ch)){
                        map.replace(ch,i+1);
                    }
                }
                
                else{
                    map.put(ch,i+1);
                }
            }
        }
        
        for(int k=0; k<targets.length; k++){
            
            int count = 0;
            for(int j=0; j<targets[k].length(); j++){
                if(map.containsKey(targets[k].charAt(j))){
                    count+=map.get(targets[k].charAt(j));
                }
                else{
                    count=-1;
                    break;
                }
            }
            answer[k] = count;
        }
        
        return answer;
    }
}