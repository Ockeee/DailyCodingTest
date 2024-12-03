import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 크기별 수량을 나타내는 맵
        Map<Integer, Integer> sizeMap = new HashMap<>();
        
        for(int i = 0; i< tangerine.length; i++){
            if(sizeMap.containsKey(tangerine[i])){
                sizeMap.put(tangerine[i], sizeMap.get(tangerine[i]) + 1);
            }else{
                sizeMap.put(tangerine[i], 1);
            }
        }
        List<Integer> sizes = new ArrayList<>();
        // 사이즈별 갯수들을 리스트에 담은 후 내림차순(많은순)으로 정렬
        for(Map.Entry<Integer, Integer> entry : sizeMap.entrySet()){
            sizes.add(entry.getValue());
        }
        Collections.sort(sizes, Collections.reverseOrder());
        
        int amount = 0;
        int type = 0;
        // 상자에 차례대로 담기, 많은순으로 담으니까 가장 적은 종류로 담기 가능
        for(int i = 0; i< sizes.size(); i++){
            type++;
            amount += sizes.get(i);
            if(amount >= k){
                break;
            }
            
        }
        return type;
    }
}
