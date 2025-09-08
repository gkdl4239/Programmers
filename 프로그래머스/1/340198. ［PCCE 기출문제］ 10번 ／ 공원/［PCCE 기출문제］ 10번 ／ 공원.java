import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        
        int max = checkSize(park);
        
        Arrays.sort(mats);
        
        for(int i=mats.length-1; i >=0; i-- ) {
            if(max >= mats[i]) {
                answer = mats[i];
                return answer;
            }
        }
        
        return -1;
    }
    
    private int checkSize(String[][] park) {
        int max = 0;
        
        for(int i=0; i<park.length; i++) {
            for(int j=0; j<park[0].length; j++) {
                
                if(!park[i][j].equals("-1")) continue;
                
                int l = 1;
                        
                while(i+l <= park.length && j+l <= park[0].length) {
                    
                    boolean valid = true;
                    
                    for(int a=i; a<i+l; a++) {
                        for(int b=j; b<j+l; b++) {
                            if(!park[a][b].equals("-1")) {
                                valid = false;
                                break;
                            }
                        }
                        if(!valid) break;
                    }
                    if(valid) {
                        max = Math.max(max, l);
                        l++;
                    }
                    else {
                        break;
                    }
                }
            }
        }
        
        
        return max;
    }
}