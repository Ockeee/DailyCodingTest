import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] fistRoutine = {1,2,3,4,5};
        int[] secondRoutine = {2,1,2,3,2,4,2,5};
        int[] thirdRoutine = {3,3,1,1,2,2,4,4,5,5};
        // 점수를 받는 배열 [1번 점수, 2번 점수, 3번 점수]
        int[] scores = new int[3];

        // 학생들의 루틴 배열 과 정답의 배열을 비교해서 맟줬으면 점수 + 1

        for (int i = 0; i < answers.length; i++) {
            // 1번 학생의 점수
            if (fistRoutine[i%5] == answers[i]) scores[0] += 1;
            if (secondRoutine[i%8] == answers[i]) scores[1] += 1;
            if (thirdRoutine[i%10] == answers[i]) scores[2] += 1;
        }

        // 그 각각의 숫자를 봐서 가장 높은 점수를 확인.
        int maxScore = Arrays.stream(scores).max().getAsInt();

      
        // 정답을 맞힌 학생 수가 몇 명일지 모르니 list 로 저장한 후 배열로 변환
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < 3 ; i ++) {
            if (scores[i] == maxScore) {
                resultList.add(i+1);
            }
        }
        // List 를 배열로 바꿔줌
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
