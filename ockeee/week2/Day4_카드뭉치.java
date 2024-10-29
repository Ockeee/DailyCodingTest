class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // 카드 위치를 확인할 cardIndex와 card1과 card2의 문장의 길이(배열의 길이)를 저장할 IndexMax를 먼저
        int cardIndex1 = 0;
        int cardIndex1Max = cards1.length;
        int cardIndex2 = 0;
        int cardIndex2Max = cards2.length;

        // goal 배열을 확인하면서 현재 확인하고 있는 goal 배열의 카드를 currentCard에 담아
        for (int i = 0; i < goal.length; i++) {
            String currentCard = goal[i];

            // cards1 배열에서 현재 카드가 있는지 확인
            boolean inCards1 = false;
            if (cardIndex1 < cardIndex1Max) { // 배열안에서 확인
                if (currentCard.equals(cards1[cardIndex1])) { // 현재 카드가 cards1의 현재 카드와 같은지 확인
                    inCards1 = true;
                }
            }

            // cards2 배열에서 현재 카드가 있는지 확인
            boolean inCards2 = false;
            if (cardIndex2 < cardIndex2Max) { // 배열안에서 확인
                if (currentCard.equals(cards2[cardIndex2])) { // 현재 카드가 cards2의 현재 카드와 같은지 확인
                    inCards2 = true;
                }
            }

            if (inCards1) {
                // cards1에서 찾으면 cardIndex1 증가
                cardIndex1++;
            } else if (inCards2) {
                // cards2에서 찾으면 cardIndex2 증가
                cardIndex2++;
            } else {
                // 둘 다 아닌 경우, goal 배열을 만들 수 없으므로 No 반환
                return "No";
            }
        }

        return "Yes";
    }
}
