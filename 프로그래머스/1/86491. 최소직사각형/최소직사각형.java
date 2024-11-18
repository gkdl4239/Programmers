class Solution {
    public int solution(int[][] sizes) {
        int tmp = 0;
        int min1 = 0;
        int min2 = 0;
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0]>sizes[i][1]){
                tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }
        for(int j=0; j<sizes.length; j++){
            min1 = sizes[j][0]>min1 ? sizes[j][0] : min1;
            min2 = sizes[j][1]>min2 ? sizes[j][1] : min2;
        }
        System.out.print(min1+" "+min2);
        return min1*min2;
    }
}