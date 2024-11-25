class Solution {
    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            // targets[0] 확인. "ASA"
            String target = targets[i];
            // 총 입력 횟수 
            int count = 0 ;

            for (int j = 0; j < target.length(); j++) {
                // target 의 각 문자를 돌면서,
                // keymap 의 문자열의 문자와 비교하는 방식.
                int keyCount =  checkKeymap(keymap, target.charAt(j));
                // 문자를 입력할 수 없는 경우에는 
                if (keyCount == -1){
                    // -1 을 저장
                    count = -1;
                    break;
                }
                count += keyCount;
                
            }
            answer[i] = count;
        }
        return answer;
    }

    // keymap 을 돌면서 개별 문자를 매개변수로 받아 일치하는지 확인하는 메서드.
    private static int checkKeymap (String[] keymap, char word) {
        int minCount = -1;

        // keymap의 첫번째 인덱스의 문자열에서부터 확인.
        for(String key : keymap) {
            // key에서 word 와 일치하는 문자의 위치를 찾았을 때.
            int index = key.indexOf(word);
            if (index != -1) {
                // 입력 횟수 넣기.
                int count = index + 1;

                // 최솟값 갱신하기.
                if (minCount == -1 || count < minCount) {
                    minCount = count;
                }

            }

        }
        return minCount;
    }
}
