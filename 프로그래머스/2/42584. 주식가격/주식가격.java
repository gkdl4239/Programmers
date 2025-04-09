import java.util.*;

class Solution {
    
    class Stock {
        int price;
        int order;
        
        public Stock (int price, int order) {
            this.price = price;
            this.order = order;
        }
    }
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Stock> s = new Stack<>();
        
        prices[prices.length-1] = 0;
        
        for(int i = 0; i < prices.length; i++) {
            
            
            while(!s.isEmpty() && s.peek().price > prices[i]) {
                Stock cur = s.pop();
                answer[cur.order] = i - cur.order;
            }
            
            s.push(new Stock(prices[i], i));
        }
        
        return answer;
    }
}