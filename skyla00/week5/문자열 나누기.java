import java.util.ArrayList;

class Solution {
    public int solution(String s) {
        int firstChCount = 0;
        int leftChCount = 0;
        int startIndex = 0;
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            if (ch == firstCh) {
                firstChCount ++;
            } else {
                leftChCount ++;
            }


            if (firstChCount == leftChCount) {
                // 분리한 문자열 리스트에 넣기
                String diviceResult = s.substring(startIndex, i+1);
                result.add(diviceResult);

                // 카운트 초기화
                firstChCount = 0;
                leftChCount = 0;
              
                // 분리 후에 그 다음 인덱스로 startIndex와 firstCh 부여.
                startIndex = i + 1;
                if (startIndex < s.length()) {
                    firstCh = s.charAt(i + 1);
                }

            }
        }

        // 남아 있는 문자열
        if (startIndex < s.length()) {
            result.add(s.substring(startIndex));
        }

        return result.size();
    }
}
