import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < ingredient.length ; i ++) {
            //stack 에 재료를 넣음. 
            stack.push(ingredient[i]);
            
            // 재료가 4개 이상 차면 
            if(stack.size() >= 4) {
                // 햄버거인지 확인.
                // 1 2 3 1 이 연속으로 들어 있어야 함. 
                int size = stack.size();
                if(stack.get(size - 4) == 1 &&
                   stack.get(size - 3) == 2 &&
                   stack.get(size - 2) == 3 &&
                   stack.get(size - 1) == 1) {
                       answer ++;
                       // 햄버거이면 스택에서 제거.
                       stack.pop();
                       stack.pop();
                       stack.pop();
                       stack.pop();
                   }
            }
        }
        
        return answer;
    }
}
