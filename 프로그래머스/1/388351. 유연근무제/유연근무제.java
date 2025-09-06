import java.util.*;
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        int n = schedules.length;
        boolean[] winners = new boolean[n];
        Arrays.fill(winners, true);
        
        for(int i=0; i<schedules.length; i++) {
            schedules[i] = schedules[i] / 100 * 60 + schedules[i] % 100;
        }
        
        for(int i=0; i<timelogs.length; i++) {
            for(int j=0; j<timelogs[0].length; j++) {
                timelogs[i][j] = timelogs[i][j] / 100 * 60 + timelogs[i][j] % 100;
            }
        }
        
        for(int worker=0; worker<n; worker++) {
            for(int days=0; days<7; days++) {
                int today = startday + days;
                
                if(today > 7) today -= 7;
                if(today == 6 || today == 7) continue;
                if(timelogs[worker][days] > schedules[worker] + 10) {
                    winners[worker] = false;
                    break;
                }
            }
        }
        
        for(boolean onTime : winners) {
            if(onTime) answer++;
        }
        
        
        return answer;
    }
}