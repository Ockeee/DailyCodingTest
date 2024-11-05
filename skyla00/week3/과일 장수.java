import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {

        // 점수 내림차순으로 정렬
        Integer[] scoreInt = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(scoreInt, Collections.reverseOrder());

        int answer = 0;

        // 상자 m 만큼 묶..을 필요도 없이 그냥 최저 점수만 가지고 와서 계산해도 됨
        for( int i = 0; i < scoreInt.length; i += m ){
            // 만약 m이 3이면 각 상자의 최저 점수는
            // idx 2, 5, 8... 에 있음.
            // 배열의 크기가 초과하지 않을 때까지
            if (i + m <= scoreInt.length) {
                // 각 상자의 최저 점수
                int minScore = scoreInt[i + m - 1];
                // 가격은 최저점수 * 과일 갯수
                int price = minScore * m;
                // 가격의 총 합
                answer += price;
            }
        }
        return answer;
    }
}
