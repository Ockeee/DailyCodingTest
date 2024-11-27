class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        // 색깔 확인하기
        String color = board[h][w];
        
        // 상하좌우 색깔 확인
        for(Direction direction : Direction.values()){
            // 상하좌우 좌표 구하기
            int newH = h + direction.getDh();
            int newW = w + direction.getDw();
            
            // 배열 밖으로 나가는 경우 거르기
            if(newH < 0) continue;
            if(newH >= board.length) continue;
            if(newW < 0) continue;
            if(newW >= board[0].length) continue;
            
            // 나가지 않는다면
            if(board[newH][newW].equals(color)) answer++; // 색깔이 일치할 때 카운트 증가
        }
        return answer;
    }
    
    private enum Direction{
        LEFT(0, -1),
        RIGHT(0, 1),
        UP(-1, 0),
        DOWN(1, 0)
        ;
        
        private int dh;
        private int dw;
        
        private Direction(int dh, int dw){
            this.dh = dh;
            this.dw = dw;
        }
        private int getDh(){
            return this.dh;
        }
        private int getDw(){
            return this.dw;
        }
    }
}
