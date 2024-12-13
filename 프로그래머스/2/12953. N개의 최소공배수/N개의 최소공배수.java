class Solution {
    public int solution(int[] arr) {
        int first = arr[0];
        
        for(int i=1; i<arr.length; i++){
            int small = Math.min(first,arr[i]);
            for(int j=small; j>0; j--) {
                if(first%j == 0 && arr[i]%j ==0) {
                    first = first*arr[i]/j;
                    break;
                }
            }
        }
        
        return first;
    }
}