import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        Stack<String> st1 = new Stack<>();
        Stack<String> st2 = new Stack<>();

        for(int i=cards1.length-1; i>-1; i--){
            st1.push(cards1[i]);
        }

        for(int i=cards2.length-1; i>-1; i--){
            st2.push(cards2[i]);
        }

        for(int k=0; k<goal.length; k++){
            if(!st1.isEmpty() && st1.peek().equals(goal[k])){
                st1.pop();
            }else if(!st2.isEmpty() && st2.peek().equals(goal[k])){
                st2.pop();
            }else{
                return "No";
            }
        }

        return "Yes";
    }
}