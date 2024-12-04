import java.lang.Math;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int round = 1;
        // a와 b의 번호가 1 차이날 때까지(둘이 만날 때까지) 반복, 단 둘 중 오른쪽에 있는 게 짝수여야 함.
        // 2,3은 만난 게 아니고 3,4는 만난것. 4,5는 만난 게 아니고 5,6은 만난것
        while(Math.abs(a-b) != 1 || Math.max(a,b) % 2 != 0){
            // 홀수면 반으로 나눈 후 +1, 짝수면 반으로 나누기
            // 이번 라운드에서 3번이었다면 다음 라운드에선 2번이 돼야 함
            // 이번 라운드에서 6번이었다면 다음 라운드에선 3번이 돼야 함
            a = a % 2 == 0 ? a / 2 : a / 2 + 1;
            b = b % 2 == 0 ? b / 2 : b / 2 + 1;

            round++;
        }
        
        return round;
    }
}
