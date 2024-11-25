class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        int i =0;
        int len = nums.length;
        for(;i<len-2;i++){
            for(int j=i+1; j<len-1; j++){
                for(int k=j+1; k<len; k++){
                    int num = nums[i]+nums[j]+nums[k];
                    int count = 0;
                    for(int m=2; m<num/2; m++){
                        if(num%m==0){
                            count++;
                        }
                    }
                    if(count==0) answer++;
                }
            }
        }
        return answer;
    }
}