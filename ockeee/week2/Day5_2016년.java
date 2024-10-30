class Solution {
    public String solution(int a, int b) {
        // 반환할 요일을 담을 배열을 먼저 
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        // 월마다 일수가 다르기 때문에 일수를 순서대로 담을 배열도
        int[] months = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30};

        // 총 일수
        int total = 0;

        // 1월 1읿부터 돌아서 a-1월까지 모든 일수 더하기
        for(int i=0; i<a; i++) {
            total += months[i];
        }
        total += b;
        
        // 1월 1일이 금요일이기 때문에 + 4를 먼저 해서 금요일로 시작점 맞춰주고, 일주일을 나눠서 요일 확인.
        return days[(total + 4) % 7];
    }
}
