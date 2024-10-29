class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {        
        int index1 = 0; // 1번 뭉치 인덱스
        int index2 = 0; // 2번 뭉치 인덱스
        
        // i << goal의 인덱스
        for(int i = 0; i< goal.length; i++){
            // 해당 단어가 1번 뭉치에서 발견될 경우
            if(index1 < cards1.length && cards1[index1].equals(goal[i])){
                index1++; // 1번 뭉치 인덱스를 증가시킨 뒤 넘기기
                continue;
            }
            // 해당 단어가 2번 뭉치에서 발견될 경우
            if(index2 < cards2.length && cards2[index2].equals(goal[i])){
                index2++; // 2번 뭉치 인덱스를 증가시킨 뒤 넘기기
                continue;
            }
            // 1,2번 뭉치의 현재 인덱스에서 일치하는 단어가 없으면 문장 완성 불가능
            return "No";
        }
        return "Yes";
    }
}
