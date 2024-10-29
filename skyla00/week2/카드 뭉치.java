class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        // cards1 과 cards2 의 인덱스
        int cards1_idx = 0;
        int cards2_idx = 0;
        
        // goal 의 인덱스를 돌면서 문자열 확인 
        for(int i = 0; i < goal.length; i ++) {
            // cards1 에 goal 과 같은 단어가 있으면
            if (cards1_idx < cards1.length && cards1[cards1_idx].equals(goal[i])) {
                // idx 증가시킴,
                cards1_idx ++;
            // 없다면 cards2 에 goal 과 같은 단어가 있는지 확인 
            } else if (cards2_idx < cards2.length && cards2[cards2_idx].equals(goal[i])) {
                // 있다면 idx 증가시킴. 
                cards2_idx ++;
            } else {
                //cards1 과 cards2 둘 다에 없다면 No 반환. 
                answer = "No";
            }
        }
        
        return answer;
    }
}
