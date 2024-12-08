class Solution {
    public long solution(int n) {
        long answer = 0;
        
        long num1 = 1;
        long num2 = 1;
        
        long result = 0;
        
        if (n == 1 ) return 1;
        
        for (int i = 2; i <= n; i ++) {
            // 피보나치 수열 
            result = (num1 + num2) % 1234567;
            num1 = num2;
            num2 = result;
        }
        
        
        return result;
    }
}
// n = 1 일 때, 1 >> 1
// n = 2 일 때, (1, 1), (2) >> 2
// n = 3 일 때, (1, 1, 1), (2, 1), (1, 2) >> 3
// n = 4 일 때, (1, 1, 1, 1), (2, 1, 1), (1, 2, 1), (1, 1, 2), (2, 2) >> 5
// n = 5 일 때, (1, 1, 1, 1, 1), (1, 1, 1, 2), (1, 1, 2, 1), (1, 2, 1, 1), (2, 1, 1, 1), (1, 2, 2), (2, 1, 2), (2, 2, 1) >> 8 

// 1 2 3 5 8 .... 피보나치 수열 
