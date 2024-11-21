import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        Queue<String> deck1 = new LinkedList<>();
        Queue<String> deck2 = new LinkedList<>();
        Queue<String> deck3 = new LinkedList<>();
        for(String i : cards1){
            deck1.add(i);
        }
        for(String j : cards2){
            deck2.add(j);
        }
        for(String k : goal){
            deck3.add(k);
        }
        
        for(int n = 0; n<goal.length; n++){
            if(deck3.peek().equals(deck1.peek())){
                deck3.poll();
                deck1.poll();
            } else if(deck3.peek().equals(deck2.peek())){
                deck3.poll();
                deck2.poll();
            } else{
                return "No";
            }
        }
        return "Yes";
    }
}