class Solution {
    public int[] solution(String[] park, String[] routes) {


        int[] start = new int[2];
        int[] end = new int[2];

        for(int i=0; i<park.length; i++){
            if(park[i].indexOf("S")>=0){
                start[0] = i;
                start[1] = park[i].indexOf("S");
                break;
            }
        }

        for(String route : routes){
            char direction = route.charAt(0);
            int distance = route.charAt(2)-'0';

            end = checkAndMove(start,park,direction,distance);
            start = end;

        }

        return end;
    }


    public int[] checkAndMove(int[] location,String[] park, char direction,int distance){
        int[] newlocation = location.clone();
        for(int i=0; i<distance; i++) {
            switch (direction) {
                case 'E':
                    newlocation[1] += 1;
                    break;

                case 'W':
                    newlocation[1] -= 1;
                    break;

                case 'N':
                    newlocation[0] -= 1;
                    break;

                case 'S':
                    newlocation[0] += 1;
                    break;

                default:
                    return new int[]{-1, -1};
            }

            if (!checkAbleToGo(newlocation, park)) {
                return location;
            }
        }
        return newlocation;
    }

    public boolean checkAbleToGo(int[] goal, String[] park){

        if(goal[0]>=park.length || goal[0]<0){
            return false;
        }
        if(goal[1]>=park[0].length() || goal[1]<0){
            return false;
        }
        if(park[goal[0]].charAt(goal[1])=='X'){
            return false;
        }
        return true;
    }
}