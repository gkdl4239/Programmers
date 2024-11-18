class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)==' ') sb.append(" ");
            
            else if(s.charAt(i)<91){
                char a = (char)(s.charAt(i)+n<91 ? s.charAt(i)+n : s.charAt(i)+n-26);
                sb.append(a);
            }else if(s.charAt(i)>91){
                char a = (char)(s.charAt(i)+n<123 ? s.charAt(i)+n : s.charAt(i)+n-26);
                sb.append(a);
            }
        }
        return sb.toString();
    }
}