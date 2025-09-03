class Solution {
    
    int std;
    int answer;
    int n;
    
    public int solution(int[] numbers, int target) {
        
        std = target;
        answer = 0;
        n = numbers.length;
        
        dfs(numbers, 0, 0);
        
        return answer;
    }
    
    private void dfs(int[] numbers, int cal, int count) {
        
        if(count == n) {
            if(std == cal) answer++;
            return;
        }
        
        dfs(numbers, cal + numbers[count], count+1);
        dfs(numbers, cal - numbers[count], count+1);
        
    }
}