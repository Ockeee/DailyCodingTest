class Solution {
    public int[] solution(int brown, int yellow) {
      
      // 1) 테투리를 제외한 넓이는 노란색 갯수 => (x-2)(y-2)
      // 2) x+y = (brown + 4) / 2
      // 3) xy = yellow + 4
      // 4) 테두리 두께는 무조건 1
      
      int[] result = new int[2];
        // 전체 크기부터
        int sum = brown + yellow;
        
        // 테두리가 있기 때문에 높이는 무조건 3으로 시작
        int x;
        int y = 3;
        
        // 가능한 x, y값 찾기
        while (true) {
          // 전체 갯수를 높이로 나눠서 나눠지지 않으면 높이 하나씩 늘려
            if (sum % y != 0) {
                y++;
                continue;
            }
            
            // 가로 길이는
            x = sum / y;
            
            // 테두리를 뺀 값의 넓이가 노란색 수와 같은지 비교
            if ((x-2) * (y-2) == yellow) {
                return new int[] {x,y};
            }
            y++;
        }
    }
}


// 원래 풀었던 방법 수학적을 접근 근의공식 활용
import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int a = (brown + 4) / 2;
        int b = yellow + 2 * x - 4; 
        int[] answer = {(int)(a + Math.sqrt(a*a - 4b))/2, (int)(a - Math.sqrt(a*a - 4*b))/2};
        return answer;
    }   
}
