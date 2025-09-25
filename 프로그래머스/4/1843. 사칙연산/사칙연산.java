class Solution {
    public int solution(String arr[]) {
        
        int n = arr.length / 2 + 1;
        
        int[][] dpMax = new int [n][n],
                dpMin = new int [n][n];
        
        for(int i=0; i<n; i++) {
            dpMax[i][i] = Integer.parseInt(arr[i*2]);
            dpMin[i][i] = Integer.parseInt(arr[i*2]);
        }
        
        for(int len=1; len<n; len++) {
            for(int i=0; i<n-len; i++) {
                int j = i+len;
                dpMax[i][j] = Integer.MIN_VALUE;
                dpMin[i][j] = Integer.MAX_VALUE;
                
                for(int k=i; k<j; k++) {
                    String op = arr[k*2+1];
                    int maxLeft = dpMax[i][k];
                    int minLeft = dpMin[i][k];
                    int maxRight = dpMax[k+1][j];
                    int minRight = dpMin[k+1][j];
                    
                    if(op.equals("+")) {
                        dpMax[i][j] = Math.max(dpMax[i][j], maxLeft+maxRight);
                        dpMin[i][j] = Math.min(dpMin[i][j], minLeft+minRight);
                    } else {
                        dpMax[i][j] = Math.max(dpMax[i][j], maxLeft-minRight);
                        dpMin[i][j] = Math.min(dpMin[i][j], minLeft-maxRight);
                    }
                }
            }
        }
        
        return dpMax[0][n-1];
    }
}