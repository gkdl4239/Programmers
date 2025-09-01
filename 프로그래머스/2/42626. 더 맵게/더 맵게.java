import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int answer = 0;
        
        for(int num : scoville) {
            heap.add(num);
        }
        
        while(heap.peek() < K) {
            
            if(heap.size() < 2) return -1;
            int mixed;
            mixed = heap.poll() + heap.poll()*2;
            heap.add(mixed);
            answer++;
        }
        
        return answer;
    }
}