class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        // 0번은 물이니까 1번부터 순회
        for (int i = 1; i< food.length; i++){
            // 음식 개수가 2 이상이어야 함
            if(food[i] >= 2){
                // 좌우로 배치해야 하니까 2로 나누기, 이 과정에서 홀수일 경우 나머지 1은 버려짐
                answer += (i + "").repeat(food[i] / 2);
            }
        }
        // 중간에 물 놓기
        answer += "0";
        // 두 번째 참가자가 먹을 음식 놓기(반대로 순회)
        for(int i = food.length - 1; i>= 1; i--){
            answer += (i + "").repeat(food[i] / 2);
        }
        return answer;
    }
}
