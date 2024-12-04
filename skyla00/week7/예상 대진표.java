import java.lang.Math;

class Solution
{
    public int solution(int n, int a, int b) {
        int answer = 1;
        
        // a 와 b의 차이가 1이, 둘 중 최솟값이 홀수여야 반복문 끝남. 
        while ( !(Math.abs(a - b) == 1 && Math.min(a, b) % 2 == 1)) {
            if (a % 2 == 0 ) {
                // 짝수이면 
                a = a / 2;
            } else {
                // 홀수이면
                a = (a + 1) / 2;
            }
            
            if (b % 2 == 0 ) {
                // 짝수이면 
                b = b / 2;
            } else {
                // 홀수이면
                b = (b + 1) / 2;
            }
            
            answer ++ ;
        }

        return answer;
    }
}

// 무조건 왼쪽 홀수, 오른쪽 짝수.
// 1 - 2 가 붙으면 둘 중 누가 이기던 간에 이긴 참가자가 1번이 됨.
// 3 - 4 가 붙으면 둘 중 누가 이기던 간에 이긴 참가자가 2번이 됨.
// 5 - 6 이 붙으면 ~ 3번이 됨.
// 7 - 8 이 붙으면 ~ 4번이 됨.
// 3 참가자 > (3 + 1) / 2  = 2
// 7 참가자 > (7 + 1) / 2 = 4 
// a 와 b 가 차이가 1이 될 때까지 + 왼쪽 홀수, 오른쪽 짝수. 조건 될 때까지 반복. 
