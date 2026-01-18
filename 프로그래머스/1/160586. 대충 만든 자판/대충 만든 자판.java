import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
       int[] answer = new int[targets.length];
       HashMap<Character, Integer> map = new HashMap<>();
            
        for(int i =0; i<keymap.length; i++){
            String key = keymap[i];
            for(int j=0; j< key.length(); j++){
                char ch = key.charAt(j);
                int press = j + 1;
                map.put(ch, Math.min(press, map.getOrDefault(ch,press)));
            }
        }
        int sum =0;
        for(int i =0; i<targets.length; i++){
            String target = targets[i];
            for(int j=0; j<target.length(); j++){
                 char ch = target.charAt(j);
                if(map.containsKey(ch)){
                    sum += map.get(ch);
                }else{
                    sum = -1;
                    break;
                }
            }
            answer[i] = sum;
            sum=0;
        }
        
        return answer;
    }
}