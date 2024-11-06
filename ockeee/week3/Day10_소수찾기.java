class Solution {
    public int solution(int n) {
        int answer = 0;

      // 1) 소수인지 확인하기 위해 boolean으로 먼저 확인
        for(int i = 2;  i <= n; i++) {
            boolean isPrime = true;
            // 2) 숫자 i의 약수 중 하나가 i의 제곱근 이하에 반드시 존재하기 때문에 제곱근보다 큰 숫자는 검사할 필요가 없음
            for(int j = 2; j * j <= i; j++) {
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) { 
                answer++;
            }
        }
        return answer;
    }
}
