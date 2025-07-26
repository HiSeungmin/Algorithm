import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        char last_word = words[0].charAt(words[0].length()-1);

        for (int i = 1; i < words.length; i++) {
            String w = words[i];
            if(last_word!=w.charAt(0) || set.contains(w)){
                answer[0] = (i+1)%n==0?n:(i+1)%n;
                answer[1] = i/n + 1;
                return answer;
            }
            set.add(w);
            last_word = w.charAt(w.length()-1);
        }
        return answer;
    }
}