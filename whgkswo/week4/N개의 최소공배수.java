import java.lang.Math;

class Solution {
    public int solution(int[] arr) {       
        // 사이즈 1이면 바로 리턴
        if(arr.length == 1) return arr[0];
        
        // 사이즈 2 이상이면
        // 0번, 1번 사이의 최소공배수 구하고 (두 수의 곱을 최대공약수로 나누면 최소공배수)
        int gcm = arr[0] * arr[1] / getGCD(arr[0], arr[1]);
        // 2번부터 하나씩 비교하면서 최소공배수 업데이트
        for(int i = 2; i< arr.length; i++){
            gcm = gcm * arr[i] / getGCD(gcm, arr[i]);
        }
        return gcm;
    }
    
    // 최대공약수 구하는 메서드 (유클리드 호제법)
    public static int getGCD(int a, int b){
        int numA = Math.max(a,b); // a,b중 큰거
        int numB = Math.min(a,b); // a,b중 작은거
        // b가 0이 될 때까지 반복
        while(numB != 0){ 
            int bowl = numA; // 변수를 임시로 옮겨담기 위한 세 번째 변수
            numA = numB; // a는 b로 교체
            numB = bowl % numB; // b는 a % b로 교체
        }
        return numA;
    }
}
