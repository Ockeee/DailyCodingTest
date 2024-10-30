class Solution {
    public String solution(int a, int b) {
        int[] daysInMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayOfWeek = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

        // 해당 날이 1월 1일로부터 몇번째 날인지 계산하기 위함.
        int currentDays = b - 1 ;
        // a = 5 일 경우, 1월부터 4월까지 합산
        for (int i = 0; i < a - 1; i ++) {
            currentDays += daysInMonth[i];
        }

        String answer = dayOfWeek[currentDays % 7];

        return answer;
    }
}
