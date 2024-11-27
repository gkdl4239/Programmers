class Solution {
    public int solution(String s) {
        int answer=0;
        
        StringBuilder sb = new StringBuilder(s);
        char first = s.charAt(0);
        int x= 1;
        int y= 0;
        
        for(int i=1; i<sb.length(); i++){
            if(x==y){
                answer++;
                first=sb.charAt(i);
            }
            if(sb.charAt(i)==first){
                x++;
            }
            else{
                y++;
            }
            
        }
        answer++;
        
        return answer;
    }
}