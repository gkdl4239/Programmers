import java.util.Stack;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> ing = new Stack<>();
        
        for(int i : ingredient){
            ing.push(i);
            while(ing.size()>=4){
                if(ing.get(ing.size()-1)==1&&ing.get(ing.size()-2)==3&&ing.get(ing.size()-3)==2&&ing.get(ing.size()-4)==1){
                    ing.pop();
                    ing.pop();
                    ing.pop();
                    ing.pop();
                    answer++;
                }
                else{
                    break;
                }
            }
        }
        
        return answer;
    }
}