class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        
        int[] result = new int[balls.length];
        
        for(int i=0; i<balls.length; i++) {
            
            int targetX = balls[i][0];
            int targetY = balls[i][1];
            
            int minDistance = Integer.MAX_VALUE;
            int distance = 0;
            
            if(startX != targetX || startY > targetY) {
                distance = (targetX - startX) * (targetX - startX) +
                            (2 * n - (startY + targetY)) * (2 * n - (startY + targetY));
                minDistance = Math.min(distance, minDistance);
            }
            
            if(startX != targetX || startY < targetY) {
                distance = (targetX - startX) * (targetX - startX) +
                            (startY + targetY) * (startY + targetY);
                minDistance = Math.min(distance, minDistance);
            }
            
            if(startY != targetY || startX < targetX) {
                distance = (targetY - startY) * (targetY - startY) +
                            (startX + targetX) * (startX + targetX);
                minDistance = Math.min(distance, minDistance);
            }
            
            if(startY != targetY || startX > targetX) {
                distance = (targetY - startY) * (targetY - startY) +
                            (2 * m - (startX + targetX)) * (2 * m - (startX + targetX));
                minDistance = Math.min(distance, minDistance);
            }
            
            result[i] = minDistance;
        }
        
        return result;
        
    }
}