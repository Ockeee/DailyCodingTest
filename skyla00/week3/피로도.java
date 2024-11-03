class Solution {
    // 전역변수 선언
    private static int max = 0;
    public int solution(int k, int[][] dungeons) {
        // 각 던전 방문에 대한 boolean 값을 담을 배열 이므로 크기는 던전 배열의 Length
        boolean[] visited = new boolean[dungeons.length];
        // 던전 탐험 시작 시 초기화.
        // 탐색할 배열, 방문 유무 확인 배열, 현재 피로도 k, 탐험한 던전 수 count 를 매개변수로 주어야 함.
        dfs(dungeons, visited, k, 0);
        return max;
    }
    
    private static void dfs (int[][]dungeons, boolean[] visited, int k, int count) {
        // 최대 탐험 던전 수 계산
        max = Math.max(max , count);

        for(int i = 0; i < dungeons.length; i ++ ) {
            // 방문하지 않았고(visited 가 false ) 피로도(k)가 
            // 해당 던전의 최소필요 피로도(dungeons[i][0]) 보다 크면 방문.
            if (!visited[i] && dungeons[i][0] <= k ) {
                visited[i] = true;
                // 체력을 줄이고, 방문한 던전 수 증가 시킨 뒤에, 그 다음 던전 방문.
                dfs(dungeons, visited, k - dungeons[i][1], count + 1);
                // 방문을 다 했으면, 백트랙킹
                visited[i] = false;
            }
        }
    }
    
}
