class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int[] answer = new int[2]; // 크기가 2인 배열로 초기화

        for (int height = 3; height <= total / height; height++) {
            if (total % height == 0) {
                int width = total / height;

                if ((width - 2) * (height - 2) == yellow) {
                    answer[0] = width;
                    answer[1] = height;
                }
            }
        }
        return answer; 
    }
}

// 가로 세로는 무조건 3 이상. 노란색을 감싸야 하기 때문에.
// yellow = (w - 2) * (h - 2)
// total = brown + yellow
// for 문으로 i >= 3 부터 돌면서
// total / i === 0 이면 
// x = i, y = total / i 
// x * y = total 이고,
// (x - 2) * (y - 2) = yellow 이면
// x 와 y 를 비교해서 큰 수를 
// answer[0]에 넣고, 작은 수를 answer[1] 에 넣음. 
