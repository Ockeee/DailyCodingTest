// 테스트 케이스만 통과. 
import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";

        HashMap<Integer, Integer> standard = new HashMap<>();
        for (int i = 0; i < X.length(); i ++) {
            // x를 돌면서 char 를 뽑아서
            char x = X.charAt(i);
            int xNum = Integer.parseInt(String.valueOf(x));
            // Map 에다가 부여.
            standard.put(xNum, standard.getOrDefault(xNum,0) + 1);

        }


        // Y를 돌면서 standard Map 과 같은지 확인.
        // 같은 게 있으면 새로운 배열에 넣어줌.
        ArrayList<Integer> sameNum = new ArrayList<>();

        for (int i = 0; i < Y.length(); i ++) {
            char y = Y.charAt(i);
            int yNum = Integer.parseInt(String.valueOf(y));

            if(standard.containsKey(yNum)){
                sameNum.add(yNum);
            }
        }
        // 내림차순으로 sort 하기
        Collections.sort(sameNum, Collections.reverseOrder());
        if(sameNum.isEmpty()) return "-1";

        // 0 만 있다면, "0" 반환.
        boolean allZero = true;
        for (int value : sameNum) {
            if (value != 0) {
                allZero = false;
                break;
            }
        }
        if(allZero) return "0";

        // char 를 String 으로 바꿈.
        StringBuilder resultNum = new StringBuilder();
        for (Integer num : sameNum) {
            resultNum.append(num);
        }
        answer = resultNum.toString();
        return answer;

    }
}

