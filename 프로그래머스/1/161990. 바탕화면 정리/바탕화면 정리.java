class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int lux=51;
        int luy=51;
        int rdx=-1;
        int rdy=-1;
        for(int i=0; i<wallpaper.length;i++){
            if(wallpaper[i].indexOf("#")!=-1){
                if(luy > i) luy = i;
                if(rdy < i) rdy = i;
            }
            for(int j=0; j<wallpaper[0].length(); j++){
                if(lux>wallpaper[i].indexOf("#")&&wallpaper[i].indexOf("#")!=-1){
                    lux = wallpaper[i].indexOf("#");
                }
                if(wallpaper[i].charAt(j)=='#'&&rdx<j){
                    rdx = j;
                }
            }
        }
        
        answer[0] = luy;
        answer[1] = lux;
        answer[2] = rdy+1;
        answer[3] = rdx+1;
        return answer;
    }
}