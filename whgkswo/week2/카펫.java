import java.lang.Math;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // i는 노란색의 후보 줄 수
        for(int i = 1; i<= yellow; i++){
            // 노란색이 몇 줄인지 확인
            if(yellow % i == 0){ // 나누어 떨어지면 i줄이라는 뜻
                int yellowWidth = Math.max(i, yellow/i); // 그 때의 노란색의 가로 개수
                int yellowHeight = Math.min(i, yellow/i); // 그 때의 노란색의 세로 개수
                // 아래는 갈색의 갯수를 구하는 수식 <<< 이게 실제 주어진 갈색 갯수랑 일치해야 함
                if((yellowWidth + yellowHeight) * 2 + 4 == brown){
                    // 갈색은 한겹이므로 +2
                    answer[0] = yellowWidth + 2; 
                    answer[1] = yellowHeight + 2;
                    return answer;
                }
            }
        }
        // 해당 안되면 아무거나 리턴
        return new int[2];
    }
}
