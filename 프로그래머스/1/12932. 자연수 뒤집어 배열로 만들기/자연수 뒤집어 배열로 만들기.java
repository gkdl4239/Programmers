class Solution {
    public int[] solution(long n) {
        
        String input = ""+n;
        int[] answer = new int[input.length()];
        for(int i=input.length()-1; i>=0; i--){
            answer[input.length()-i-1]=input.charAt(i)-'0';
        }
        return answer;
    }
}