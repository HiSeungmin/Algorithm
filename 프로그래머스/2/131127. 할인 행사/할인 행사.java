import java.util.*;
class Solution {
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        HashMap<String, Integer> wantMap = new HashMap<>();

        for(int i = 0; i<want.length; i++){
            wantMap.put(want[i], number[i]);
        }

        for(int i=0; i<discount.length-9; i++){
            HashMap<String, Integer> disMap = new HashMap<>();

            for(int k=i; k<i+10; k++){
                if(wantMap.containsKey(discount[k])){
                    disMap.put(discount[k], disMap.getOrDefault(discount[k],0)+1);
                }
            }
            if(wantMap.equals(disMap)){
                answer += 1;
            }
        }
        return answer;
    }
}