import java.lang.Math;
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 수포자 1
        int [] first = new int[]{1,2,3,4,5};
        // 수포자 2
        int [] second = new int[]{2,1,2,3,2,4,2,5};
        // 수포자 3
        int [] third = new int[]{3,3,1,1,2,2,4,4,5,5};
        
        int[] scores = new int[3];
        // 3명의 답안지 순회, 맞았으면 정답 카운트 증가
        for(int i = 0; i< answers.length; i++){
            if(first[i % first.length] == answers[i]) scores[0] ++;
            if(second[i % second.length] == answers[i]) scores[1] ++;
            if(third[i % third.length] == answers[i]) scores[2] ++;
        }
        
        // 최고 점수 찾기
        int maxScore = 0;
        maxScore = Math.max(maxScore, scores[0]);
        maxScore = Math.max(maxScore, scores[1]);
        maxScore = Math.max(maxScore, scores[2]);
        // 응답 배열 구성(몇명이 될지 모르니까 일단 리스트로)
        List<Integer> answerList = new ArrayList<>();
        for(int i = 0; i< 3; i++){
            if(scores[i] == maxScore){
                answerList.add(i + 1);
            }
        }
        // 리스트를 배열로 변환
        int[] answer = new int[answerList.size()];
        for(int i = 0; i< answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
