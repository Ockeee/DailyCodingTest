import java.util.*;

class Solution {
    private Set<Integer> primes = new HashSet<>();
    
    public int solution(int[] nums) {       
        // 먼저 소수를 모두 구해야함
        // 소수를 어느 범위까지 구할 것인가
        Arrays.sort(nums);
        int max = nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
        // 소수 구하기
        for(int i = 2; i<= max; i++){
            if(isPrime(i)) primes.add(i);
        }
        
        // 3개를 골라 더하기
        int answer = 0;
        for(int i = 0; i< nums.length - 2; i++){
            for(int j = i + 1; j< nums.length - 1; j++){
                for(int k = j + 1; k< nums.length; k++){
                    // i, j, k 결정되면 3개의 값을 더하기
                    int sum = nums[i] + nums[j] + nums[k];
                    // 더한 값이 소수이면 카운트 증가
                    if(primes.contains(sum)) answer++;
                }
            }
        }
        
        return answer;
    }

    private boolean isPrime(int num){
        for(int i = 2; i<= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
