import java.util.*;
class Solution {
    public static int solution(String begin, String target, String[] words) {

        if(!Arrays.asList(words).contains(target)){
            return 0;
        }

        int[] dist = new int[words.length];

        for(int k=0; k<words.length; k++){
            dist[k] = 0;
        }

        Deque<String> deque = new ArrayDeque<>();
        deque.add(begin);


                
        while(!deque.isEmpty()){
            String word = deque.pop();
            int idx = Arrays.asList(words).indexOf(word);

            if(word.equals(target)){
                return dist[idx];
            }

            for(String str : words){
                int cnt = 0;
                int sIdx = Arrays.asList(words).indexOf(str);

                for(int i=0; i<str.length(); i++){
                    if(word.charAt(i) != str.charAt(i)){
                        cnt += 1;
                    }
                }
                if (cnt == 1 && dist[sIdx]==0){
                    deque.add(str);
                    dist[sIdx] = idx==-1? 1 : dist[idx]+1;
                }
            }
        }
        return 0;
    }
}