class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        String words[] = {"zero","one","two","three","four","five","six","seven","eight","nine",};
        
        for(int i =0; i<10; i++){
            int index;
            while((index = sb.indexOf(words[i])) != -1){
                sb.replace(index,index+words[i].length(), Integer.toString(i));
            }
        }
        
        return Integer.parseInt(sb.toString());
        
    }
}