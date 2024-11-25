import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        // 문자들을 큐에 담기
        Queue<Character> queue = new LinkedList<>();
        for(int i = 0; i< s.length(); i++){
            queue.add(s.charAt(i));
        }
        // 문제 로직 수행
        while(!queue.isEmpty()){
            char x = queue.poll(); // 첫 글자 x
            int xCount = 1; // x가 나온 횟수
            int otherCount = 0; // 다른 문자가 나온 횟수
            // 그 뒤로 쭉쭉 뽑기
            while(!queue.isEmpty()){
                char nextChar = queue.poll();
                if(nextChar == x){ // x가 또 나왔으면
                    xCount++;
                }else{ // x말고 다른 게 나왔으면
                    otherCount++;
                }
                // 큐가 비면 종료
                if(queue.isEmpty()) break;
                // 두 카운트가 같아지면 종료
                if(xCount == otherCount) break;
            }
            // 단어 하나 분할 완료
            answer++;
        }
        return answer;
    }
}
