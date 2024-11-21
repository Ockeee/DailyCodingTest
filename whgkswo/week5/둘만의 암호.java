class Solution {    
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        // 스킵 대상을 제외한 알파벳들 만들기
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        String filteredAlphabets = "";
        for(int i = 0; i< alphabets.length(); i++){
            char c = alphabets.charAt(i);
            // 스킵 대상
            if(skip.contains(c + "")) continue;
            // 일반 알파벳
            filteredAlphabets += c;
        }
        // s 순회
        for(int i = 0; i< s.length(); i++){
            // 각 문자 추출
            char c = s.charAt(i);
            // 알파벳 바꿔서 넣기
            answer += getLaggedAlphabet(filteredAlphabets, c, index);
        }
        return answer;
    }
    
    // index만큼 뒤의 알파벳을 반환하는 메서드
    private static char getLaggedAlphabet(String alphabets, char c, int index){     
        // 처음 인덱스 번호
        int refIndex = alphabets.indexOf(c + "");
        // index만큼 뒤의 인덱스 번호
        int newIndex = (refIndex + index) % alphabets.length();
        // 결과 반환
        return alphabets.charAt(newIndex);
    }
}
