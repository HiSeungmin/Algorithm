import java.util.*;
class Solution {
    public static int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        for(int i : topping){
            right.put(i, right.getOrDefault(i, 0)+1);
        }

        for(int i=0; i<topping.length; i++){
            int k = topping[i];
            left.put(k, left.getOrDefault(k,0)+1);
            right.put(k, right.get(k)-1);
            if(right.get(k) == 0) right.remove(k);

            if(left.size() == right.size()) answer+=1;
        }
        return answer;
    }
}