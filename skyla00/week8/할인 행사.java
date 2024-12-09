import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        // want 품목과 number 수량에 따라 wantMap 만들기
        Map <String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        
        int answer = 0;
        
        
        
        // 1일부터 돌면서 discountMap 만들기
        for (int i = 0; i < discount.length - 9 ; i ++) {
            // 10일에 해당하는 할인 품목을 넣는 map 만들기
            Map <String, Integer> discountMap = new HashMap<>();
            
            for (int j = i; j < i + 10; j ++ ) {
                discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0 ) + 1);
            }
            
            // 비교하기 
            if (isSame(wantMap, discountMap)) {
                answer++; 
            }
            
        }
        
        return answer;
    }
    
    private boolean isSame (Map<String, Integer> wantMap, Map<String, Integer> discountMap) {
        
        for (String want : wantMap.keySet()) {
            // 품목 같은지 확인 
            if (discountMap.containsKey(want)) {
                // 수량이 맞는지 확인
                if (discountMap.get(want) < wantMap.get(want)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true; 
    }
}
// wants 와 discount 의 10일 치. 를 비교하면서 일치하는 횟수를 count 하면 됨. 
// 1. wantMap
// 2. discount 의 품목을 돌면서 discountMap 을 만들기. 
// 3. discoumtMap 과 wantMap 의 수량과 품목 확인하기.
