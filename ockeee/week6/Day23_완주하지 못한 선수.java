class Solution {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        for(int i = 0 ; i < completion.length;i++){
            for(int j = 0 ; j < participant.length;j++){
                if(participant[j].equals(completion[i])){
                    participant[j] = "";
                    break;
                }
            }
        }
        for(int i = 0 ; i < participant.length;i++){
            if(participant[i].length()>0){
                answer = participant[i];
            }

        }
        return answer;
    }
}

// 테스트는 통과했지만 효율성에서 통과못함...
// 그래서 도움을 좀 받아서 푼 방식... 

import java.util.Arrays;
 
class Solution {
        public String solution(String[] participant, String[] completion) {
         // Arrays.sort()를 사용해 정렬
            Arrays.sort(participant);
            Arrays.sort(completion);
         // 반복문을 실행하여 participant와 completion 다른 값을 반환
            int i = 0;
            for(i = 0; i< completion.length; i++) {
                if (!participant[i].equals(completion[i]))
                    break;
            }
            return participant[i];
    }
}

