class Solution {
    public int solution(int n) {
        int answer = 0;

        // for 문을 돌면서 1과 자기 자신으로 나누어지는 숫자가 있으면 answer에 ++ 함.
        // n = 5 이면, 2,3,4,5 를 확인하며 각각의 숫자가 소수인지 봐야 함.
        for (int i = 2; i <= n; i ++ ) {
            boolean isPrime = true;

            for (int j = 2; j <= Math.sqrt(i); j ++) {
                // 딱 나누어지는 숫자가 있으면 소수가 아님.
                if (i % j == 0 ) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                answer ++;
            }
        }
        return answer;
    }
}
