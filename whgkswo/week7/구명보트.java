import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        // 몸무게 오름차순으로 정렬
        Arrays.sort(people);
        
        // 남은 사람 중 제일 가벼운 사람을 찾는 인덱스
        int from = 0;
        // 남은 사람 중 제일 무거운 사람을 찾는 인덱스
        int to = people.length - 1;
        
        while(from <= to){
            // 일단 제일 무거운 사람 타고
            int weight = people[to];
            to--;
            // 제일 가벼운 사람 태워보기
            if(weight + people[from] <= limit){
                // 보트에 공간 있으면
                from++; // 가벼운 사람 태우기
            }
            // 보트 출발
            answer++;
        }
        return answer;
    }
}
