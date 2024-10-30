class Solution {
    public String solution(int a, int b) {
        int[] maxDays = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayofWeeks = new String[]{"SUN","MON","TUE","WED","THU","FRI","SAT"};
        
        // 2015년 12월 31일로부터 며칠이 지났는지 알아야함
        int day = 0;
        // 지난달까지 최대 일수 더하기
        for(int i = 0; i < a - 1; i++){
            day += maxDays[i];
        }
        // 이번달 일수 더하기
        day += b;
        // 12월 31일 목요일을 기준으로 요일 구하기
        // (초기값 4(목요일) + 더해지는 요일(day % 7)) % 7 << 배열 인덱스 벗어나지 않게 나머지 연산
        String answer = dayofWeeks[(4 + day % 7) % 7];         
        return answer;
    }
}
