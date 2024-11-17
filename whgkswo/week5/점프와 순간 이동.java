import java.util.*;

public class Solution {
    public int solution(int n) {
        int fuel = 0;
        // 목적지부터 되짚어서 출발지로 고 백
        while(n > 0){
            // 짝수면 무조건 점프
            if(n % 2 == 0){
                n /= 2;
            }else{ // 홀수이면 뚜벅이(연료 소모)
                n--;
                fuel++;
                // 출발지로 돌아왔으면 종료
                if(n == 0){
                    return fuel;
                }
            } 
        }
        return fuel;
    }
}
