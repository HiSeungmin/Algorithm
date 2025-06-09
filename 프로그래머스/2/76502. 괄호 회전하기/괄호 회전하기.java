import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        int n = s.length();
        s += s;

        A:for(int i=0; i<n; i++){
            Stack<Character> st = new Stack<>();
            for(int k = i; k<i+n; k++){
                char c = s.charAt(k);

                if (!map.containsKey(c)){
                    st.push(c);
                }else if(st.isEmpty() || !st.pop().equals(map.get(c))){
                    continue A;
                }
            }

            if(st.isEmpty()){
                answer += 1;
            }
        }

        return answer;
    }
}