// 주어진 피로도로 최대한 많은 던전 돌아야 함
// 2차원 배열 dungeons = [최소 필요 피로도, 소모 피로도]
// 어떤 던전을 도느냐에 따라 돌 수 있는 던전이 달라짐
// DFS(깊이 우선 탐색) 활용해야 함

class Solution {
    private int answer;
    private int K; // 최소 소요 피로도 체크를 위해
    private int[][] DungeonsInfo; // 던전 정보를 담을 2차원 배열 [최소 필요 피로도, 소모 피로도]
    private boolean[] visited; // 던전 돌았는지 체크할 배열
    private int[] list; // 던전을 돌 순서를 저장할 배열

    // 탐험할 모든 던전 순서를 고려해야. 순서에 따라서 최대 던전 갯수가 달라질 수 있으니까.
    public int solution(int k, int[][] dungeons) {
      answer = 0; // 처음에는 탐험한 던전이 없으므로
      K = k; // 초기 피로도 값을 K에
      DungeonsInfo = dungeons; // 던전 정보  
      visited = new boolean[dungeons.length]; // 던전을 방문했는지 확인하는 배열
      list = new int[dungeons.length]; // 던전을 돌 순서를 저장할 수 있게
      // 던전을 돌 순서를 찾기위해 dfs함수를 실행
      dfs(0);
      // 최대 던전 수 반환
      retunn answer;
    }

    // 최대한 많이 돌 방법을 찾기 위해서
    private void dfs(int depth) {
      // 던전 돌 순서를 정하는 사용할 메서드
      if (depth == DungeonsInfo) {
        ink k = K; // 피로도를 복사
        int count = 0; // 탐험한 던전 수
        // list에 순서대로 던전 돌기
        for (int dungeon : list) {
          // 현재 피로도가 던전의 최소 피로도보다 크거나 같다면 던전을 돌고 피로도를 사용하고 탐험한 던전 숫자 증가
          if (k >= DungeonsInfo[dungeon][0]) {
              k -= DungeonsInfo[dungeon][1];
              count++;
          }
          // 최대 던전수를 확인하고 갱신
          answer = Math.max(answer, count);
          return;
        }

        // 아직 돌지않은 던전이라면, 돌았던 던전을 돌았다고 표시하고 순서를 기록, dfs함수를 사용해 나머지 순서를 정하고 다시 돌지 확인.
        for (int i = 0; i < DungeonsInfo.length; i++) {
          if (!visited[i]) {
            visited[i] = true;
            list[depth] = i;
            dfs(depth + 1);
            visited[i]] = false;
          }
        }
    }
}
