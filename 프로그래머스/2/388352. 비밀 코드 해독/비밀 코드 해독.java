class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        
        for(int a=1; a<n-3; a++) {
            for(int b=a+1; b<n-2; b++) {
                for(int c=b+1; c<n-1; c++) {
                    for(int d=c+1; d<n; d++) {
                        for(int e=d+1; e<n+1; e++) {
                            
                            int[] input = new int[]{a, b, c, d, e};
                            
                            if(solve(input, q, ans)) answer++;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
    
    private boolean solve(int[] input, int[][] q, int[] ans) {
        
        for(int i=0; i<q.length; i++) {
            int res = 0;
            
            
            for(int num : input) {
                int j=0;
                while(j<5) {
                    if(num == q[i][j]) {
                        j++;
                        res++;
                        break;
                    }
                    j++;    
                }
            }
            
            if(res != ans[i]) return false;
        }
        
        return true;
    }
    
}