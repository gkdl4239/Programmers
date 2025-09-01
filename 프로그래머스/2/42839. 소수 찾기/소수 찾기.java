import java.util.*;
class Solution {
    
    HashSet<Integer> hash = new HashSet<>();
    
    
    private void dfs(StringBuilder cases, StringBuilder numbers) {
        
        if(!cases.toString().equals("")) {
            hash.add(Integer.parseInt(cases.toString()));
        }
        
        for(int i=0; i<numbers.length(); i++) {
            
            StringBuilder sliced = new StringBuilder();
            
            sliced.append(numbers.substring(0,i));
            sliced.append(numbers.substring(i+1));
            
            dfs(new StringBuilder(cases).append(numbers.charAt(i)), sliced);
        }
    }
    
    private boolean isPrime(int number) {
        
        if(number < 2) return false;
        if(number == 2) return true;
        if (number % 2 == 0) return false;
        
        for(int i=3; i<=Math.sqrt(number); i+=2) {
            if(number%i==0) return false;    
        }
        
        return true;
    }
    
    
    
    public int solution(String numbers) {
        
        int answer = 0;
        
        dfs(new StringBuilder(), new StringBuilder(numbers));
        
        for(int num : hash) {
            if(isPrime(num)) answer++;
        }
        
        return answer;
    }
}