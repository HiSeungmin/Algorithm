import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount)    {
         int[] answer = new int[enroll.length];
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> cash = new HashMap<>();

        for (int i = 0; i < enroll.length ; i++) {
            map.put(enroll[i], referral[i]);
        }

        for (int i = 0; i <seller.length ; i++) {
            String s = seller[i];
            int a = amount[i]*100;
            
            while(true){
                cash.put(s,cash.getOrDefault(s,0)+(a-(int)(a*0.1)));
                a = (int)(a*0.1);

                if(!map.containsKey(s) || map.get(s).equals("-")|| a<1) break;
                s = map.get(s);
            }

        }
        
        for (int i = 0; i <enroll.length ; i++) {
            answer[i] =cash.containsKey(enroll[i])?cash.get(enroll[i]):0;
        }

        return answer;
    }
}