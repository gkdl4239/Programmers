class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        
        for(int i=0; i<targets.length; i++){
            
            int count = 0;
            
            for(int k=0; k<targets[i].length(); k++){
                String std = ""+targets[i].charAt(k);
                int min = 101;
                for(int j=0; j<keymap.length; j++){
                    int index = keymap[j].indexOf(std);
                    if(index!=-1){
                        min = Math.min(min,index);
                    }
                }
                if(min == 101){
                    count = -1;
                    break;
                }
                count += min;
                count++;
            }
            answer[i]=count;
        }
        
        return answer;
    }
}