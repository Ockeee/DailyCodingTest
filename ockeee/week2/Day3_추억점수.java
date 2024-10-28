class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // 사진의 총 개수인 배열을 하나 먼저 만들어서
         int[] answer = new int[photo.length];

        // 1) 사진을 하나씩 먼저 확인
        for(int i=0; i<photo.length; i++) {
            // 2) 사진의 이름을 하나씩 확인
        	for(int j=0; j<photo[i].length; j++) {
                // 3) 이름을 검사 해서 사진[i],[j]와 이름[k]이 같으면 점수를 더해서 결과 도출
        		for(int k=0; k<name.length; k++) {
        			if(photo[i][j].equals(name[k])) answer[i] += yearning[k];
        		}
        	}
        }
        return answer;
    }
}
