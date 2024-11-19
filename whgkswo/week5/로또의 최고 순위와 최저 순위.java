import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        
        // 찍은 번호 셋에 담기
        Set<Integer> lottoSet = new HashSet<>();
        for(int i = 0; i< lottos.length; i++){
            if(lottos[i] > 0) lottoSet.add(lottos[i]);
        }
        // 당첨번호 셋에 담기
        Set<Integer> winSet = new HashSet<>();
        for(int i = 0; i< win_nums.length; i++){
            winSet.add(win_nums[i]);
        }
        // 0 제외 확실히 맞춘 번호 개수 구하기
        int score = 0;
        for(int num : lottoSet){
            if(winSet.contains(num)) score++;
        }
        // 0으로 찍힌 게 다 맞았을 때 갯수
        int maxScore = score + winSet.size() - lottoSet.size();
        
        // 최고 순위와 최저 순위 반환
        return new int[]{getRank(maxScore), getRank(score), };
    }
    
    // 맞춘 갯수에 따라 순위 반환하는 메서드
    private static int getRank(int score){
        switch(score){
            case 2:
                return 5;
            case 3:
                return 4;
            case 4:
                return 3;
            case 5:
                return 2;
            case 6 :
                return 1;
            default:
                return 6;
        }
    }
}
