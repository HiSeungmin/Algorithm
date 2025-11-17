import java.util.*;
class Solution {
    public static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int start = 0, end=0, sum=sequence[0];
        int minNum = Integer.MAX_VALUE;

        while(start <= end && end < sequence.length){
            if(sum == k){
                if(minNum > end-start){
                    minNum = end-start;
                    answer[0] = start;
                    answer[1] = end;
                }
                end += 1;
                if(end>=sequence.length) break;
                sum += sequence[end];
            }else if(sum < k){
                end += 1;
                if(end>=sequence.length) break;
                sum += sequence[end];
            }else{
                sum -= sequence[start];
                start += 1;
            }
        }

        return answer;
    }
}