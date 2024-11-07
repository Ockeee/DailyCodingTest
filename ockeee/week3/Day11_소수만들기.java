class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int count = 0;
        // 중복되지 않는 숫자를 조합을 선택할 수 있게
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    answer = nums[i] + nums[j] + nums[k];
                    if(setPrime(answer))
                    count++;
                }
            }
        }
        return count;
    }
  // setPrimge이 소수인지 확인하기 위해서
    public boolean setPrime(int num) {
        boolean setPrime = true;
        for(int i = 2; i <= num/2; i++) {
            if(num % i == 0) {
                setPrime = false;
                break;
            }
        }
        return setPrime;
    }
}
