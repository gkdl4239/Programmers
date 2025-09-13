class Solution {
    
    String std = "";
    int order = 0;
    boolean found = false;
    
    private void dfs(String word) {
        
        if(found) return;
        
        if(!word.equals("")) order++;
        
        if(word.equals(std)) {
                std = word;
                found = true;
                return;
        }
        
        if(word.length() == 5) return;
        
        for(int i=0; i<5; i++) {
            dfs(word + "AEIOU".charAt(i));
        }
    }
    
    public int solution(String word) {
        
        std = word;
        dfs("");
        
        return order;
    }
}