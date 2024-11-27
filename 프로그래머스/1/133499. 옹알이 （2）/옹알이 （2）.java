class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] nep = {"aya","ye","woo","ma"};
        
        
        for(String word : babbling){
            
            String dup = "";
            String compare = "";
            for(int i=0; i<word.length(); i++){
                compare += word.charAt(i);
                
                for(String nepword : nep){
                    if(compare.equals(nepword) && !compare.equals(dup)){
                        dup = compare;
                        compare ="";
                        
                    }
                }
            }
            if(compare.isEmpty()) answer++;
        }
        
        return answer;
    }
}