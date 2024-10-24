public class Day1_FoodFight {
    public String solution(int[] food) {
        // 순 + 0 + 역순 이렇게 만들면 되겠다 생각하였음
        
        // 가운데는 항상 0이기 때문에
        String answer = "0";
        
        // 앞인 순 먼저
        for(int i = 1; i<food.length; i++) {
            // 2로 나눠지지 않는 애들은 정리
            int halfLength = food[i] / 2;
            // 역순 순회
            for (int j = 0; j < halfLength; j++) {
                // 처음 생각했던 순 + 0 + 역순으로 종결
                answer = i + answer + i;
            }
        }

        return answer;
    }
}
