class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        // 가로 세로 중 긴 쪽의 크기를 추적
        int walletMax = Math.max(wallet[0], wallet[1]);
        int walletMin = Math.min(wallet[0], wallet[1]);
        int billMax = Math.max(bill[0], bill[1]);
        int billMin = Math.min(bill[0], bill[1]);
        
        while(billMax > walletMax || billMin > walletMin){
            // 반 접기
            billMax /= 2;
            answer++;
            // max, min 업데이트
            int newMax = Math.max(billMax, billMin);
            int newMin = Math.min(billMax, billMin);
            billMax = newMax;
            billMin = newMin;    
        }
        
        return answer;
    }
}
