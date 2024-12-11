import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        int total = 0;
        int zeroNum = 0;
        while(!Objects.equals(s, "1")) {
            StringBuilder sb = new StringBuilder(s);
            StringBuilder binary = new StringBuilder();


            int oneNum = 0;
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '1') {
                    oneNum++;
                }
            }

            zeroNum += sb.length() - oneNum;
            while (oneNum != 1) {
                binary.insert(0, oneNum % 2);
                oneNum /= 2;
            }
            s = 1 + binary.toString();
            total++;
        }
        answer[0] = total;
        answer[1] = zeroNum;
        return answer;
    }
}