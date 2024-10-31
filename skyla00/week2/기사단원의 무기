class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] diversors = new int[number];
        // number를 보면서, number 까지의 모든 숫자들의 약수를 파악해야 함.
        // 약수를 구해서 약수 배열에다가 담음.
        for (int i = 1; i <= number; i++) {
            int count = 0;
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) count++;
                else if (i % j == 0) count += 2;
            }
            diversors[i - 1] = count;
        }
        
        // 그리고 limit 의 숫자를 보면서 limit를 초과하면 power의 숫자를 넣어서
        // 새로운 배열을 만들어 줌.
        int[] diversorsLimit = new int[number];
        for (int i = 0; i < diversors.length; i ++) {
            if(diversors[i] > limit) {
                diversorsLimit[i] = power;
            }
            else diversorsLimit[i] = diversors[i];
        }
        
        // 새로운 배열의 합을 answer 에 넣어줌. 
        for (int value : diversorsLimit) {
            answer += value;
        }

        return answer;
    }
}
