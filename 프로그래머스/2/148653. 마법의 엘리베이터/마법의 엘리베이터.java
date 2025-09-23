class Solution {
    
    private int count;
    
    private int minus(int storey, int first) {
        storey -= first;
        count += first;
        return storey;
    }
    
    private int plus(int storey, int first) {
        storey += 10 - first;
        count += 10 - first;
        return storey;
    }
    
    public int solution(int storey) {
        
        count = 0;
        
        while(storey != 0) {
            int first = storey%10;
            int second = storey%100/10;
            
            if(first<5) {
                storey = minus(storey, first);
            }
            else if(first>5) {
                storey = plus(storey, first);
            }
            else {
                if(second >= 5) storey = plus(storey, first);
                else storey = minus(storey, first);
            }
            storey /= 10;
        }
        
        return count;
    }
}