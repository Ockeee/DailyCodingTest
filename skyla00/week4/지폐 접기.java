class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        int walletLong = Math.max(wallet[0], wallet[1]);
        int walletShort = Math.min(wallet[0], wallet[1]);
        int billLong = Math.max(bill[0], bill[1]);
        int billShort = Math.min(bill[0], bill[1]);

        
        while (billLong > walletLong || billShort > walletShort) {
                // 항상 길이가 긴 쪽을 반으로 접는다. 
                billLong = billLong / 2;
                answer++;

            //짧은 쪽이 숫자가 더 크면 업데이트
            if (billLong < billShort) {
                int i = billLong;
                billLong = billShort;
                billShort = i;
            }
        }

        return answer;
    }
}
