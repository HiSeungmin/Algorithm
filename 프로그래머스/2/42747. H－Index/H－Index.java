import java.util.*;
class Solution {
    public static int solution(int[] citations) {
        int answer = 0;

        Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (a, b) -> Integer.compare(b, a));

        for(int i=0; i<arr.length; i++){
            if(i+1 <= arr[i]){
                answer = i+1;
            }
        }
        return answer;
    }
}