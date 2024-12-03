import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> tangCount = new HashMap<>();
        // map 을 돌면서 귤 크기 별로 몇 개 있는지 파악함.
        for (int tan : tangerine) {
            tangCount.put(tan, tangCount.getOrDefault(tan,0) + 1);
        }

        // 귤 갯수만 파악해서 list 에 넣기.
        List<Integer> counts = new ArrayList<>(tangCount.values());
        // 귤의 갯수 내림차순 정렬
        Collections.sort(counts, Collections.reverseOrder());


        // k 에서 귤 갯수 빼면서
        // answer 에 ++ 하면서 귤 크기 종류 갯수 파악.
        for (int count : counts) {
            k -= count ;
            answer++;
            if (k <= 0) {
                break;
            }
        }
        
        return answer;
    }
}

// map 으로 1 - 1, 2 - 2, 3 - 2, 4 - 1, 5 - 2 개 인 걸 확인하고,
// 크기별 count 정렬 후
// 상자에 넣기 시작.
// 하면서 k에서 갯수 빼기. k -= count
// 종류 몇개 들어갔는지 세기 answer ++; 
