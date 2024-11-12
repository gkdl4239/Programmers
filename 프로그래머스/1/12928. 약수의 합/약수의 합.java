class Solution {
    public int solution(int n) {
        int answer = 0;
        answer += n+1;
        
        if(n<2){
            answer=n;
        }else if(n==2){
            answer=3;
        }else{
            for(int i=2; i<=n/2; i++){
                if(n%i==0){
                    answer +=i;
            }
        }
        }
        return answer;
    }
}