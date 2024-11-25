import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {

      // 내가 가진 번호 중 0은 알수 없음. 따라서 0이 모두 당첨 번호와 일치한다고 가정하면 최고 등수를 계산할 수 있고, 무시하면 최저 등수를 계산할 수 있음.
       int zero_count=0;
       int same_count=0;
       int min_rank,max_rank;
        // 내 로또 번호 하나씩 확인
        for(int i = 0 ; i <lottos.length;i++){
            if(lottos[i]==0){
                zero_count++;
            }
          // 당첨 번호와 맞는지 확인
            for (int j = 0 ; j <win_nums.length;j++){
                if(lottos[i]==win_nums[j]){
                    same_count++;
                }
             }
        }
        
      min_rank = rank(same_count+zero_count);
      max_rank = rank(same_count);
    
        return new int []{min_rank,max_rank};
    }
    // 등수를 반환하는 메서드
    public int rank(int n){
        switch(n){
              case 6:
                return 1;
              case 5:
                return 2;
              case 4:
                return 3;
              case 3: 
                return 4; 
              case 2: 
                return 5;
              default :
                return 6;
        }
    }
}
