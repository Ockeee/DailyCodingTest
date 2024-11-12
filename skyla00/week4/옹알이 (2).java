class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String [] word = {"aya", "ye", "woo", "ma"};
        for (int i = 0; i < babbling.length; i ++ ) {
            for (int j = 0; j < 4; j ++) {
                if(babbling[i].contains(word[j])) {
                    // 같은 발음이 연속되는 걸 막아야 함. 
                    if(babbling[i].contains(word[j]+word[j])) {
                        break;
                    }
                    babbling[i] = babbling[i].replace(word[j], "*");
                    
                    if (babbling[i].replace("*", "").isEmpty()) {
                        answer ++;
                    }
                }
            }
        }
        return answer;
    }
}
