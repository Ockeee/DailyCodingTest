// 이익을 최대로 하기 위해선 비싼걸로 담아야 함
// score를 정렬을 하면 올림차순이기에 반복문을 통해서 m개 씩 담기는 상자 중 가장 작은 점수를 가진 사과에 접근하여 그 점수 * m

import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
      // 가장 높은 점수를 가진 사과를 m개씩 묶기 위해서 score.length - m 
        for(int i = score.length - m; i >= 0; i -= m)
            answer += score[i] * m;
        return answer;
    }
}
