import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        // name[i] 의 yearing 점수는 yearning[i]
        HashMap<String, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i < name.length; i ++) {
            scoreMap.put(name[i], yearning[i]);
        }


        // for 문을 돌면서 photo[0][0] 부터 보면서 name[0]이랑 같은지 아닌지 확인
        for (int i = 0; i < photo.length; i ++) {
            int totalScore = 0;
            // photo[i][0] - photo[i][j]까지 순회하며 socre의 key 값과 같은 
            // name이 있는지 확인
            for (int j = 0; j <photo[i].length; j++) {
                // 같은 name 이 있으면 그 key의 value 값을 더해서 answer 에 추가.
                if (scoreMap.containsKey(photo[i][j])) {
                    totalScore += scoreMap.get(photo[i][j]);
                }
            }
            answer[i] = totalScore;
        }

        return answer;
    }
}
