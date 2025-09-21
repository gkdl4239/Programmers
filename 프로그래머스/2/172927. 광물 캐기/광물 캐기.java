import java.util.*;
class Solution {
    
    static int min;
    
    static void mining(int[] picks, int[] minerals, int tire) {
        
        if(picks[0]+picks[1]+picks[2] == 0 || minerals.length == 0) {
            min = Math.min(min, tire);
            return;
        }
        
        for(int i=0; i<3; i++) {
            if(picks[i] > 0) {
                picks[i]--;
                int curTire = tire;
                
                int count = Math.min(5, minerals.length);
                for(int j=0; j<count; j++) {
                    
                    if(minerals[j] - (3-i) < 1) curTire++;
                    else {
                        curTire += Math.pow(5, minerals[j] - (3-i));
                    }
                }
                int[] remain = count < 5 ? new int[0] : Arrays.copyOfRange(minerals, 5, minerals.length);
                mining(picks, remain, curTire);
                picks[i]++;
            }
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        
        int[] mineralsN = new int[minerals.length];
        min = Integer.MAX_VALUE;
        
        
        for(int i=0; i<minerals.length; i++) {
            if(minerals[i].equals("diamond")) mineralsN[i] = 3;
            else if(minerals[i].equals("iron")) mineralsN[i] = 2;
            else mineralsN[i] = 1;
        }
        
        int maxMinerals = Math.min(minerals.length, (picks[0]+picks[1]+picks[2])*5);
        int[] targets = Arrays.copyOfRange(mineralsN, 0, maxMinerals);
        
        mining(picks, targets, 0);
        
        return min;
    }
}