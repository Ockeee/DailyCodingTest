import java.util.*;

class Solution {
    public static int solution(int n, int m, int[] section) {
        int answer = 0;
        ArrayList<String> walls =new ArrayList<>();
        // 1부터 N 까지의 walls 의 초기값을 Y로 해 둔 뒤에,
        for (int i = 0; i <= n; i ++) {
            walls.add("Y");
        }

        // 덧칠해야 하는 section 이 있으면 N으로 바꿈.
        for (int i = 0; i < section.length; i ++) {
            walls.set(section[i], "N");
        }


        for (int i = 1; i <= n; i ++) {
                if(walls.get(i).equals("N")) {
                    // m만큼 덧칠.
                    for(int j = 0; j < m && (i+j) <= n; j ++) {
                        walls.set(i + j, "Y");
                    }
                    answer++;
                }
        }
        return answer;
    }
}
// 1. n의 배열의 상태를 판단해야 함. true false 로. 
// 2. section 에 있는 숫자는 false 로 바꿔서. 
// 3. m을 1부터 돌면서 확인을 함. 지나갈 때 false 인 건 true 로 바꿔줌. 
// 4. 한번 m을 실행 할 때마다 answe 에 ++ 함. 
// 5. 그리고 전체 배열을 확인해서 전체 배열이 ture 인지 봄. 
// 6. 아니면 그 다음 인덱스에서부터 출발해서 m 만큼 가기. 
// 7. 3,4,5  반복. 전체 배열이 Ture이면 그때 answer 반환하기. 
