import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        // 맨 뒤가 최댓값.

        int idx = 0;

        for (int i = people.length - 1;  i >= 0; i--) {
            // 만약 이미 보트에 탄 사람이면
            if(people[i] == 1) continue;

            // 가장 가벼운 사람 + 무거운 사람 <= 제한
            if (people[i] + people[idx] <= limit ) {
                people[i] = 1;
                people[idx] = 1;
                idx++;
                answer ++;
            } else {
                people[i] = 1;
                answer ++;
            }

        }
        return answer;
    }
}
