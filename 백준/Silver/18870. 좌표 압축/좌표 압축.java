import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 출력도 StringBuilder를 사용해서 한 번에 쓰는 방식으로 최적화
        StringBuilder sb = new StringBuilder(); 
        
        int n = Integer.parseInt(reader.readLine());
        
        long[] arr = new long[n]; // 원본 배열
        long[] sortedArr = new long[n]; // 정렬용 배열
        
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for(int i=0; i<n; i++) {
            long val = Long.parseLong(st.nextToken());
            arr[i] = val;       // 원본 배열 채우기
            sortedArr[i] = val; // 정렬할 배열 채우기
        }
        
        Arrays.sort(sortedArr); // 정렬

        // Map<Long, Long> -> Map<Long, Integer>로 변경
        Map<Long, Integer> map = new HashMap<>(); 
        
        int order = 0; // 0부터 시작하는 압축 좌표
        
        for(int i=0; i<n; i++) {
            // map에 없는 값만 새로운 order 부여 (중복 제거)
            if(!map.containsKey(sortedArr[i])) {
                map.put(sortedArr[i], order++);
            }
        }
        
        // 원본 배열을 순회하면서 압축된 좌표를 찾아 StringBuilder에 추가
        for(int i=0; i<n; i++) {
            sb.append(map.get(arr[i]));
            if(i < n-1) { // 마지막 원소 뒤에는 공백 추가 안 함
                sb.append(" ");
            }
        }
        
        // 최종 결과 한 번에 출력
        System.out.println(sb.toString());
    }
}