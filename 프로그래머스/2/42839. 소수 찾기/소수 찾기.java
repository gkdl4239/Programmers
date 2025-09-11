import java.util.*;
class Solution {
    
    HashSet<Integer> hash = new HashSet<>();
    
    public int solution(String numbers) {
        
        int answer = 0;
        
        dfs(new StringBuilder(), new StringBuilder(numbers));
        
        for(int number : hash) {
            if(isPrime(number)) answer++;
        }
        
        return answer;        
    }
    
    private void dfs(StringBuilder cases, StringBuilder numbers) {
        
        if(!cases.toString().equals("")) {
            hash.add(Integer.parseInt(cases.toString()));
        }
        
        for(int i=0; i<numbers.length(); i++) {
            
            dfs(new StringBuilder(cases).append(numbers.charAt(i)), 
                new StringBuilder(numbers.substring(0, i)).append(numbers.substring(i+1)));
        }
    }
    
    private boolean isPrime(int number) {
        
        if(number < 2) return false;
        if(number == 2) return true;
        
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) return false;
        }
        
        return true;
    }
    
}