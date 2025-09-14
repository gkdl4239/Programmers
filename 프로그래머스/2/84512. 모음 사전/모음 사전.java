class Solution {
    
    String std;
    int count;
    boolean found;
    
    private void dfs(String word) {
        
        if(found) return;
        if(!word.equals("")) count++;
        if(word.equals(std)) {
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
        found = false;
        count = 0;
        dfs("");
        
        return count;
    }
}