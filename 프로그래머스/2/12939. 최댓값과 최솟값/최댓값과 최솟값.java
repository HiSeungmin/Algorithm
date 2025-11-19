import java.util.*;
class Solution {
    public static String solution(String s) {
        String answer = "";
        String[] numArr = s.split(" ");
        int[] num = new int[numArr.length];
        int i=0;
        for(String str : numArr){
            num[i++] = Integer.parseInt(str);
        }
        int max = num[0];
        int min = num[0];

        for (int n : num) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        answer = min+" "+max;

        return answer;
    }
}