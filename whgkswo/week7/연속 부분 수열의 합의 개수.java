import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> values = new HashSet<>();
        // 부분 수열의 길이 1부터 끝까지
        for(int i = 1; i<= elements.length; i++){
            // 시작 인덱스 0부터 끝까지 조합해보기
            for(int j = 0; j< elements.length; j++){
                values.add(getSum(elements, j, i));
            }
        }
        // set에다 넣으면 가짓수가 나옴
        return values.size();
    }
    
    public static int getSum(int[] elements, int startIndex, int length){
        // 초기값은 시작 인덱스의 값
        int sum = elements[startIndex];
        // 다음 칸부터 순회하며 더하기
        for(int i = 1; i< length; i++){
            int index = startIndex + i;
            // 인덱스 넘어갔으면 다시 처음으로 돌아가기
            if(index >= elements.length){
                index -= elements.length;
            }
            sum += elements[index];
        }
        return sum;
    }
}
