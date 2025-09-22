class Solution {
    public int solution(String[] board) {
        
        int[] dx = {1, 1, 0, -1};
        int[] dy = {0, 1, 1, -1};
        
        
        int count = 0,
            o = 0,
            x = 0;
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length(); j++) {
                
                for(int k=0; k<4; k++) {
                    int nx = i + dx[k],
                        ny = j + dy[k],
                        line = 0;
                    
                    while(board[i].charAt(j) != '.' && nx >= 0 && nx < board.length 
                          && ny >=0 && ny < board[0].length() && board[i].charAt(j) == board[nx].charAt(ny)) {
                        nx += dx[k];
                        ny += dy[k];
                        line++;
                    }
                    
                    if(line == 2) {
                        if(board[i].charAt(j) == 'O') o++;
                        else x++;
                    }
                }
                
                if(board[i].charAt(j) == 'O') count++;
                else if(board[i].charAt(j) == 'X') count--;
            }
        }
        
        if(o>0) {
            if(x>0) return 0;
            if(count == 0) return 0;
        }
        
        if(x>0) {
            if(count != 0) return 0;
        }
        
        if(count < 0) return 0;
        
        return 1;
        
        
        
        
    }
}