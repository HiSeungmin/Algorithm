import java.util.*;

class Solution {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<skill.length(); i++){
            char ch = skill.charAt(i);
            map.put(ch, i);
        }

        for(String str:skill_trees){
            int cur_num = 0;
            boolean flag = true;
            for(int k=0; k<str.length(); k++){
                if(map.containsKey(str.charAt(k))){
                    if(!(map.get(str.charAt(k)) == cur_num)){
                        flag = false;
                        break;
                    }
                    cur_num += 1;
                }
            }
            if(flag){
                answer += 1;
            }
        }

        return answer;
    }
}