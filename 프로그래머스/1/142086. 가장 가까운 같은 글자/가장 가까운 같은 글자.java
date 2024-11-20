class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        answer[0] = -1;
        int find = -1;
        for(int i=1; i<s.length(); i++){
            find = -1;
            for(int j=i-1; j>=0; j--){
                if(s.charAt(j)==s.charAt(i)){
                    find = i-j;
                    answer[i] = find;
                    break;
                }
                answer[i] = find;
            }
        }
        
        
        return answer;
    }
}