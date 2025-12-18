import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String num = n+"";
        
        for(int i=0; i<num.length(); i++){
            int a = num.charAt(i)-'0';
            answer += a;
        }
        return answer;
    }
}