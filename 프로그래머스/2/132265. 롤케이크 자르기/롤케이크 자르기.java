import java.util.*;
class Solution {
    public int solution(int[] topping) {
        
        HashMap<Integer, Integer> sPiece = new HashMap<>();
        HashMap<Integer, Integer> fPiece = new HashMap<>();
        int count = 0;
        
        for(int top : topping) {
            sPiece.put(top, sPiece.getOrDefault(top, 0) + 1);
        }
        
        for(int top : topping) {
            fPiece.put(top, fPiece.getOrDefault(top, 0) + 1);
            sPiece.put(top, sPiece.get(top) - 1);
            
            if(sPiece.get(top) == 0) sPiece.remove(top);
            if(fPiece.size() == sPiece.size()) count++;
        }
        
        return count;
    }
}