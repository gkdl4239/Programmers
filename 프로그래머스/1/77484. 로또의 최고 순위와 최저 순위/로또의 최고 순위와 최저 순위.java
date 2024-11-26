class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero = 0;
        int min = 0;
        
        for(int num:lottos){
            if(num==0){
                zero++;
                continue;
            }
            for(int i=0; i<win_nums.length; i++){
                if(num == win_nums[i]) min++;
            }
        }
        answer[0] = 7-min-zero<=1 ? 1 : 7-min-zero;
        if(answer[0]==7)answer[0]=6;
        answer[1] = 7-min>=6 ? 6 : 7-min;
        
        
        return answer;
    }
}