class Solution {
    public int solution(int number, int limit, int power) {
      // 공격력 1당 철 1kg이므로 answer = 철 무게(= 공경력)
      // 약수를 먼저 구해야 한다.
      // 약수 갯수 먼저 구하기
        int answer = 0;
        for(int i=1; i<= number; i++){
            int count = 0;
            
            for(int j = 1; j * j <= i; j++){
                if(j * j == i)
                    count++;
                else if(i % j == 0)
                    count += 2;
            }

          // count가 limit를 넘으면 power로 치환
            if(count > limit)
                count = power;
            answer += count;
        }
      // 철 무게 = 공격력
        return answer;
    }
}
