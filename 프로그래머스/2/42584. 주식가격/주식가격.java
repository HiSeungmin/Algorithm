import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for(int i=1; i<len; i++){
            if(st.isEmpty()){
                st.push(i);
            }else{
                if(prices[st.peek()] > prices[i]){
                    while(!st.isEmpty() && prices[st.peek()] > prices[i]){
                        int p = st.pop();
                        answer[p] = i-p;
                    }
                    st.push(i);
                }else{
                    st.push(i);
                }
            }
        }

        if(!st.isEmpty()){
            for(int i : st){
                answer[i] = len-1-i;
            }
        }

        return answer;
    }
}