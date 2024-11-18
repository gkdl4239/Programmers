class Solution {
    public boolean solution(String s) {
        try{
            int e = Integer.parseInt(s);
            if(s.length()==4 ||s.length()==6){
                return true;
            }else return false;
        }
        catch(NumberFormatException e){
            return false;
        }
        
    }
}