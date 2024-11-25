class Solution {
    public int solution(int n, int m, int[] section){
        int answer=1;
        int std = section[0];
        for(int i : section){
            if(i<std+m){
                continue;
            }else{
                answer++;
                std = i;
            }
        }
        return answer;
    }
}