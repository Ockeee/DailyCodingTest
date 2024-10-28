import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // 응답의 크기는 사진의 갯수여야 함
        int[] answer = new int[photo.length];
        
        // 각 사람의 점수를 담는 맵
        Map<String, Integer> scores = new HashMap<>();
        // 사람과 그리움 점수를 맵핑
        for(int i = 0; i< name.length; i++){
            scores.put(name[i], yearning[i]);
        }
        // 각 사진을 순회
        for(int i = 0; i< photo.length; i++){
            // 사진 안에 있는 사람들의 점수를 합산
            int score = 0;
            for(int j = 0; j< photo[i].length; j++){
                // photo[i][j] <<< 사진에 찍힌 한 명의 사람
                if(scores.containsKey(photo[i][j])) score += scores.get(photo[i][j]);
            }
            // 한 사진을 다 돌았으면 answer에 추가
            answer[i] = score;
        }
        return answer;
    }
}
