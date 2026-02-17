import java.util.*;
class Solution {
    public static int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        for(int amt : d){
            if(budget<amt){
                break;
            }
            budget -= amt;
            answer += 1;
        }

        return budget>=0? answer:answer-1;
    }
}