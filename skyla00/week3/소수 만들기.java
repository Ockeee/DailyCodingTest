class Solution {
     public static int solution(int[] nums) {
        int answer = 0;


        // 3개씩 묶어서 더한 후에 
        for (int i = 0; i < nums.length - 2; i ++ ) {
            for (int j = i + 1 ; j < nums.length - 1; j ++ ) {
                for (int k = j + 1; k < nums.length; k ++){
                    int sum = nums[i] + nums[j] + nums[k];
                    // 소수 인지 판별
                    if (isPrime(sum)) {
                        answer ++;
                    }
                }
            }
        }

        return answer;
    }

    // 소수 판별하는 메서드를 따로 빼서 true 이면 answer ++ 함.
    private static boolean isPrime(int num){
        boolean isPrime = true;
        for (int j = 2; j <= Math.sqrt(num); j ++) {
            // 딱 나누어지는 숫자가 있으면 소수가 아님.
            if (num % j == 0 ) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
