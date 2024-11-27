import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int count = 0;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        List<Integer> Lost = new ArrayList<>();
        List<Integer> Reserve = new ArrayList<>();
        
        for(int i=0; i<lost.length; i++){
            Lost.add(lost[i]);
        }
        
        for(int j=0; j<reserve.length; j++){
            Reserve.add(reserve[j]);
        }
        
        
        
        
        
        for(int k : reserve){
            for(int m : lost){
                if( k==m){
                    Reserve.remove(Integer.valueOf(k));
                    Lost.remove(Integer.valueOf(k));
                    
                }
            }
        }
        
        List<Integer> newReserve = new ArrayList<>(Reserve);
        List<Integer> newLost = new ArrayList<>(Lost);
        
        for(int m : newLost){
            for(int k : Reserve){
                if(k-1 ==m){
                    Reserve.remove(Integer.valueOf(k));
                    Lost.remove(Integer.valueOf(m));
                    break;
                }
                else if(k+1 ==m){
                    Reserve.remove(Integer.valueOf(k));
                    Lost.remove(Integer.valueOf(m));
                    break;
                }
            }
        }
        
        return n-Lost.size();
    }
}