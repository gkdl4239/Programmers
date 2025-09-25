import java.util.*;
class Solution {
    
    class Word {
        
        String word;
        int count;
        
        public Word (String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    
    private boolean changeable (String word, String target) {
        
        int changed = 0;
        for(int i=0; i<word.length(); i++) {
            if(word.charAt(i) != target.charAt(i)) changed++;
        }
        
        return changed == 1;
    }
    
    public int solution(String begin, String target, String[] words) {
        
        Queue<Word> bfs = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        bfs.add(new Word(begin, 0));
        visited.add(begin);
        
        while(!bfs.isEmpty()) {
            
            Word cur = bfs.poll();
            
            if(cur.word.equals(target)) return cur.count;
            
            for(int i=0; i<words.length; i++) {
                
                if(!visited.contains(words[i]) && changeable(cur.word, words[i])) {
                    visited.add(words[i]);
                    bfs.add(new Word(words[i], cur.count+1));
                } 
            }
            
        }
        
        return 0;
    }
}