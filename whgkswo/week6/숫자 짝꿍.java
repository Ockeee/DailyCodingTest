import java.util.*;

class Solution {
    public String solution(String X, String Y) {     
        // y를 맵에 넣기
        Map<Character, Integer> map = new HashMap<>();
        // 각 자릿수 순회
        for(int i = 0; i< Y.length(); i++){
            char c = Y.charAt(i);
            if(map.containsKey(c)){ // 키가 이미 있으면 카운트 +1
                map.put(c, map.get(c) + 1);
            }else{ // 키 없으면 새로 등록
                map.put(c, 1);
            }
        }
        // 양쪽에 공통으로 있는 숫자들을 담을 맵
        Map<Integer, Integer> duplicates = new HashMap<>();
        // X를 순회
        for(int i = 0; i< X.length(); i++){
            char c = X.charAt(i);
            int intC = Integer.parseInt(c + "");
            // y 맵에 있는지 보기
            if(map.containsKey(c)){
                // 중복 숫자 추가
                if(duplicates.containsKey(intC)){ // 키가 있으면
                    duplicates.put(intC, duplicates.get(intC) + 1); // 중복 카운트 1 증가
                }else{ // 키가 없으면
                    duplicates.put(intC, 1); // 중복 숫자 새로 등록
                }
                // y 맵에서 제거
                if(map.get(c) > 1){ // 카운트 2 이상이면
                    map.put(c, map.get(c) - 1); // 카운트 1 빼기
                }else{ // 카운트가 1이면
                    map.remove(c); // 키 없애기
                }
            }
        }
        // 중복 숫자가 없으면
        if(duplicates.isEmpty()) return "-1";
        // 중복 숫자가 0밖에 없으면
        if(duplicates.keySet().size() == 1 && duplicates.keySet().contains(0)) return "0";
        // 키셋을 내림차순으로 정렬하기 위해 리스트로 옮겨 담기
        List<Integer> keys = new ArrayList<>();
        for(Integer key : duplicates.keySet()){
            keys.add(key);
        }
        // 리스트 내림차순 정렬
        Collections.sort(keys, Collections.reverseOrder());
        // 정렬된 리스트를 순회하면서 수 만들기
        String answer = "";
        for(int i = 0; i< keys.size(); i++){
            // 타깃 중복 숫자
            int num = keys.get(i); 
            answer += (num + "").repeat(duplicates.get(num)); // 중복된 갯수만큼 반복
        }
        return answer;
    }
}
