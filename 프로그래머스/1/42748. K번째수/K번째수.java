import java.util.*;

class Solution {
    public List<Integer> solution(int[] array, int[][] commands) {
        // int[] answer = {};
        List<Integer> answer = new ArrayList<>();

        for(int[] a : commands) {
            // System.out.println(Arrays.toString(a));
            int[] nums = new int[a[1]-a[0]+1];
            int k = 0;
            for(int i = a[0]-1; i<= a[1]-1; i++){
                nums[k] = array[i];
                k++;
            }

            Arrays.sort(nums);
            answer.add(nums[a[2]-1]);
        }

        return answer;
    }
}