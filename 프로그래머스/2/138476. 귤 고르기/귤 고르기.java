import java.util.*;
class Solution {
    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i],0)+1);
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());

        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        for(Integer key : keySet){
            sum += map.get(key);
            answer += 1;
            if(sum >= k){ break; }
        }

        return answer;
    }
}