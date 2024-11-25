class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        // 각각의 타겟에 대해
        for(int k = 0; k< targets.length; k++){
            // 한 글자씩 순회
            for(int j = 0; j< targets[k].length(); j++){
                // 타겟 글자 정하기
                char c = targets[k].charAt(j);
                // 타겟 글자가 최소 몇 번을 눌러야 입력 가능한지 담는 변수 (초기값 21억)
                int minCount = Integer.MAX_VALUE;
                // 모든 키맵을 순회
                for(int i = 0; i< keymap.length; i++){
                    // 각각의 키맵에 대해 타겟 글자에 해당하는 인덱스
                    int index = keymap[i].indexOf(c);
                    // 인덱스 중 최솟값을 구하기 (0번 인덱스이면 키를 1번 눌러야 하니까 + 1 해서 계산)
                    if(index >= 0) minCount = Math.min(minCount, index + 1);
                }
                // 최솟값을 answer[k]에 합산 (나머지 문자들 것까지 더해서 결정)
                if(minCount == Integer.MAX_VALUE) {
                    // minCount가 아직도 21억이라는 건 입력 불가능한 문자가 나왔다는 뜻
                    answer[k] = -1; // 이 경우 전체 문자열은 입력 불가능한 문자열이 됨
                    break;
                }else{
                    System.out.println(minCount);
                    answer[k] += minCount;
                }
            }
        }
        // 정답 배열에서 0은 -1로 교체
        for(int i = 0; i< answer.length; i++){
            if(answer[i] == 0) answer[i] = -1;
        }
        return answer;
    }
}
