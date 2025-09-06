class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int len = toTime(video_len);
        int now = toTime(pos);
        int opS = toTime(op_start);
        int opE = toTime(op_end);
        
        for(int i=0; i<commands.length; i++) {
            
            if(now >= opS && now < opE) now = opE;
            
            if(commands[i].equals("next")) now += 10;
            if(commands[i].equals("prev")) now -= 10;
            
            if(now < 0) now = 0;
            if(now > len) now = len;
        }
        
        if(now >= opS && now < opE) now = opE;
        
        String min = now / 60 < 10 ? "0" + now / 60 : "" + now / 60;
        String sec = now % 60 < 10 ? "0" + now % 60 : "" + now % 60;
        return min + ":" + sec;
    }
    
    private int toTime(String time) {
        int min = Integer.parseInt(time.substring(0,2));
        int sec = Integer.parseInt(time.substring(3));
        
        return min * 60 + sec;
    }
}