import java.util.*;

class Solution {
    // 소수 리스트
    private List<Integer> primes = new ArrayList<>();
    
    public int solution(int n) {
        int answer = 0;
        
        // 2이상 n이하에 대해 소수 검사
        for(int i = 2; i<= n; i++){
            if(isPrime(i)) answer ++; // 소수면 카운트 증가
        }
        return answer;
    }
    
    private boolean isPrime(int num){
        // 2이상 제곱근 이하 범위의 소수들로 나머지 연산 해보기
        for(int i = 0; i< primes.size(); i++){
            int prime = primes.get(i);
            if(prime > Math.sqrt(num)) break; // 제곱근까지만 검사하면 됨
            if(num % prime == 0) return false; // 나누어 떨어지면 소수가 아님
        }
        // 여기까지 오면 소수
        primes.add(num);
        return true;
    }
}
