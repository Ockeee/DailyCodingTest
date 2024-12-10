import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        // s를 계속 회전시키며 체크
        for(int i = 0; i< s.length(); i++){
            if(isValid(rotate(s, i))){
                answer++;
            }
        }
        return answer;
    }
    
    // 문자열을 amount만큼 왼쪽으로 회전 rotate(abcde, 2) = "cdeab"
    public static String rotate(String str, int amount){
        return str.substring(amount) + str.substring(0, amount);
    }
    
    public boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i< str.length(); i++){
            char c = str.charAt(i);
            
            if("({[".contains(c + "")){ // 여는 괄호를 만났을 때
                // 괄호 추가
                stack.push(c);
            }else{ // 닫는 괄호를 만났을 때
                if(stack.isEmpty() || getClosingBracket(stack.peek()) != c){
                    // 괄호 짝이 안맞으면 노인정
                    return false;
                }
                // 괄호 닫기
                stack.pop();
            }
        }
        return stack.isEmpty(); // 괄호가 전부 닫혀야 인정
    }
    public static char getClosingBracket(char c){
        switch(c){
            case '(':
                return ')';
            case '{':
                return '}';
            case '[':
                return ']';
        }
        return '뷁';
    }
}
