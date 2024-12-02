import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        // 버거 스택을 담는 스택 -> 내부 스택 하나가 버거 하나. 괄호 안에 괄호가 중첩되는 것과 유사한 구조
        Stack<Stack<Integer>> stack = new Stack<>();

        // 입력 배열 순회
        for(int i = 0; i< ingredient.length; i++){
            
            // 이번 재료가
            switch(ingredient[i]){
                case 1: // 빵이면
                    if(!stack.isEmpty() && !stack.peek().isEmpty() 
                       && stack.peek().peek() == 3){ // 이전 재료가 고기면
                        // 버거 완성
                        stack.pop();
                        answer++;
                    }else{ // 아니면 새로운 스택 생성
                        Stack<Integer> newStack = new Stack<>();
                        newStack.push(ingredient[i]);

                        stack.push(newStack);                       
                    }
                    break;
                case 2: // 야채면
                    if(!stack.isEmpty() && !stack.peek().isEmpty() 
                       && stack.peek().peek() == 1){ // 이전 재료가 빵이면
                        stack.peek().push(ingredient[i]); // 야채 넣기
                    }else{ // 이전 재료와 순서상 연결되지 않는 재료는 전체 스택을 못 쓰게 만듦
                        stack.clear();
                    } 
                    
                    break;
                case 3: // 고기면
                    if(!stack.isEmpty() && !stack.peek().isEmpty() 
                       && stack.peek().peek() == 2){ // 이전 재료가 빵이면
                        stack.peek().push(ingredient[i]); // 야채 넣기
                    }else{ // 이전 재료와 순서상 연결되지 않는 재료는 전체 스택을 못 쓰게 만듦
                        stack.clear();
                    }
                    break;
            }
        }
        return answer;
    }
}
