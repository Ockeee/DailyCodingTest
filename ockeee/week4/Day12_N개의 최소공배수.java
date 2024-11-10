import java.util.*;

class Solution {
    public int solution(int[] arr) {

      // 배열의 길이가 하나면 그게 바로 최소공배수 이므로 그대로 반환
        if(arr.length == 1) {
            return arr[0];
        }

      // 최소공배수를 0으로 먼저 두고, a와 b의 최소공배수를 계산
        int a = arr[0];
        int lcm = 0;
        for (int i = 1; i < arr.length; i++) {
            int b = arr[i];
          // j = a * b에서 시작해서 j--로 감소하면서 a와 b의 공통 배수인지 확인
            for (int j = a * b; j > 0; j--) {
              // j % a == 0 과 j % b == 0 이 만족하면 j는 a, b의 최소공배수
                if((j % a == 0) && (j % b == 0))
                    lcm = j;
            }
            a = lcm;
        }
        return lcm;
    }
}


// 아래는 위의 코드가 큰 수에서 작아지는 방식은 효율적이지 않다고 gpt가 수정해준 코드... 유클리드 호제법을 사용해서 a, b의 최대공약수를 구하는 방법?
// class Solution {
//     public int solution(int[] arr) {
//         if(arr.length == 1) {
//             return arr[0];
//         }
//         int lcm = arr[0];
//         for (int i = 1; i < arr.length; i++) {
//             lcm = lcm(lcm, arr[i]);
//         }
//         return lcm;
//     }

//     private int gcd(int a, int b) {
//         if (b == 0) return a;
//         return gcd(b, a % b);
//     }

//     private int lcm(int a, int b) {
//         return (a * b) / gcd(a, b);
//     }
// }
