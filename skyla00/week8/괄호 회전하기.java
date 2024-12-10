import java.util.LinkedList; 
import java.util.Queue;
import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        // 문자열을 char 형 배열로 바꿔서 큐에 집어 넣기 
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            queue.offer(c);
        }
        
        for (int i = 0; i < s.length(); i ++ ) {
            // 만약 괄호가 다 닫혀 있다면 answer에 ++ 
            if (isCorrect(queue)) {
                answer ++;
            }
            // 맨 앞의 괄호를 맨 뒤로 넣기.
            queue.offer(queue.poll());
        }
        
        return answer;
    }
    
    // 그 큐를 검사함. 
    // (), {}, [] 를 확인하는 메서드가 필요함. 
    // ( 다음에 ) 가 있는지 { 다음에 } 가 있는지 [ 다음에 ] 가 있는지...
    public boolean isCorrect (Queue<Character> queue) {
        Stack<Character> stack = new Stack<>();

        for (char c : queue) {
                    // 열린 괄호이면 stack 에 넣기.
            if ( c == '(' || c == '[' || c == '{' ) {
                stack.push(c);
            } else {
                // 닫힌 괄호가 있으면 짝이 맞는지 검사. 
                // 닫힌 괄호가 있는데, 열린 괄호가 없으면 false
                if (stack.isEmpty()) {
                    return false; 
                }
                
                if ( c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else 
                    return false;
            }
            
        }
        
        // 스택이 다 비면 true
        return stack.isEmpty();
    }
}
