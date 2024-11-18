import java.util.*;

class Solution {
    public int solution(String dartResult) {
        // 점수들을 담는 스택
        Stack<Integer> scores = new Stack<>();
        
        // 문자열 순회
        for(int i = 0; i< dartResult.length(); i++){
            // 개별 문자가
            char c = dartResult.charAt(i);
            System.out.println(String.format("%d: %s", i, c));
            // 숫자면
            if(Character.isDigit(c)){
                // 10인 경우 처리
                if(dartResult.charAt(i + 1) == '0'){
                    scores.push(10);
                    i++; // 다음 0 건너뛰기
                    continue;
                }
                // 1 ~ 9면
                scores.push(Integer.parseInt(c + "")); // 스택에 점수 추가
                continue;
            }
            // 알파벳이면
            if(Character.isAlphabetic(c)){
                // 뺐다가 점수 곱해서 다시 넣기
                int lastScore = scores.pop();
                scores.push((int) Math.pow(lastScore, getBonusRate(c)));
                continue;
            }
            // 스타상
            if(c == '*'){; 
                // 마지막 점수
                int lastScore = scores.pop();
                lastScore *= 2;
                // 마지막 전 점수
                if(!scores.isEmpty()){ // 있을 때만
                    int lastPrevScore = scores.pop();
                    lastPrevScore *= 2;
                    scores.push(lastPrevScore);
                }                
                // 다시 넣기             
                scores.push(lastScore);
                continue;
            }
            // 아차상
            if(c == '#'){
                // 마지막 점수
                int lastScore = scores.pop();
                lastScore *= -1;
                scores.push(lastScore);
            }
        }
        // 총점수 계산
        int answer = 0;
        for(int score : scores){
            System.out.println(score + "점");
            answer += score;
        }
        return answer;
    }
    
    // 보너스 지수 계산하는 메서드
    public static int getBonusRate(char c){
        switch(c){
            case 'S':
                return 1;
            case 'D':
                return 2;
            case 'T':
                return 3;
        }     
        return 0;
    }
}
