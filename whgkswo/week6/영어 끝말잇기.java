import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        // 이미 나왔던 단어들
        Set<String> preWords = new HashSet<>();
        
        int turn = 1; // 한 사이클 내의 차례
        int cycle = 1; // 사이클 몇 번 돌았는지 추적
        for(int i = 0; i< words.length; i++){
            // 중복 단어면 탈락
            if(preWords.contains(words[i])){
                return new int[]{turn,cycle};
            }
            if(i > 0){
                String lastWord = words[i - 1];
                // 마지막 글자에 이어서 말해야하는데
                char lastChar = lastWord.charAt(lastWord.length() - 1);
                // 이어지지 않으면 탈락
                if(lastChar != words[i].charAt(0)){
                    return new int[]{turn, cycle};
                }
            }
            // 유효한 단어이만
            // 마지막 단어 갱신
            preWords.add(words[i]);
            turn++;
            if(turn > n){
                turn = 1;
                cycle++;
            }
        }

        return new int[]{0,0};
    }
}
