import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";

      // s의 길이만큼 순회. c라는 char부터 체크
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
          //count는 알파벳 각각 index만큼 건너뛰었는지 체크하기위해
            int count = 1;

          // z를 넘어가면 아스키코드로 a 97 z 122 사이로 표현할 수 있는데, 26만큼 빼주면 됨
            while(count <= index){
                ++c;
                if(c > 'z')
                    c -= 26;

              //contains 함수를 써서 skip에 포함되면 count 증가 x, 포함되지 않으면 증가
                if(skip.contains(c+""))
                    continue;
                else
                    count++;
            }
            answer += c;
        }
        return answer;
    }
}
