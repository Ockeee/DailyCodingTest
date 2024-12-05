import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
      
        // 합계를 저장할 집합(Set)을 먼저 생성
        Set<Integer> sumSet = new HashSet<>();

        int length = elements.length;

        // 길이가 1부터 배열 전체 길이까지의 모든 부분 수열을 계산.
        for (int size = 1; size <= length; size++) {
            // 각 부분 수열의 합을 계산.
            for (int start = 0; start < length; start++) {
                int sum = 0;

                // 부분 수열의 합 구하기.
                for (int i = 0; i < size; i++) {
                    sum += elements[(start + i) % length]; // 원형 배열을 처리하기 위해서.
                }

                // 계산한 합을 집합(Set)에 추가.
                sumSet.add(sum);
            }
        }

        // 집합(Set)의 크기 = 합의 개수.
        answer = sumSet.size();
        return answer;
    }
}
