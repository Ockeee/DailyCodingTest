import java.util.*;

class Solution {
    public long solution(int n) {
        // 목적지에 도착하는 가짓수는 n-1에서 한칸 뛰기 + n-2에서 두칸 뛰기
        // dp[n] = dp[n-1] + dp[n-2] -> 피보나치
        return fibo(n);
    }
    
    public static int fibo(int num){
        if(num == 1) return 1;
        if(num == 2) return 2;
        
        List<Integer> fibos = new ArrayList<>(){{
            add(1);
            add(2);
        }};
        for(int i = 2; i< num; i++){
            int next = fibos.get(i-2) + fibos.get(i-1);
            fibos.add(next % 1234567);
        }
        
        return fibos.get(fibos.size() - 1);
    }
}
