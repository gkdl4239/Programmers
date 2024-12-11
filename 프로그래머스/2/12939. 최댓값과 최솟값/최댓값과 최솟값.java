class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        String[] ss = s.split(" ");

        int min = Integer.parseInt(ss[0]);
        int max = min;
        for(String snum : ss){
            int num = Integer.parseInt(snum);
            if(min > num) min = num;
            if(max < num) max = num;
        }
        sb.append(min);
        sb.append(" ");
        sb.append(max);

        return sb.toString();
    }
}