import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        // 원하는 물건을 맵에 담기 (키: 물건 이름, 값: 수량)
        Map<String, Integer> wants = new HashMap<>(){{
            for(int i = 0; i< want.length; i++){
                put(want[i], number[i]);
            }
        }};
        
        // 실제 할인 품목만 담는 장바구니 맵 (wants랑 일치해야 함)
        Map<String, Integer> carts = new HashMap<>(){{
            for(int i = 0; i< 10; i++){ // 첫 10일의 할인 품목 담기
                if(containsKey(discount[i])){
                    put(discount[i], get(discount[i]) + 1);
                }else{
                    put(discount[i], 1);
                }
            }
        }};
        // 첫날 상태체크
        if(isValidDay(wants, carts)) answer++;
        
        // 하루씩 진행하면서 장바구니 품목 수정
        for(int i = 10; i< discount.length; i++){
            // 다음날 품목 추가
            if(carts.containsKey(discount[i])){
                carts.put(discount[i], carts.get(discount[i]) + 1);
            }else{
                carts.put(discount[i], 1);
            }
            // 첫날 품목 삭제
            if(carts.get(discount[i-10]) == 1){ // 딱 하나 있으면
                carts.remove(discount[i-10]); // 키 삭제          
            }else{
                carts.put(discount[i-10], carts.get(discount[i-10]) - 1);
            }
            // 해당 일자 상태체크
            if(isValidDay(wants, carts)) answer++;
        }
        
        return answer;
    }
    
    private static boolean isValidDay(Map<String, Integer> wants, Map<String, Integer> carts){
        // wants가 carts 안에 완전히 포함돼야 함
        for(String want : wants.keySet()){
            // 장바구니에 아예 없거나
            if(!carts.containsKey(want)) return false;
            // 수량이 모자라면 false 반환
            if(carts.get(want) < wants.get(want)) return false;
        }
        return true;
    }
}
