public static String solution(int[] food) {
  String answer = "";

  // 1. f[1]부터 순회
  for (int i = 1; i < food.length; i++) {
      // 2. f[i] / 2 의 몫 만큼 i를 문자열에 추가
      for (int j = 0; j < food[i] / 2; j++) {
          answer += i;
      }
  }

  // 3. 중간에 0 추가
  answer += 0 ;

  // 4. 현재 문자열의 0 이전 부분을 뒤집어서 추가
  for (int i = answer.length() -2; i >= 0; i-- ){
      // answer 문자열의 0 이전 인덱스부터 읽어서 하나씩 이어붙임.
      answer = answer + answer.charAt(i);
  }
  return answer;

}
