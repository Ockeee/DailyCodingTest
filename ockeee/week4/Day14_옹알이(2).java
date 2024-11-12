class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        // 가능한 발음들 배열
        String[] possible = {"aya", "ye", "woo", "ma"};
        // 불가능한 연속된 발음들 배열
        String[] impossible = {"ayaaya", "yeye", "woowoo", "mama"};

        // 각 문자열을 하나씩 확인
        for (String word : babbling) {
            boolean isValid = true;
            
          // 연속된 발음들은 false
            for (String noSound : impossible) {
                if (word.contains(noSound)) {
                    isValid = false;
                    break;
                }
            }

            // 유효하지 않으면 다음 단어로 넘어감
            if (!isValid) {
                continue;
            }

            // 가능한 발음들로 대체
            for (String sound : possible) {
                word = word.replace(sound, "O");
            }

            // 변환된 단어가 "O"로만 이루어져 있는지 확인
            boolean allValid = true;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != 'O') {
                    allValid = false;
                    break;
                }
            }

            // "O"로만 이루어졌다면 발음 가능한 단어로 간주하고 카운트 증가
            if (allValid) {
                answer++;
            }
        }

        return answer;
    }
}
