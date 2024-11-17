class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left;i<=right;i++){
            if(Math.pow((int)Math.sqrt(i),2)==i){
                answer -=i;
                System.out.print(i);
            }
            else answer+=i;
        }
        return answer;
    }
}