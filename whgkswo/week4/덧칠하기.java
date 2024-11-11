import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) { // 구역의 길이 n, 롤러 길이 m
        int answer = 0;

        // 덧칠해야 하는 구역들을 큐에 넣기
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i< section.length; i++){
            queue.add(section[i]);
        }
        
        while(!queue.isEmpty()){
            // 롤러 사용 횟수 1 증가
            answer++; 
            // 다음 구역 뽑기
            int num = queue.poll();
            // 거기부터 m칸 칠하기
            while(!queue.isEmpty() && queue.peek() < num + m){ // 지금 칠한 구역에서 롤러가 닿는다면
                // 같이 칠해버리기
                queue.poll();
            }
        }
        return answer;
    }
}
