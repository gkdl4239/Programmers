import java.util.List;
import java.util.ArrayList;
class Solution {
    public boolean solution(int x) {
        int sum = String.valueOf(x).chars().map(a -> a-'0').sum();
        return x%sum==0;
    }
}