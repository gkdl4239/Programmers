import java.util.*;
class Solution {
    
    HashSet<Integer> hash = new HashSet<>();
    
    private void dfs(StringBuilder sb, StringBuilder numbers) {
        
        if(!sb.toString().equals("")) {
            hash.add(Integer.parseInt(sb.toString()));
        }
        
        for(int i = 0 ; i < numbers.length(); i++) {
            
            StringBuilder sliced = new StringBuilder();
            
            sliced.append(numbers.substring(0,i));
            sliced.append(numbers.substring(i+1));
            
            dfs(new StringBuilder(sb).append(numbers.charAt(i)), sliced);
        }
    }
    
    public int solution(String numbers) {
        
        int answer = 0;
        
        dfs(new StringBuilder(), new StringBuilder(numbers));
        
        for(int number : hash) {
            
            if(number < 2) continue;
            
            boolean isPrime = true;
            for(int i = 2; i < (int)Math.sqrt(number) + 1; i++) {
                if(number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) answer++;
        }
        
        return answer;
    }
}