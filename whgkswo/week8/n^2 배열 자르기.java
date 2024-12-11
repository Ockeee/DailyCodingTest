import java.util.*;
import java.lang.Math;

class Solution {
    public int[] solution(int n, long left, long right) {
        
        int gap = (int)(right - left) + 1;  // 정답 배열의 길이
        int[] answer = new int[gap];
        
        // 정답 배열 순회
        for(int i = 1; i<= gap; i++){
            long index = i + left;
            // 숫자 하나씩 넣기
            answer[i - 1] = getValue(index, n);
        }
        return answer;
    }
    
    // 일자로 펼친 배열의 num 번째 값을 구하기
    public static int getValue(long num, int sideLength){
        // 행 번호 구하기
        long row = (num - 1) / sideLength + 1;
        
        // 열 번호 구하기
        long column = (num - 1) % sideLength + 1;
        
        // 배열의 구조가 (0,0)에서 퍼져나가며 증가하는 모양이므로
        // 행과 열 중 더 큰 쪽의 번호만큼 퍼져나가며 증가한 것으로 해석
        return (int) Math.max(row, column);
    }
}
