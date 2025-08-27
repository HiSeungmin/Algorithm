import java.util.*;
class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int b = 0;
        for(int[] com : commands){
            int i = com[0]-1;
            int j = com[1];
            int k = com[2]-1;
            int[] arr = new int[j-i];
            int a=0;
            for(int s = i; s<j; s++){
                arr[a++] = array[s];
            }

            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));
            answer[b++] = arr[k];

        }

        return answer;
    }
}