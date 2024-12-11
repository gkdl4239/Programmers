class Solution {
    public String solution(String s) {
        String answer = "";
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s);
        sb.replace(0,1,sb.substring(0,1).toUpperCase());
        for(int i=1; i<sb.length(); i++){
            if(sb.substring(i-1,i).equals(" ")){
                sb.replace(i,i+1,sb.substring(i,i+1).toUpperCase());
            }
        }

        return sb.toString();
    }
}