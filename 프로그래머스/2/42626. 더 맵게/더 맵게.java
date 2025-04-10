import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        
        int answer = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for(int index : scoville) {
            heap.add(index);
        }
        
        while(heap.peek() < K && heap.size() > 1) {
            int mixed = heap.poll() + heap.poll()*2;
            heap.add(mixed);
            answer++;
        }
        
        if(heap.peek() < K && heap.size() == 1) answer = -1;
        
        return answer;
    }
}