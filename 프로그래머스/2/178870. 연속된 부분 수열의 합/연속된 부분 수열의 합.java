class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int[] answer = new int[2];
        int left = 0,
            right = 0,
            min = 1000000,
            sum = sequence[0],
            length = sequence.length;
        
        while(left <= right && right < length) {
            
            if(sum == k) {
                if(min > right - left) { 
                    min = right - left;
                    answer[0] = left;
                    answer[1] = right;
                }
            } 
            
            if(sum <= k) {
                right++;
                if(right < length) sum += sequence[right];
                
            } else {
                sum -= sequence[left++];
            }
        }
        
        return answer;
    }
}