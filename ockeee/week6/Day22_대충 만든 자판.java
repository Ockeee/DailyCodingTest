class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        // targets 배열 순회
        for (int i = 0; i < targets.length; i++) {
            for (int j = 0; j < targets[i].length(); j++) {
                int idx = 101; // Keymap이 100이므로 100보다 큰 101로 설정
                
                // keymap을 순회하며 현재 문자 확인
                for (int k = 0; k < keymap.length; k++) {
                    // keymap[k]에서 현재 문자(targets[i].charAt(j))의 인덱스 찾기
                    int index = keymap[k].indexOf(targets[i].charAt(j));
                    
                    // 문자가 keymap[k]에 있다면
                    if (index != -1) {
                        // 현재 최소 입력 횟수(idx)보다 작은 경우 업데이트
                        if (idx > index) {
                            idx = index;
                        }
                    }
                }
                
                // keymap에서 문자를 찾을 수 없으면 -1을 기록하고 중단합니다.
                if (idx == 101) {
                    answer[i] = -1;
                    break;
                } else {
                    // 최소 입력 횟수를 더하기 (index는 0부터 시작하므로 +1 필요)
                    answer[i] += idx + 1;
                }        		        		
            }
        }
        return answer;
    }
}
