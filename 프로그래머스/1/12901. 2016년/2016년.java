import java.util.*;
class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        Map<Integer,Integer> date = new HashMap<>();
        Map<Integer,String> week = new HashMap<>();
        
        date.put(1,31);
        date.put(2,29);
        date.put(3,31);
        date.put(4,30);
        date.put(5,31);
        date.put(6,30);
        date.put(7,31);
        date.put(8,31);
        date.put(9,30);
        date.put(10,31);
        date.put(11,30);
        date.put(12,31);
        
        week.put(0,"THU");
        week.put(1,"FRI");
        week.put(2,"SAT");
        week.put(3,"SUN");
        week.put(4,"MON");
        week.put(5,"TUE");
        week.put(6,"WED");
        
        for(int i=1; i<a; i++){
            b+= date.get(i);
        }
        b %= 7;
        answer = week.get(b);
        return answer;
    }
}