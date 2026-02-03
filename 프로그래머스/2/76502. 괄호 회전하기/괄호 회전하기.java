import java.util.*;
class Solution {
    public static int solution(String s) {
        int answer=0;
        int strLen = s.length();

        for(int i=0; i<strLen; i++){
            answer += cal(s, i, strLen);
        }

        return answer;
    }

    private static int cal(String s, int strIdx, int strLen){

        Stack<Character> st = new Stack<>();

        for(int i=strIdx; i<strIdx+strLen; i++){
            int idx = i%strLen;
            char ch = s.charAt(idx);

            if(ch == '(' || ch == '{' || ch =='['){
                st.push(ch);
            }else if(ch == ')' || ch == '}' || ch ==']'){
                if(st.empty()){
                    return 0;
                }else if((st.peek() != '(' && ch == ')') || (st.peek() != '{' && ch == '}') || (st.peek() != '[' && ch == ']')){
                    return 0;
                }else{
                    st.pop();
                }
            }
        }
        if(!st.empty()) return 0;
        return 1;
    }
}