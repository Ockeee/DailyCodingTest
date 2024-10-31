class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        // 일단 약수 개수를 구해야지
        for(int i = 1; i<= number; i++){
            int divider = getDividers(i);
            // 만약 약수 개수가 limit를 넘겼다면 power만큼 철을 써야겠지
            answer += divider > limit ? power : divider;
        }
        
        return answer;
    }
    private int getDividers(int num){
        // 1부터 시작
        // i로 나누어 떨어지면, i는 약수고 num / i 도 약수임
        // i와 num / i가 서로 교차하는 순간 루프 종료
        
        int i = 1;
        int count = 0;
        while(i <= num / i){
            if(num % i == 0){
                count += i == num / i ? 1 : 2;
            }
            i++;
        }
        return count;
    }
}
