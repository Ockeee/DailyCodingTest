import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] sameNum = new int[2];
        int result = 0;
        int countZero = 0;

        for (int lotto : lottos) {
            for (int num : win_nums){
                if (lotto == num) {
                    result++;
                    break;
                }
            }
        }
        for (int lotto : lottos) {
            if(lotto == 0 ){
                countZero++;
            }
        }
        
        answer[0] = score(result + countZero);
        answer[1] = score(result);
        return answer;
    }
    public static int score(int num) {
        switch (num) {
            case 6 : return 1;
            case 5 : return 2;
            case 4 : return 3;
            case 3 : return 4;
            case 2 : return 5;
            case 1 :
            case 0 :
                return 6;
        }
        return num;
    }
}
    
// 1. lotts 와 win_nums 의 숫자를 비교. > 최저 점수 파악. 
// 2. 0의 갯수 + 1번 > 최고 점수 파악. 
