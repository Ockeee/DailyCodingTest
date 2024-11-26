import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // 완주자 명단 맵에 담기 (키: 이름, 밸류: 카운트)
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i< completion.length; i++){
            if(map.containsKey(completion[i])){ // 키가 있으면
                map.put(completion[i], map.get(completion[i]) + 1); // 카운트 1 증가
            }else{ // 키 없으면
                map.put(completion[i], 1); // 키 새로 등록
            }
        }
        // 참가자 명단 순회
        for(int i = 0; i< participant.length; i++){
            // 맵에 있으면 통과, 맵에서 삭제
            if(map.containsKey(participant[i])){
                if(map.get(participant[i]) > 1){ // 2 이상 남았으면
                    map.put(participant[i], map.get(participant[i]) - 1); // 1 빼기
                }else{ // 딱 하나만 남았으면
                    map.remove(participant[i]); // 키를 지우기
                }
            }else{
                // 맵에 없으면 얘가 완주 못한놈
                return participant[i];
            }
        }
        return answer;
    }
}
