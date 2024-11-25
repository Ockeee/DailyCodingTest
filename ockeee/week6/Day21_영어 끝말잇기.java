import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        List<String> list = new ArrayList<>();
        
        list.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            if (words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) {
                return new int[]{i - (i / n) * n + 1, i / n + 1};
            } else if (list.contains(words[i])) {
                return new int[]{i - (i / n) * n + 1, i / n + 1};
            } else list.add(words[i]);
        }
        
        return new int[]{0, 0};
    }
}
