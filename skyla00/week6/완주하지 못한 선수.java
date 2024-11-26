// 효율성 테스트 실패
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        for (int i = 0; i < participant.length; i ++) {
            for (int j = 0; j < completion.length; j++) {
                if(participant[i].equals(completion[j])) {
                    participant[i] = participant[i].replace(participant[i],"*");
                    completion[j] = completion[j].replace(completion[j], "*");
                }
            }
        }
        for (int k = 0; k <participant.length; k++) {
            if(!participant[k].equals("*")) {
                answer = participant[k];
            }
        }

        return answer;
    
    }
}
