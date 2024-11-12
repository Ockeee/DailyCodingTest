import java.util.*;

class Solution {
    // 발음 가능한 단어 set
    private Set<String> words = new HashSet<>(){{
        add("aya");
        add("ye");
        add("woo");
        add("ma");
    }};
    public int solution(String[] babbling) {
        int answer = 0;
       
        // 입력을 순회하며 검사
        for(int i = 0; i< babbling.length; i++){
            // 이번 단어
            String currentWord = babbling[i];
            // 를 큐에 넣기
            Queue<Character> queue = new LinkedList<>();
            for(int j = 0; j< currentWord.length(); j++){
                queue.add(currentWord.charAt(j));
            }
            
            // 큐를 순회
            String str = ""; // set과 비교할 문자열
            String prevStr = ""; // 연속되는 발음을 검사할 문자열
            while(!queue.isEmpty()){
                // 한 글자식 큐에서 빼서 str에 더하기
                str += queue.poll();
                // 길이가 2 또는 3이 될 때마다 발음 가능한 단어인지 검사
                if(str.length() == 2){
                    if(words.contains(str)){
                        // 발음 가능하면
                        if(str.equals(prevStr)){
                            // 연속되는 발음은 불가능
                            break;
                        }else{
                            // 연속되는 발음이 아니면 str 초기화하고 계속 검사
                            prevStr = str;
                            str = "";
                        }
                    }
                }
                if(str.length() == 3){
                    if(words.contains(str)){
                        // 발음 가능하면
                        if(str.equals(prevStr)){
                            // 연속되는 발음은 불가능
                            break;
                        }else{
                            // 연속되는 발음이 아니면 str 초기화하고 계속 검사
                            prevStr = str;
                            str = "";
                        }
                    }else{
                        // 발음 불가능하면 while loop 종료
                        break;
                    }
                }
            }
            // while loop이 끝났는데 마지막 찌꺼기가 남아 있으면
            if(str.length() > 0) continue; // 발음 불가능한 단어
            
            // 여기까지 오면 발음 가능한 단어
            answer++;            
        }
        return answer;
    }
}
