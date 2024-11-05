import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        // 사과 가격순 오름차순 정렬(원시타입은 오름차순만 가능)
        Arrays.sort(score);

        // 뒤부터 순회하며 m개씩 상자에 담기
        int ref = score.length - 1;
        while(ref >= m - 1){
            // 새로운 상자
            int[] box = new int[m];
            for(int i = 0; i< m; i++){ 
                box[i] = score[ref - i];
            }
            // 상자의 가격 누적 합산
            answer += box[m - 1] * m; // 상자별 최하품 사과 * m
            ref -= m; // 다음 상자로 이동
        }
        return answer;
    }
}
