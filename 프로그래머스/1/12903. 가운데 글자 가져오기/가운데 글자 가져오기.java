class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        if(s.length()%2==1){
            return Character.toString(sb.charAt((s.length()+1)/2-1));
        }
        else{
            return sb.substring(s.length()/2-1,s.length()/2+1);
        }
        
        
    }
}