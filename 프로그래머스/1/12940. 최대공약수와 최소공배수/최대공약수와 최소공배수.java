class Solution {
    public int[] solution(int n, int m) {
        
        int i=0;
        int std =0;
        if(n>m){
            std = m;
            i = n;
        } else {
            std = n;
            i = m;
        }
        while(true){
            if(i%n==0 && i%m==0){
                break;
            }
            i++;
        }
        while(true){
            if(n%std==0&& m%std==0){
                break;
            }
            std--;
        }
        int[] answer ={std,i};
        return answer;
    }
}