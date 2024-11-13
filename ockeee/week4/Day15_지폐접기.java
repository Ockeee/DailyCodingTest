import java.util.Arrays;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        // 지갑 크기를 모르기 때문에 wallet 배열에서 큰 값이 wallet[1], 작은 값이 wallet[0]
        Arrays.sort(wallet);
        
        // bill 배열도 마찬가지
        Arrays.sort(bill);
        
        // 지갑 크기를 모르기 때문에 큰 지폐는 큰 지갑보다 작아야 하고, 작은 지갑은 작은 지폐보다 커야하는 조건에서
        while (bill[1] > wallet[1] || bill[0] > wallet[0]) {
            // 큰 지폐가 크면 반으로 접고, 작은 지폐가 크면 반으로 접어서
            if (bill[1] >= bill[0]) {
                bill[1] = bill[1] / 2;
            } else {
                bill[0] = bill[0] / 2;
            }
            
            // bill 배열을 다시 큰 값이 [1], 작은 값이 [0] 되도록 정렬
            Arrays.sort(bill);
            answer++;
        }
        
        return answer;
    }
}
