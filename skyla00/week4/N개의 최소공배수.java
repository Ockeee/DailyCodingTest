class Solution {
    public static int solution(int[] arr) {
        int answer = arr[0];
        for ( int i = 1; i < arr.length; i ++) {
            int n = answer;
            int m = arr[i];
            // anser 에 최소공배수를 누적하여 저장. 
            answer = (answer * m) / gcd(answer, m);
        }
        return answer;

    }

  // 유클리드 호제법 gcd 
    private static int gcd (int n, int m) {
        int r;
        while(m > 0) {
            r = n % m;
            n = m ;
            m = r;
        }
        return n;
    }
}
