import java.util.*;
class Solution {
    public static String solution(String number, int k) {
        List<Integer> stack = new ArrayList<>();

        for(int i=0; i<number.length(); i++){
            int a =number.charAt(i) - '0';

            while(stack.size()>0 && stack.get(stack.size()-1) < a && k>0){
                stack.remove(stack.size() - 1);
                k-=1;
            }
            stack.add(a);
        }
        
        while (k > 0) {
            stack.remove(stack.size() - 1);
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for (int a : stack) {
            sb.append(a);
        }

        return sb.toString();
    }
}