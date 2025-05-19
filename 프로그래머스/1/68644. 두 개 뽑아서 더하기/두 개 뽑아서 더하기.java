import java.util.*;

class Solution {
    public int[] solution(int[] arr) {

        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                set.add(arr[i]+arr[j]);
            }
        }

        return set.stream().sorted().mapToInt(Integer::intValue).toArray();

    }
}