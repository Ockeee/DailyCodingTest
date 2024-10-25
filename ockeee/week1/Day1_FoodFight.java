public class Day1_FoodFight {
   public String solution(int[] food) {

       // 물은 항상 0이므로
        String answer = "0";
       // 음식의 양이 홀수일 경우 짝수로 정리
        for(int i = 1; i<food.length; i++) {
            food[i] = food[i] - food[i] % 2;
        }
       // 역순을 순회하는 문자열
        for(int i = food.length - 1; i >= 1; i--) {
            // 각 음식의 절반만큼 반복
            for (int j = 0; j < food[i] / 2; j++)
                answer = i + answer + i;
        }
        return answer;
    }
}
