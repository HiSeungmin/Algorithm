import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount)    {
        int[] answer = new int[enroll.length];
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> cash = new HashMap<>();

        for(int i=0; i<enroll.length; i++){
            map.put(enroll[i], referral[i]);
        }

        for(int k=0; k< seller.length; k++){
            String sel = seller[k];
            int amnt = amount[k]*100;

            while(true){
                cash.put(sel, cash.getOrDefault(sel,0)+amnt-(int)(amnt*0.1));
                amnt *= 0.1;
                if(amnt<1||!map.containsKey(sel)||map.get(sel) == "-"){
                    break;
                }
                sel = map.get(sel);
            }
        }

        for(int i=0; i<enroll.length; i++){
            answer[i] = cash.containsKey(enroll[i])?cash.get(enroll[i]):0;
        }
        return answer;
    }
}