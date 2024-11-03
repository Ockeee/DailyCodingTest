class Solution {
    private boolean[] visited;
    private int maxCount = 0;
    
    public int solution(int k, int[][] dungeons) {
        // 각 던전의 방문 여부를 나타내는 배열
        visited = new boolean[dungeons.length];
        
        // 초기 조건으로 재귀 시작
        dfs(dungeons, k, 0);

        return maxCount;
    }
    
    private void dfs(int[][] dungeons, int fatigue, int count){ 
        // 모든 던전에 대해 순회
        for(int i = 0; i< dungeons.length; i++){
            // 방문하지 않은 던전이고 피로도가 충분하면 탐색
            if(!visited[i] && fatigue >= dungeons[i][0]){
                // 탐색 실시
                visited[i] = true;
                maxCount = Math.max(maxCount, count + 1);
                // 변경된 조건으로 재귀 호출
                dfs(dungeons, fatigue - dungeons[i][1], count + 1);
                // 재귀 끝나면 백트래킹
                visited[i] = false;
            }
        }
    }
}
