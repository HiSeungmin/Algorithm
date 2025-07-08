import java.util.*;
class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int next = 27;

        for(int i=1; i<27; i++){
            map.put(String.valueOf((char) (i+64)), i);
        }

        String w = String.valueOf(msg.charAt(0));
        char c;
        for(int k = 1; k<msg.length(); k++){
            c = msg.charAt(k);

            String check = String.valueOf(w+c);
            if(!map.containsKey(check)){
                map.put(check, next++);
                answer.add(map.get(w));
                w = String.valueOf(c);
            }else{
                w = check;
            }
        }

        answer.add(map.get(w));

        return answer.stream().mapToInt(i -> i).toArray();
    }
}