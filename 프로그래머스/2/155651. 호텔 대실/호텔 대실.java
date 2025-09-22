import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        
        Arrays.sort(book_time, Comparator.comparing(a -> a[0]));
        PriorityQueue<int[]> rooms = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        int needed = 0;
        
        for(int i=0; i<book_time.length; i++) {
            
            int curStart = Integer.parseInt(book_time[i][0].substring(0,2)) * 60 +
                            Integer.parseInt(book_time[i][0].substring(3));
            int curEnd = Integer.parseInt(book_time[i][1].substring(0,2)) * 60 +
                            Integer.parseInt(book_time[i][1].substring(3)) + 10;
            
            while(!rooms.isEmpty()) {
                int[] prev = rooms.poll();
                
                if(prev[1] > curStart) {
                    rooms.add(prev);
                    break;
                }
            }
            
            rooms.add(new int[]{curStart, curEnd});
            needed = Math.max(needed, rooms.size());
        }
        
        return needed;
    }
}